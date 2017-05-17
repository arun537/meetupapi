package com.atmecs.models;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Attendence {
	@Id
	String comkey;
	int userid,meetupid;
	public String getComkey() {
		return comkey;
	}
	public void setComkey(String comkey) {
		this.comkey = comkey;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getMeetupid() {
		return meetupid;
	}
	public void setMeetupid(int meetupid) {
		this.meetupid = meetupid;
	}
	@Override
	public String toString() {
		return "Attendence [comkey=" + comkey + ", userid=" + userid + ", meetupid=" + meetupid + "]";
	}
	
}
