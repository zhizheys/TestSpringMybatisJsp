package com.ms.service;

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

	User getUserById(Integer id);
	int addUser(User user);

}

