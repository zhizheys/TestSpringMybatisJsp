package com.ms.controller;

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
   
   @RequestMapping(value="/index",method=RequestMethod.GET)
	public ModelAndView first() {
	 
	   ModelAndView modelAndView = new ModelAndView();
	   modelAndView.setViewName("index");
	   return modelAndView;
	}
   
}
