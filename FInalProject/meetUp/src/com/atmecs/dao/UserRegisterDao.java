package com.atmecs.dao;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import com.atmecs.models.User;
@ComponentScan("com.atmecs")
@Transactional
@Repository
public class UserRegisterDao {
	
	@Autowired
	private SessionFactory sessionfactory;
	
	public void registerUserDao(User user){
		Session session = sessionfactory.getCurrentSession();
		session.save(user);
		System.out.println("user Addes to data base" + user);
	}
	
	public ArrayList<User> getUserListDao(){
		Session session = sessionfactory.getCurrentSession();
		String hql= "from User";
		@SuppressWarnings("unchecked")
		ArrayList<User> list=(ArrayList<User>) session.createQuery(hql).list();
		System.out.println(list);
		return list;
	}
	
	
}
