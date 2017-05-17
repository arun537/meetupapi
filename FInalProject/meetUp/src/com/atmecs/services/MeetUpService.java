package com.atmecs.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atmecs.dao.MeetUpDao;
import com.atmecs.models.MeetUpPojo;

@Service
public class MeetUpService {

	@Autowired
	MeetUpDao meetUpDao;
	
	public void addMeetUpService(MeetUpPojo meetUp){
		meetUpDao.addMeetUp(meetUp);
	}
	public String deleteMeetUpService(int meetUpId){
		MeetUpPojo tempMeetUp = meetUpDao.getMeetUp(meetUpId);
		if(meetUpDao.isExistMeetUp(meetUpId)){
		meetUpDao.deleteMeetUp(tempMeetUp);
		return "deleted entrry with id="+meetUpId;
		}
		else return "no entry on this Id";
		
	}
	public void updateMeetUpService(MeetUpPojo meetUp){
		meetUpDao.updateMeetUp(meetUp);
	}
	
	public ArrayList<MeetUpPojo> getListOfMeetUpService(){
		return meetUpDao.getListOfMeetUp();
	}
	public MeetUpPojo getMeetUpService(String title){
		MeetUpPojo meetUpTemp = meetUpDao.getMeetUpByName(title);
		if(meetUpTemp!=null)
			return meetUpTemp;
		else return null;
	}
}
