package com.atmecs.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atmecs.models.Message;
import com.atmecs.models.User;
import com.atmecs.services.UserRegisterService;

@RestController
public class UserRegisterController {
	@Autowired
	private UserRegisterService userService;
	@RequestMapping(value="/registerUser",method=RequestMethod.POST, headers="Accept=application/json")
	public Message registerUser(@RequestBody User user){
		System.out.println("in user register dao");
		userService.registerUserService(user);
		Message message = new Message();
		message.setMessage("user registerd sucessfully");
		return message;
	}
	
	public void LoginUser(@RequestBody User User){
		
	}
	
	@RequestMapping(value="/getUser", method=RequestMethod.GET,headers="Accept=application/json")
	public ArrayList<User> getUserList(){
		System.out.println("data");
		ArrayList<User> list = userService.getUserListService();
		System.out.println(list);
		return list;
	}
}
