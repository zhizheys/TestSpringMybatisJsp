package com.ms.service;

import java.util.List;

import com.ms.entity.User;

//public class UserService {
//	
//	@Resource(name="userDao")
//	private UserDao userDao;
//	 
//	public User getUserById(int id)  {
//		User user = new User();
//		//user.setUserId(111);
//		//user.setUserName("shenzhen");
//		user= userDao.getUserById(id);
//		return user;
//	}
//	
//	
//}

public interface UserService {

	public User getUserById(Integer id);
	public int addUser(User user);
	public List<User> getAllUser();

}

