package com.atmecs.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atmecs.dao.UserRegisterDao;
import com.atmecs.models.User;

@Service
public class UserRegisterService {
	@Autowired
	private UserRegisterDao userDao;
	
	public void registerUserService(User user) {
		System.out.println("in user regise service");
		userDao.registerUserDao(user);
	}
	
	public ArrayList<User> getUserListService(){
		return userDao.getUserListDao();
	}
}
