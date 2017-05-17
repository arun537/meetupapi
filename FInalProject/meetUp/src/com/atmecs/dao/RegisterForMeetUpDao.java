package com.atmecs.dao;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.atmecs.models.Attendence;
@Transactional
@Repository
public class RegisterForMeetUpDao {
	@Autowired
	SessionFactory sf;
	
	public boolean addAttendiesDao(Attendence attendence){
		Session session = sf.getCurrentSession();
		if(isAttendiesExist(attendence))
			return false;
		else{
			session.save(attendence);
			return true;
		}
	}
	public boolean isAttendiesExist(Attendence attendence){
		Session session = sf.getCurrentSession();
		Query qry = session.createQuery("from Attendence where comkey=:key");
		qry.setString("key", attendence.getComkey());
		Attendence tempAttendence = (Attendence)qry.uniqueResult();
		if(tempAttendence!=null)
			return true;
		else return false;
	}
}
