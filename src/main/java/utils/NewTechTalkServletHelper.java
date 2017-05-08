package utils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.PreparedStatement;

import models.TechTalkDetails;

public class NewTechTalkServletHelper {
	public static void setNewTechTalk(TechTalkDetails techtalk) throws SQLException{
		Connection connection = SqlConnection.getconnection();
		PreparedStatement statment = (PreparedStatement) connection.prepareStatement("insert into techtalkdetails (title,description,givenby,techtalkdate) values(?,?,?,?)");
		statment.setString(1, techtalk.getTitle());
		statment.setString(2, techtalk.getDescription());
		statment.setString(3, techtalk.getPresentor());
		statment.setDate(4, techtalk.getTechTalkDate());
		statment.execute();
	}

}
