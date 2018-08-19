package com.ms.mapper;

import java.util.List;

import com.ms.entity.User;

public interface UserMapper {
	public User getUserById(int id);
	public int addUser(User user);
	public List<User> getAllUser();
}
