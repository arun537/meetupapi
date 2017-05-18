package com.atmecs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atmecs.dao.UserLoginDao;
import com.atmecs.models.User;

@Service
public class UserLoginService {
	@Autowired
	UserLoginDao loginDao;

	public Boolean isUserExistService(User user){
		System.out.println(user+"in user isExist service");
		return loginDao.isUserExistDao(user);
	}
	public User getUserByName(String email){
		User tempUser = loginDao.getUserByNameDao(email);
		if(tempUser!=null)
			return tempUser;
		return null;
	}
}
