package com.ms.controller;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ms.controller.viewmodel.UserViewModel;
import com.ms.entity.User;

@Controller
@RequestMapping("/book")
public class BookController {
	private final static Log logger = LogFactory.getLog(BookController.class);
	
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
   
   @RequestMapping(value="/addbook",method=RequestMethod.GET)
 	public ModelAndView addBook() {
 	   ModelAndView modelAndView = new ModelAndView();
 	   modelAndView.setViewName("book/addbook");
 	   return modelAndView;
 	}
   
   
    //上传单个文件
	@RequestMapping(value = "/addbook", method = RequestMethod.POST)
	@ResponseBody
	public String addBook(MultipartFile uploadFile,HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		String result="";

		//upload file
		if(uploadFile !=null && uploadFile.getSize()>0){
			String fileName = uploadFile.getOriginalFilename();
			
			if(fileName.endsWith("jpg") || fileName.endsWith("png")){
				String leftPath = request.getServletContext().getRealPath("/static/images");
				File  filePath = new File(leftPath,fileName);
				
				if(!filePath.getParentFile().exists()){
					filePath.getParentFile().mkdirs();
				}
				
				try{
					uploadFile.transferTo(filePath);
					result="upload file success";
				}catch(Exception ex){
					logger.error("upload file error, " + ex.getMessage());
					result="error file "  + ex.getMessage();
				}
				
			}else{
				result="file type is error";
			}
		
		}else{
			result="no file";
		}
		
		 return result;
	}
	
	
   
}
