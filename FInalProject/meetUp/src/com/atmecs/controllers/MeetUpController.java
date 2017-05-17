package com.atmecs.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atmecs.models.MeetUpPojo;
import com.atmecs.services.MeetUpService;

@RestController
public class MeetUpController {
	@Autowired
	MeetUpService  meetUpService;
	@RequestMapping(value="/meetup", method=RequestMethod.POST, headers="Accept=application/json")
	public void addMeetUpContrroller(@RequestBody MeetUpPojo meetUp){
		System.out.println("in post meetup");
		meetUpService.addMeetUpService(meetUp);
	}
	@RequestMapping(value="/meetup/{meetUpId}", method=RequestMethod.DELETE, headers="Accept=application/json")
	public String deleteMeetUpController(@PathVariable int meetUpId){
		System.out.println("in delete meetup");
		return meetUpService.deleteMeetUpService(meetUpId);
	}
	@RequestMapping(value="/meetup", method=RequestMethod.PUT, headers="Accept=application/json")
	public void upadteMeetUpController(@RequestBody MeetUpPojo meetUp){
		System.out.println("in put UPDATE MEETUP");
		meetUpService.updateMeetUpService(meetUp);
	}
	@RequestMapping(value="/meetup",method=RequestMethod.GET,headers="Accept=application/json")
	public ArrayList<MeetUpPojo> getListOfMeetUp(){
		System.out.println("in get meetup");
		return meetUpService.getListOfMeetUpService();
	}
	@RequestMapping(value="/getMeetUpByTitle/{title}", method=RequestMethod.GET, headers="Accept=application/json")
	public MeetUpPojo getMeetUpByName(@PathVariable String title){
		return meetUpService.getMeetUpService(title);
	}	
}