package com.ms.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
        //获取请求的url
        String url = request.getRequestURI();
        
        if(url.indexOf("login")>=0){
            return true;
        }
        
        //判断session
        HttpSession session  = request.getSession();
        //从session中取出用户身份信息
        String username = (String) session.getAttribute("username");
        
        if(username != null){
            //身份存在，放行
            return true;
        }
        
        //执行这里表示用户身份需要认证，跳转登陆页面
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        
        //return false表示拦截，不向下执行
        //return true表示放行
        return false;
    }
	
	 /** 
	  * Handler执行完成之后调用这个方法 
	  */
	@Override
	 public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exc) throws Exception { 
	    
	 } 
	  
	 /** 
	  * Handler执行之后，ModelAndView返回之前调用这个方法 
	  */
	@Override
	 public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception { 
	 
	} 

}
