package com.ms.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ms.controller.viewmodel.UserViewModel;
import com.ms.entity.User;

@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");

		return modelAndView;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpSession session, String userName, String userPassword) {
		ModelAndView modelAndView = new ModelAndView();
         
		if(!userName.trim().isEmpty() && !userPassword.trim().isEmpty()){
			session.setAttribute("username",userName);
		}
		
		 modelAndView = new ModelAndView("redirect:/book/index");
		 
		 return modelAndView;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		session.invalidate();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
}
