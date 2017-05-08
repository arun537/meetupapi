package utils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.PreparedStatement;

public class AdminDeleteServletHelper {

	public static void deleteTechTalkById(int techTalkId) throws SQLException{
		Connection connection = SqlConnection.getconnection();
		PreparedStatement statment = (PreparedStatement) connection.prepareStatement("delete from techtalkdetails where techtalkid=?");
		statment.setInt(1, techTalkId);
		statment.execute();
	}
}
