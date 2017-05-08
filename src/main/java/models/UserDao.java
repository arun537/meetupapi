package models;

public class UserDao {
	
	private String emailId;
	private String userName;
	public UserDao() {
		super();
	}
	public UserDao(String emailId, String userName) {
		super();
		this.emailId = emailId;
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "UserDao [emailId=" + emailId + ", userName=" + userName + "]";
	}
	
	

}
