package com.atmecs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


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
	public String userLogin(@RequestBody User user){
		System.out.println(user+"in user logincontroller");
		if(loginService.isUserExistService(user))
			return "logged in succesfully";	
		else return "user not found";
	}
	@RequestMapping(value="/registerMeetUp/{userid}/{meetupid}", method=RequestMethod.POST, headers="Accept=application/json")
	public String registerForMeetup(@PathVariable(value="userid") int userid,@PathVariable(value="meetupid") int meetupid){
		if(registerService.addAttendiesService(userid, meetupid))
			return "user registered succesfully";
		else return "user already registered";
	}
}


