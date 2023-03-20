package com.durga.dao;

import com.durga.entities.User;

public interface UserDao {

	public String checkLogin(User user);
	
	public String registration(User user);
}	
