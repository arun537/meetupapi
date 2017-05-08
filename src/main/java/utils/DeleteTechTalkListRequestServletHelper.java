package utils;

import java.sql.Connection;
import java.sql.SQLException;

public class DeleteTechTalkListRequestServletHelper {
	public static void deleteTechTalkFromRequestListById(int newTechTalkId) throws SQLException{
		Connection connection = SqlConnection.getconnection();
		connection.createStatement().executeQuery("delete from newtechtalkrequest where newtechtalkid="+newTechTalkId);
	}
}
