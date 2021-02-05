package com.mps.think.utility.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mps.think.utility.dao.LoginDao;
import com.mps.think.utility.utils.SecurityConstants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {

	private static final String SUCCESS = SecurityConstants.STATUS;
	private static final String STATUS = SecurityConstants.STATUS;
	private static final String ERROR = SecurityConstants.ERROR;
	@Autowired
	LoginDao loginDao;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return "login";
	}

	@RequestMapping(path = "/dynamicRenewalCodes", method = RequestMethod.POST)
	public String login(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {
		

		Map<String, Object> responseObject = new LinkedHashMap<String, Object>(); 
		try {			
			 String url = "https://test1thinkprocess.mps-think.com/";
			 HttpPost post = new HttpPost(url);
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
					    responseObject.put("userCode",jsonObj.get("userCode").getAsString());
					    responseObject.put("publisher",jsonObj.get("publisher").getAsString());
					    responseObject.put("Token",jsonObj.get("Token").getAsString());
					    responseObject.put(STATUS,SUCCESS);
				    }
				    else {
				    	responseObject.put(STATUS,ERROR);
				    }
				}else {
					responseObject.put(STATUS,ERROR);
				}
			   
		}catch(Exception e) {
			log.error(ERROR + e);
			responseObject.put(STATUS,ERROR+e);
		}
	
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject(responseObject);
		modelAndView.setViewName("dynamicRenewalCodeList");
		return "dynamicRenewalCodeList";
	}

	@GetMapping(value = "/addNewRenewalCode")
	@ResponseBody
	public ModelAndView addNewRenewalCode() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("addRenewalCode");
		return modelAndView;
	}

}
