package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.TechTalkDetails;

public class AdminServletHelper {

	public static TechTalkDetails gettechTalkById(int techTalkId) throws SQLException{
		Connection connection = SqlConnection.getconnection();
		TechTalkDetails techTalk = new TechTalkDetails();
		ResultSet set = connection.createStatement().executeQuery("select * from techtalkdetails where techtalkid="+techTalkId);
		if(set.next()){
			techTalk.setTechTalkId(set.getInt(1));
			techTalk.setTitle(set.getString(2));
			techTalk.setDescription(set.getString(3));
			techTalk.setPresentor(set.getString(4));
			techTalk.setTechTalkDate(set.getDate(5));
		}
		System.out.println(techTalkId);
		return techTalk;



	}

}
