package com.ms.service;

import java.util.List;

import org.aspectj.weaver.ast.Literal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.mapper.UserMapper;
import com.ms.entity.User;
import com.ms.service.UserService;

@Service("userService")
public class UserServiceImp implements UserService {

	@Autowired
	private UserMapper userDao;


	@Override
	public User getUserById(Integer id) {
		return userDao.getUserById(id);
	}
	
	@Override
	public int addUser(User user){
		userDao.addUser(user);
		
		//返回该对象的自增ID
		return user.getUserId();
	}
	
	@Override
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}
	
	
	

}
