package com.ms.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.entity.ApiResult;
import com.ms.entity.User;
import com.ms.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
   @RequestMapping(value="/show",method=RequestMethod.GET)
   @ResponseBody
	public String show() {
	   int userId=3;
	   String result="hello world";
	   User user = new User();
       user = userService.getUserById(userId);
	   
	   ApiResult apiResult = new ApiResult();
	   apiResult.setResultCode(200);
	   apiResult.setMessage("success");
	   apiResult.setData(user);
	   
	  ObjectMapper objectMapper =new ObjectMapper();
	  
	  try{
		  result = objectMapper.writeValueAsString(apiResult);
	  }catch(Exception ex){
		  result = ex.getMessage();
	  }

	   return result;
	}
   
   //传统的url传递参数 http://localhost:8080/TestSpringMybatis/user/userinfo?id=10
   @RequestMapping(value="/userinfo",method=RequestMethod.GET)
   @ResponseBody
	public String getUserById(@RequestParam("id") int id) {
	   int userId=id;
	   String result=null;
	   User user = new User();
       user = userService.getUserById(userId);
	   
	   ApiResult apiResult = new ApiResult();
	   apiResult.setResultCode(200);
	   apiResult.setMessage("success");
	   apiResult.setData(user);
	   
	  ObjectMapper objectMapper =new ObjectMapper();
	  
	  try{
		  result = objectMapper.writeValueAsString(apiResult);
	  }catch(Exception ex){
		  result = ex.getMessage();
	  }

	   return result;
	}
   
   //restful url 风格http://localhost:8080/TestSpringMybatis/user/userinfo2/10
   @RequestMapping(value="/userinfo2/{id}",method=RequestMethod.GET)
   @ResponseBody
	public String getUserById2(@PathVariable("id") int id) {
	   int userId=id;
	   String result=null;
	   User user = new User();
       user = userService.getUserById(userId);
	   
	   ApiResult apiResult = new ApiResult();
	   apiResult.setResultCode(200);
	   apiResult.setMessage("success");
	   apiResult.setData(user);
	   
	  ObjectMapper objectMapper =new ObjectMapper();
	  
	  try{
		  result = objectMapper.writeValueAsString(apiResult);
	  }catch(Exception ex){
		  result = ex.getMessage();
	  }

	   return result;
	}

   @RequestMapping(value="/adduser",method=RequestMethod.GET)
   @ResponseBody
    public String addUser() {
	   
	   Date date = new Date();
	   
	   User addUser = new User();
	   addUser.setUserName("张天理3");
	   addUser.setUserAge(40);
	   addUser.setUserAddress("shenz");
	   addUser.setUserPassword("eeeef");
	   addUser.setUserBirthday(date);
	  int  userId=userService.addUser(addUser);
	   
	   //int userId=3;
	   String result="hello world";
	   User user = new User();
       user = userService.getUserById(userId);
	   
	   ApiResult apiResult = new ApiResult();
	   apiResult.setResultCode(200);
	   apiResult.setMessage("success");
	   apiResult.setData(user);
	   
	  ObjectMapper objectMapper =new ObjectMapper();
	  
	  try{
		  result = objectMapper.writeValueAsString(apiResult);
	  }catch(Exception ex){
		  result = ex.getMessage();
	  }

	   return result;
	}
    

}
