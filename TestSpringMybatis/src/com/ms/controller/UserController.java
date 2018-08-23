package com.ms.controller;

import java.awt.event.ItemEvent;
import java.awt.im.spi.InputMethod;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.jasper.tagplugins.jstl.core.Redirect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.controller.viewmodel.UserViewModel;
import com.ms.entity.ApiResult;
import com.ms.entity.User;
import com.ms.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private final static Log logger = LogFactory.getLog(UserController.class);

	@Autowired
	private UserService userService;

	// 对表单提交的日期进行格式化
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		
		
	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	@ResponseBody
	public String show() {
		int userId = 3;
		String result = "hello world";
		User user = new User();
		user = userService.getUserById(userId);

		ApiResult apiResult = new ApiResult();
		apiResult.setResultCode(200);
		apiResult.setMessage("success");
		apiResult.setData(user);

		ObjectMapper objectMapper = new ObjectMapper();

		try {
			result = objectMapper.writeValueAsString(apiResult);
		} catch (Exception ex) {
			result = ex.getMessage();
		}

		logger.debug("DEBUG ...............................");
		logger.info("INFO ................................."+ "user/show controller info");
		logger.error("ERROR ..............................." + "user/show controller error");

		return result;
	}

	// 传统的url传递参数 http://localhost:8080/TestSpringMybatis/user/userinfo?id=10
	@RequestMapping(value = "/userinfo", method = RequestMethod.GET)
	@ResponseBody
	public ApiResult getUserById(@RequestParam("id") int id) {
		int userId = id;
		User user = new User();
		user = userService.getUserById(userId);

		ApiResult apiResult = new ApiResult();
		apiResult.setResultCode(200);
		apiResult.setMessage("success");
		apiResult.setData(user);

		return apiResult;
	}

	@RequestMapping(value = "/userinfotwo", method = RequestMethod.GET)
	@ResponseBody
	public ApiResult getUserById() {
		int userId = 10;
		User user = new User();
		user = userService.getUserById(userId);

		ApiResult apiResult = new ApiResult();
		apiResult.setResultCode(200);
		apiResult.setMessage("success");
		apiResult.setData(user);

		return apiResult;
	}

	// restful url 风格http://localhost:8080/TestSpringMybatis/user/userinfo2/10
	@RequestMapping(value = "/userinfo2/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String getUserById2(@PathVariable("id") int id) {
		int userId = id;
		String result = null;
		User user = new User();
		user = userService.getUserById(userId);

		ApiResult apiResult = new ApiResult();
		apiResult.setResultCode(200);
		apiResult.setMessage("success");
		apiResult.setData(user);

		ObjectMapper objectMapper = new ObjectMapper();

		try {
			result = objectMapper.writeValueAsString(apiResult);
		} catch (Exception ex) {
			result = ex.getMessage();
		}

		return result;
	}

	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public ModelAndView addUser(@Valid @ModelAttribute UserViewModel user,BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		List<ObjectError> allErrors=null;
		
		if(result.hasErrors()){
			logger.error("===========================add user valid error");
			allErrors = result.getAllErrors();
			modelAndView.addObject("allErrors", allErrors);
			modelAndView.setViewName("user/registeruser");
			return modelAndView;
		}
		

		Date date = new Date();
		User addUser = new User();
		addUser.setUserName(user.getUserName());
		addUser.setUserAge(user.getUserAge());
		addUser.setUserAddress(user.getUserAddress());
		addUser.setUserPassword(user.getUserPassword());
		addUser.setUserBirthday(user.getUserBirthday());

		int userId = userService.addUser(addUser);
		User userFind = userService.getUserById(userId);
		System.out.println("==============================add user id is :" + userFind.getUserId());

		//return "redirect:/user/showalluser";
		 modelAndView = new ModelAndView("redirect:/user/showalluser");
		 
		 return modelAndView;
	}

	@RequestMapping(value = "/addusertwo", method = RequestMethod.POST)
	@ResponseBody
	public ApiResult addUserTwo(@ModelAttribute UserViewModel user) {
		ModelAndView modelAndView = new ModelAndView();
		Date date = new Date();

		User addUser = new User();
		addUser.setUserName(user.getUserName());
		addUser.setUserAge(user.getUserAge());
		addUser.setUserAddress(user.getUserAddress());
		addUser.setUserPassword(user.getUserPassword());
		addUser.setUserBirthday(user.getUserBirthday());

		int userId = userService.addUser(addUser);

		String result = "";
		HashMap hm = new HashMap();
		hm.put("userId", userId);

		ApiResult apiResult = new ApiResult();
		apiResult.setResultCode(200);
		apiResult.setMessage("success");
		apiResult.setData(hm);

		return apiResult;
	}

	@RequestMapping(value = "/registeruser", method = RequestMethod.GET)
	public ModelAndView registerUser() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("user/registeruser");

		return modelAndView;
	}

	@RequestMapping(value = "/showalluser", method = RequestMethod.GET)
	public ModelAndView showAllUser(HttpServletRequest request,HttpServletResponse response) {

		ModelAndView result = new ModelAndView();
		User user = new User();
		List<User> userList = userService.getAllUser();
		result.addObject("userList", userList);
		
		Cookie[] cookies = request.getCookies();
		if(cookies !=null && cookies.length >0){
			for(Cookie item :cookies){
				if("userinfo".equals(item.getName())){
					result.addObject("userInfo", item.getValue());
				}
			}
		}
		
		result.setViewName("user/alluser");
		return result;
	}

	@RequestMapping(value = "/dealuser", method = RequestMethod.GET)
	public ModelAndView dealUser() {
		ModelAndView result = new ModelAndView();
		result.setViewName("user/userinfo");
		return result;
	}

}
