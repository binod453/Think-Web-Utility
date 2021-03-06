package com.mps.think.utility.controller;

import static com.mps.think.utility.utils.Constants.EXPIRATION_TIME;
import static com.mps.think.utility.utils.Constants.SECRET;
import static com.mps.think.utility.utils.Constants.TOKEN;

import java.io.InputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mps.think.utility.model.DynamicRenewalCodeModel;
import com.mps.think.utility.model.LoginModel;
import com.mps.think.utility.service.DynamicRenewalCodeService;
import com.mps.think.utility.utils.SecurityConstants;

import Think.XmlWebServices.Dynamic_price_select_responseDynamic_price;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm; 


@Controller
public class LoginController {

	private static final String SUCCESS = SecurityConstants.SUCCESS;
	private static final String STATUS = SecurityConstants.STATUS;
	private static final String ERROR = SecurityConstants.ERROR;

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	DynamicRenewalCodeService dynamicRenewalCodeService;
	
//	@Value(value = "spring.config.location")
//	String xmllFile;

	@RequestMapping(value = { "/" })
	public String login(Model model) {
		LoginModel loginModel = new LoginModel();
		model.addAttribute("loginModel", loginModel);
		String data = dynamicRenewalCodeService.getDSNLists("DSNLists.xml");
		List<String> dsnListsdata = new ArrayList<String>();
		List<String> dsnLists = new ArrayList<String>();
		List<String> uri = new ArrayList<String>();
		if(StringUtils.isNotBlank(data)) {
			dsnListsdata = Arrays.stream(data.trim().split("\n\t\t")).filter(s->!s.trim().startsWith("http")).collect(Collectors.toList());
			uri = Arrays.stream(data.trim().split("\n\t\t")).filter(s->s.trim().startsWith("http")).collect(Collectors.toList());
		}
		for(String s : dsnListsdata) {
			//if(s.contains("\n\t\n\t")) {
				dsnLists.add(s.trim());
			//}
		}
		HttpSession session = request.getSession();
		session.setAttribute("dsnLists", dsnLists);
		session.setAttribute("soapURI", uri);
		return "login";
	}

	@RequestMapping(value = "/dynamicRenewalCodes")
	public String login(@RequestParam(value = "username") String username,
						@RequestParam(value = "password") String password,
						@RequestParam(value = "dsn") String dsn,
						
						@RequestParam(value = "ipAddress") String ipAddress,
						@ModelAttribute("loginModel")LoginModel loginModel, 
			  BindingResult result,  ModelMap model) {
		
		HttpSession session = request.getSession();
		loginModel.setSoapAddress(ipAddress);
		boolean authenticationStatus = false;
		if(result.hasErrors()) {
			return "login";
		}else {
			try {			
				authenticationStatus = dynamicRenewalCodeService.getAuthenticationStatus(loginModel);
				if(authenticationStatus) {
					String jwtToken = Jwts.builder()
			                .setSubject(loginModel.getUsername())
			                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
			                .signWith(SignatureAlgorithm.HS512, SECRET)
			                .compact();
					
					session.setAttribute("loginModel", loginModel);
					session.setAttribute(TOKEN,jwtToken);
					model.addAttribute("loginModel", loginModel);
					
				}else {
			    	model.addAttribute("message", "Invalid Credentials");
			    	return "login";
			    }
				
			}catch(Exception e) {
				LOGGER.error(ERROR + e);
			}
			session.setAttribute(STATUS, authenticationStatus);
			return "redirect:getRenewalCode";
		}
		
	}
	
	@RequestMapping(value = "/getRenewalCode")
	public String getRenewalCode( ModelMap model ) {
		try {
			LoginModel userDetails = (LoginModel) request.getSession().getAttribute("loginModel");
			
			List<Dynamic_price_select_responseDynamic_price> codeModelList = dynamicRenewalCodeService.getDynamicCodesList(userDetails);
			DynamicRenewalCodeModel codeModel = new DynamicRenewalCodeModel();
			model.addAttribute("dynamicRenewalCodeModel", codeModel);
			model.addAttribute("codeModelList", codeModelList);
			
			List<String> priceNameList = codeModelList.stream().map(e -> e.getDynamic_price_name().toLowerCase()).collect(Collectors.toList());
			model.addAttribute("priceNameList", priceNameList);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "dynamicRenewalCodeList";
	}
	

	@RequestMapping(value = "/addNewRenewalCode")
	public String addNewRenewalCode(@ModelAttribute("dynamicRenewalCodeModel")DynamicRenewalCodeModel dynamicRenewalCodeModel, 
			  BindingResult result,  ModelMap model) {
		
		HttpSession session = request.getSession();
		int status=0;
		int maxCodeId = 0;
		try {
			LoginModel loginModel = (LoginModel) request.getSession().getAttribute("loginModel");
			dynamicRenewalCodeModel.setLoginModel(loginModel);
			maxCodeId = dynamicRenewalCodeService.getMaxCodeId(loginModel);
			dynamicRenewalCodeModel.setSlNo(maxCodeId+1);
			
			status = dynamicRenewalCodeService.addNewDynamicRenewalCode(dynamicRenewalCodeModel);
			model.addAttribute("dynamicRenewalCodeModel", dynamicRenewalCodeModel);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		if(status > 0) {
			model.addAttribute("duplicateData", "Please Enter Unique Dynamic Renewal Code");
			return "redirect:getRenewalCode";
		}else {
			return "redirect:getRenewalCode";
		}
	}
	
	@RequestMapping(value = "/editNewRenewalCode/{id}")
	@ResponseBody
	public DynamicRenewalCodeModel editNewRenewalCode(@PathVariable int id,@ModelAttribute("dynamicRenewalCodeModel")DynamicRenewalCodeModel dynamicRenewalCodeModel, 
			  BindingResult result,  ModelMap model, HttpServletRequest request) {
		
		DynamicRenewalCodeModel codeModel = new DynamicRenewalCodeModel();
		LoginModel userDetails = (LoginModel) request.getSession().getAttribute("loginModel");
		
		try {
			codeModel = dynamicRenewalCodeService.getDynamicCodesById(userDetails,id);
			
		} catch (RemoteException | ServiceException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("dynamicRenewalCodeModelById", codeModel);
		request.getSession().setAttribute("dynamicRenewalCodeModelById", codeModel);
		return codeModel;
	}
	
	@RequestMapping(value = "/saveUpdatedRenewalCode")
	public String saveUpdatedRenewalCode(@RequestParam("editedId") int id,@ModelAttribute("dynamicRenewalCodeModel")DynamicRenewalCodeModel dynamicRenewalCodeModel, 
			  BindingResult result,  ModelMap model) {
		
		int status=0;
		int maxCodeId = 0;
		try {
			LoginModel loginModel = (LoginModel) request.getSession().getAttribute("loginModel");
			dynamicRenewalCodeModel.setLoginModel(loginModel);
			dynamicRenewalCodeModel.setSlNo(id);
			
			status = dynamicRenewalCodeService.updateDynamicRenewalCode(dynamicRenewalCodeModel);
			model.addAttribute("dynamicRenewalCodeModel", dynamicRenewalCodeModel);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		if(status <= 0) {
			 
		}else {
			 
		}
		return "redirect:getRenewalCode";
	}

	@RequestMapping("/logout")
	public String destroySession(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/";
	}
}
