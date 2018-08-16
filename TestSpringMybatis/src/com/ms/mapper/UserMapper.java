package com.ms.mapper;

import com.ms.entity.User;

public interface UserMapper {
	public User getUserById(int id);
	public int addUser(User user);
}
