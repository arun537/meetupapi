package utils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.PreparedStatement;

import models.TechTalkDetails;

public class RequestNewTechTalkServletHelper {
	public static void AddRquestForTechTalk(TechTalkDetails newtechtalk) throws SQLException{
		Connection connection = SqlConnection.getconnection();
		System.out.println(newtechtalk);
		PreparedStatement statment = (PreparedStatement) connection.prepareStatement("insert into newtechtalkrequest (newtechtalktitle,newtechtalkdescription,newtechtalkuser,newtechtalkdate) values(?,?,?,?)");
		statment.setString(1, newtechtalk.getTitle());
		statment.setString(2, newtechtalk.getDescription());
		statment.setString(3, newtechtalk.getPresentor());
		statment.setDate(4, newtechtalk.getTechTalkDate());
		statment.execute();
	}
}
