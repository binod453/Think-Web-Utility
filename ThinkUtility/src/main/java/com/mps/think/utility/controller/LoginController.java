package com.mps.think.utility.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.xml.rpc.ServiceException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mps.think.utility.model.DynamicRenewalCodeModel;
import com.mps.think.utility.model.LoginModel;
import com.mps.think.utility.service.DynamicRenewalCodeService;
import com.mps.think.utility.utils.Constants;
import com.mps.think.utility.utils.SecurityConstants;

import Think.XmlWebServices.Dynamic_price_select_responseDynamic_price_select; 


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

	@RequestMapping(value = { "/" })
	public String login(Model model) {
		LoginModel loginModel = new LoginModel();
		model.addAttribute("loginModel", loginModel);
		return "login";
	}

	@RequestMapping(value = "/dynamicRenewalCodes")
	//@ResponseBody
	public String login(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password,@RequestParam(value = "dsn") String dsn,@Valid @ModelAttribute("loginModel")LoginModel loginModel, 
			  BindingResult result,  ModelMap model) {
		
		ModelAndView modelAndView = new ModelAndView();
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>(); 
		if(result.hasErrors()) {
			return "login";
		}else {
			try {			
				HttpSession session = request.getSession();
				 StringBuilder url = new StringBuilder(Constants.LOGIN_URL);
				 HttpPost post = new HttpPost(url.toString());
				 List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
				   urlParameters.add(new BasicNameValuePair("username", username));
				   urlParameters.add(new BasicNameValuePair("password", password));
				   post.setEntity(new UrlEncodedFormEntity(urlParameters));
				    
				   HttpClient client = HttpClientBuilder.create().build();
				   HttpResponse response = client.execute(post);
				   HttpEntity entity = response.getEntity();
				   if(entity!=null) {
					    String responseString = EntityUtils.toString(entity, "UTF-8");
					    Gson gson = new Gson();
					    JsonElement element = gson.fromJson (responseString, JsonElement.class);
					    JsonObject jsonObj = element.getAsJsonObject();
					    if("OK".equals(jsonObj.get("Status").getAsString())) {
					    	LoginModel userDetails = dynamicRenewalCodeService.setLoginDetails(jsonObj);
					    	userDetails.setPassword(password);
					    	userDetails.setDsn(dsn);
					    	
							modelAndView.addObject(userDetails);
							session.setAttribute("loginModel", userDetails);
							
							model.addAttribute("loginModel", loginModel);
							
					    }
					    else {
					    	responseObject.put(STATUS,ERROR);
					    	model.addAttribute("message", "Invalid Credentials");
					    	return "login";
					    }
					}else {
						responseObject.put(STATUS,ERROR);
						model.addAttribute("message", "Invalid Credentials");
						return "login";
					}
				   
			}catch(Exception e) {
				LOGGER.error(ERROR + e);
				responseObject.put(STATUS,ERROR+e);
			}
			return "redirect:getRenewalCode";
		}
		
	}
	
	@RequestMapping(value = "/getRenewalCode")
	public String getRenewalCode( ModelMap model ) {
		try {
			LoginModel userDetails = (LoginModel) request.getSession().getAttribute("loginModel");
			
			List<Dynamic_price_select_responseDynamic_price_select> codeModelList = dynamicRenewalCodeService.getDynamicCodesList(userDetails);
			DynamicRenewalCodeModel codeModel = new DynamicRenewalCodeModel();
			model.addAttribute("dynamicRenewalCodeModel", codeModel);
			model.addAttribute("codeModelList", codeModelList);
			
			List<String> priceNameList = codeModelList.stream().map(e -> e.getDynamic_price_name()).collect(Collectors.toList());
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

	@PostMapping("/logout")
	public String destroySession(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/";
	}
}
