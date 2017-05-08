package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HomePageHelper {
	public static ResultSet getTechTalkResultSet() throws SQLException{
		Connection connection = SqlConnection.getconnection();
		ResultSet set = connection.createStatement().executeQuery("select * from techtalkdetails");
		return set;
	}

}
