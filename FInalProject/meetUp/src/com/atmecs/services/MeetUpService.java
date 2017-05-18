package com.atmecs.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atmecs.dao.MeetUpDao;
import com.atmecs.models.MeetUpPojo;
import com.atmecs.models.Message;

@Service
public class MeetUpService {

	@Autowired
	MeetUpDao meetUpDao;
	
	public void addMeetUpService(MeetUpPojo meetUp){
		meetUpDao.addMeetUp(meetUp);
	}
	public Message deleteMeetUpService(int meetUpId){
		MeetUpPojo tempMeetUp = meetUpDao.getMeetUp(meetUpId);
		Message message = new Message();
		if(meetUpDao.isExistMeetUp(meetUpId)){
		meetUpDao.deleteMeetUp(tempMeetUp);
		message.setMessage("deleted entrry with id="+meetUpId);
		return message;
		}
		
		else{
			message.setMessage("no entry on this Id");
			return message;
		}
		
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
	public void deleteAttendence(int meetUpId){
	meetUpDao.deleteAttendenceDao(meetUpId);
	}
	
}
