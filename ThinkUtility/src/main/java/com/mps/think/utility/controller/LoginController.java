package com.mps.think.utility.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mps.think.utility.model.DynamicRenewalCodeModel;
import com.mps.think.utility.model.LoginModel;
import com.mps.think.utility.model.paging.Page;
import com.mps.think.utility.service.DynamicRenewalCodeService;
import com.mps.think.utility.utils.Constants;
import com.mps.think.utility.utils.SecurityConstants;

import Think.XmlWebServices.Dynamic_price_select_responseDynamic_price_id;
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

	@GetMapping(value = { "/" })
	public ModelAndView login(Model model) {
		ModelAndView modelAndView = new ModelAndView();
		LoginModel loginModel = new LoginModel();
		model.addAttribute("loginModel", loginModel);
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@PostMapping(path = "/dynamicRenewalCodes")
	public ModelAndView login(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password,@RequestParam(value = "dsn") String dsn, @ModelAttribute("loginModel")LoginModel loginModel, 
			  BindingResult result,  ModelMap model) {
		
		ModelAndView modelAndView = new ModelAndView();
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>(); 
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
						
						DynamicRenewalCodeModel codeModel = new DynamicRenewalCodeModel();
						List<Dynamic_price_select_responseDynamic_price_select> codeModelList = dynamicRenewalCodeService.getDynamicCodesList(userDetails);
						
						int maxCodeId = codeModelList.get(codeModelList.size()-1).getDynamic_price_id();
						session.setAttribute("maxCodeId", maxCodeId);
						
						model.addAttribute("dynamicRenewalCodeModel", codeModel);
						session.setAttribute("dynamicPriceSelectResponseList", codeModelList);
						modelAndView.setViewName("dynamicRenewalCodeList");
				    }
				    else {
				    	responseObject.put(STATUS,ERROR);
				    	modelAndView.setViewName("login");
				    }
				}else {
					responseObject.put(STATUS,ERROR);
					modelAndView.setViewName("login");
				}
			   
		}catch(Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR+e);
		}
		return modelAndView;
	}

	@PostMapping(value = "/addNewRenewalCode")
	public ModelAndView addNewRenewalCode(@ModelAttribute("dynamicRenewalCodeModel")DynamicRenewalCodeModel dynamicRenewalCodeModel, 
			  BindingResult result,  ModelMap model) {
		
		HttpSession session = request.getSession();
		ModelAndView modelAndView = new ModelAndView();
		int status=0;
		int maxCodeId = 0;
		try {
			LoginModel loginModel = (LoginModel) request.getSession().getAttribute("loginModel");
			dynamicRenewalCodeModel.setLoginModel(loginModel);
			maxCodeId = (int) session.getAttribute("maxCodeId");
			
			dynamicRenewalCodeModel.setSlNo(maxCodeId+1);
			status = dynamicRenewalCodeService.addNewDynamicRenewalCode(dynamicRenewalCodeModel);
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("dynamicRenewalCodeModel", dynamicRenewalCodeModel);
		//modelAndView.setViewName("redirect:/dynamicRenewalCodeList");
		return new ModelAndView("dynamicRenewalCodeList", model);
	}
	
	@PostMapping(value = "/editNewRenewalCode")
	public ModelAndView editNewRenewalCode(@ModelAttribute("dynamicRenewalCodeModel")DynamicRenewalCodeModel dynamicRenewalCodeModel, 
			  BindingResult result,  ModelMap model, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		int status=0;
		try {
			LoginModel loginModel = (LoginModel) request.getSession().getAttribute("loginModel");
			dynamicRenewalCodeModel.setLoginModel(loginModel);
			status = dynamicRenewalCodeService.addNewDynamicRenewalCode(dynamicRenewalCodeModel);
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("dynamicRenewalCodeModel", dynamicRenewalCodeModel);
		modelAndView.setViewName("dynamicRenewalCodeList");
		return modelAndView;
	}
	
	@GetMapping(value = "/getRenewalCodes")
	//@ResponseBody
	public String getRenewalCodes(Model model) {
	 
	    return "anything";
	}

	@PostMapping("/logout")
	public String destroySession(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/";
	}
}
