package com.ms.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/book")
public class BookController {

	
   @RequestMapping(value="/display",method=RequestMethod.GET)
	public ModelAndView show() {
	   int userId=3;
	   ModelAndView modelAndView = new ModelAndView();
	   modelAndView.setViewName("book/display");
	 

	   return modelAndView;
	}
   
   @RequestMapping(value="/test",method=RequestMethod.GET)
 	public ModelAndView test() {
 	   int a=100;
 	   int b=0;
 	   int c=a/b;
 	   ModelAndView modelAndView = new ModelAndView();
 	   modelAndView.setViewName("book/test");
 	 
 	   return modelAndView;
 	}
   
   @RequestMapping(value="/index",method=RequestMethod.GET)
	public ModelAndView first(HttpServletRequest request,HttpServletResponse response) {
	 
	   ModelAndView modelAndView = new ModelAndView();
	   modelAndView.setViewName("index");
	   
	   Cookie cookie = new Cookie("userinfo", "abc@123.com");
	   cookie.setMaxAge(300);
	   cookie.setPath("/");
	   response.addCookie(cookie);
	   
	   return modelAndView;
	}
   
}
