package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.PreparedStatement;

public class RegisterationServletHelper {
	public static void insertIntoRegisterList(int techTalkId,String userEmailId) throws SQLException{
		
			Connection connection = SqlConnection.getconnection();
			PreparedStatement statment = (PreparedStatement) connection.prepareStatement("insert into registerList values(?,?,?)");
			statment.setInt(1, techTalkId);
			statment.setString(2, userEmailId);
			statment.setString(3, techTalkId+userEmailId);
			statment.execute();	
	}
	
	public static boolean isRegisteredAlready(int techTalkId,String userEmailId) throws SQLException{
		Connection connection = SqlConnection.getconnection();
		ResultSet set = connection.createStatement().executeQuery("select * from registerList where customKey='"+techTalkId+userEmailId+"'");
		if(set.next())
			return true;
		else return false;
		
	}

}
