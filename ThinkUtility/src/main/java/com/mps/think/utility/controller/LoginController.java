package com.mps.think.utility.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mps.think.utility.dao.LoginDao;

@Controller
public class LoginController {

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
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("dynamicRenewalCodeList");
		return "dynamicRenewalCodeList";
	}

	@PostMapping(value = "/addNewRenewalCode")
	public String addNewRenewalCode(Model model) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("addRenewalCode");
		return "addRenewalCode";
	}

}
