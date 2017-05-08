package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.UserDao;

public class LoginServletHelper {

	public static Boolean isUserExist(String email,String password){
		try {
			Connection connection=SqlConnection.getconnection();
			ResultSet set = connection.createStatement().executeQuery("select useremailid,password from user where useremailid='"+email+"' and password='"+password+"'");
			if(set.next()){
				System.out.println("in if exist if"+set.getString(1)+set.getString(2));
				System.out.println(email+password);
				if(set.getString(1).equals(email) && set.getString(2).equals(password))
					return true;
				else return false;
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static UserDao getcurrentUser(String email,String password){
		Connection connection;
		try {
			connection = SqlConnection.getconnection();
			UserDao user = new UserDao();
			ResultSet set = connection.createStatement().executeQuery("select useremailid,username from user where useremailid='"+email+"' and password='"+password+"'");
			if(set.next()){
				user.setEmailId(set.getString(1));
				user.setUserName(set.getString(2));
				System.out.println(user);
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static ResultSet getListOfTechTalk() throws SQLException{
		Connection connection = SqlConnection.getconnection();
		ResultSet set = connection.createStatement().executeQuery("select * from techtalkdetails");
		return set;
	}
}
