package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.TechTalkDetails;

public class UpdateTechTalkListServletHelper {
	
	public static void approveRequestedTechTalkById(int newTechTalkId) throws SQLException{
		Connection connection = SqlConnection.getconnection();
		TechTalkDetails techTalkDetails = new TechTalkDetails();
		ResultSet set = connection.createStatement().executeQuery("select * from newtechtalkrequest where newtechtalkid="+newTechTalkId);
		while(set.next()){
			techTalkDetails.setTitle(set.getString(2));
			techTalkDetails.setDescription(set.getString(3));
			techTalkDetails.setPresentor(set.getString(4));
			techTalkDetails.setTechTalkDate(set.getDate(5));
		}
		
		NewTechTalkServletHelper.setNewTechTalk(techTalkDetails);
	}

}
