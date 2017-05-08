package utils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.PreparedStatement;

import models.TechTalkDetails;

public class UpdateTechTalkHelper {
	
	public static void updateTechTalkDeatils(TechTalkDetails techtalk) throws SQLException{
		Connection connection = SqlConnection.getconnection();
		PreparedStatement statment = (PreparedStatement) connection.prepareStatement("update techtalkdetails set title=?,description=?,givenby=?,techtalkdate=? where techtalkid=?");
		statment.setString(1, techtalk.getTitle());
		statment.setString(2, techtalk.getDescription());
		statment.setString(3, techtalk.getPresentor());
		statment.setDate(4, techtalk.getTechTalkDate());
		statment.setInt(5, techtalk.getTechTalkId());
		statment.execute();
	}

}
