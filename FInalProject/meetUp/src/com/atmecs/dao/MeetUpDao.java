package com.atmecs.dao;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.atmecs.models.MeetUpPojo;

@Repository
@Transactional
public class MeetUpDao {
	@Autowired
	SessionFactory sf;

	public boolean isExistMeetUp(int meetUpId){
		System.out.println(getMeetUp(meetUpId)+"in meetUpis Exist");
		if(getMeetUp(meetUpId)!=null){
			System.out.println("in is exist true");
			return true;
		}
		else return false;
	}
	public MeetUpPojo getMeetUp(int meetUpId){
		Session session = sf.getCurrentSession();
		Query qry = session.createQuery("from MeetUpPojo m where m.meetupid=:meetupid");
		qry.setParameter("meetupid", meetUpId);
		return (MeetUpPojo) qry.uniqueResult();
	}

	public void addMeetUp(MeetUpPojo meetUp){
		Session session = sf.getCurrentSession();
		session.save(meetUp);
	}

	public void deleteMeetUp(MeetUpPojo meetUp){
		Session session = sf.getCurrentSession();
		session.delete(meetUp);
	}

	public void updateMeetUp(MeetUpPojo meetUp){
		Session session =sf.getCurrentSession();
		session.persist(meetUp);
	}
	public ArrayList<MeetUpPojo> getListOfMeetUp(){
		Session session = sf.getCurrentSession();
		Query qry = session.createQuery("from MeetUpPojo");
		@SuppressWarnings("unchecked")
		ArrayList<MeetUpPojo> list = (ArrayList<MeetUpPojo>) qry.list();
		System.out.println(list);
		return list;
	}
	public MeetUpPojo getMeetUpByName(String title){
		ArrayList<MeetUpPojo> list = getListOfMeetUp();
		for(MeetUpPojo m : list){
			if(m.getTitle().equals(title))
				return m;
		}
		return null;
	}
	public void deleteAttendenceDao(int meetUpId){
		Session session = sf.getCurrentSession();
		Query qry = session.createQuery("delete from Attendence where meetupid=:meetupid");
		qry.setInteger("meetupid", meetUpId);
		qry.executeUpdate();
	}
	
}