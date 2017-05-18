package com.atmecs.dao;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.atmecs.models.User;

@Repository
@Transactional
public class UserLoginDao {
	@Autowired
	SessionFactory sf;
	
	public Boolean isUserExistDao(User user){
		Session session = sf.getCurrentSession();
		Query qry = session.createQuery("from User u where u.email=:email and u.password=:pass");
		System.out.println(user);
		qry.setParameter("email", user.getEmail());
		qry.setParameter("pass", user.getPassword());
		User tempuser = (User) qry.uniqueResult();
		System.out.println(tempuser);
		 if(tempuser!=null){
			 return true;
		 }
		 else return false;
	}
	
	public User getUserByNameDao(String email){
		Session session = sf.getCurrentSession();
		Query qry = session.createQuery("from User where email=:email");
		qry.setString("email", email);
		return (User)qry.uniqueResult();
	}
}
