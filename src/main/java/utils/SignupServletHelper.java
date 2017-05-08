package utils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.PreparedStatement;

public class SignupServletHelper {
	
	public static void insertUserIntoTable(String email,String name,String password){
		try {
			Connection connection = SqlConnection.getconnection();
			PreparedStatement statement= (PreparedStatement) connection.prepareStatement("insert into user values(?,?,?)");
			statement.setString(1,email);
			statement.setString(2,name);
			statement.setString(3,password);
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}		
}
