package com.ms.common.exception;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.ms.controller.UserController;

public class CustomExceptionResolver implements HandlerExceptionResolver {
	private final static Log logger = LogFactory.getLog(UserController.class);
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj,Exception ex) {

		//将错误信息放入请求作用域中
		String errorMessage=ex.getMessage();
		logger.error(errorMessage,ex);
		ex.printStackTrace();
		request.setAttribute("message", errorMessage);
		try {
			//进行页面的跳转，跳转到错误信息页面
			request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
		return new ModelAndView();
	}

}
