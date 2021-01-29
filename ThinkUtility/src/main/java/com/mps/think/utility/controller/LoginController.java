package com.mps.think.utility.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {

    @RequestMapping(value={"/"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String login(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {
		return null;
	}

}
