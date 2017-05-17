package com.atmecs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atmecs.dao.RegisterForMeetUpDao;
import com.atmecs.models.Attendence;
@Service
public class RegisterForMeetUpService {
	@Autowired
	RegisterForMeetUpDao registerMeetupDao;

	public boolean addAttendiesService(int userid, int meetupid){
		Attendence attendence = new Attendence();
		attendence.setMeetupid(meetupid);
		attendence.setUserid(userid);
		attendence.setComkey("userid"+userid+"meetupid"+meetupid);
		if(registerMeetupDao.addAttendiesDao(attendence))
			return true;
		else return false;
	}
}
