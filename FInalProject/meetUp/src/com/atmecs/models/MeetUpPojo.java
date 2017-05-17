package com.atmecs.models;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="meetups")
public class MeetUpPojo {
	@Id@GeneratedValue
	int meetupid;
	String title,presentor,description,guest;
	Date date;
	Time starttime,endtime;
	public int getMeetupid() {
		return meetupid;
	}
	public void setMeetupid(int meetupid) {
		this.meetupid = meetupid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPresentor() {
		return presentor;
	}
	public void setPresentor(String presentor) {
		this.presentor = presentor;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getStarttime() {
		return starttime;
	}
	public void setStarttime(Time starttime) {
		this.starttime = starttime;
	}
	public Time getEndtime() {
		return endtime;
	}
	public void setEndtime(Time endtime) {
		this.endtime = endtime;
	}
	public String getGuest() {
		return guest;
	}
	public void setGuest(String guest) {
		this.guest = guest;
	}
	@Override
	public String toString() {
		return "MeetUpPojo [meetupid=" + meetupid + ", title=" + title + ", presentor=" + presentor + ", description="
				+ description + ", guest=" + guest + ", date=" + date + ", starttime=" + starttime + ", endtime="
				+ endtime + "]";
	}
}
