package com.atmecs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atmecs.models.Message;
import com.atmecs.models.User;
import com.atmecs.services.RegisterForMeetUpService;
import com.atmecs.services.UserLoginService;

@RestController
public class UserLoginController {
	@Autowired
	UserLoginService loginService;
	@Autowired
	RegisterForMeetUpService registerService;
	@RequestMapping(value="/loginUser",method=RequestMethod.POST,headers="Accept=application/json")
	public User userLogin(@RequestBody User user){
		System.out.println(user+"in user logincontroller");
		if(loginService.isUserExistService(user)){
			return loginService.getUserByName(user.getEmail());
		}
		else{
			return null;
		}
	}
	@RequestMapping(value="/registerMeetUp/{userid}/{meetupid}", method=RequestMethod.POST, headers="Accept=application/json")
	public Message registerForMeetup(@PathVariable(value="userid") int userid,@PathVariable(value="meetupid") int meetupid){
		Message message = new Message();
		if(registerService.addAttendiesService(userid, meetupid)){
			message.setMessage("user registered succesfully");
			return message;
		}
		else{
			message.setMessage("user already registered");
			return message;
		}
	}
}


