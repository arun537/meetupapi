package com.atmecs.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.*;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"email"}))
public class User {
	
	@Id@GeneratedValue
	int userid;
	@NotNull(message="email is empty")
	
	String email;
	@NotNull(message="password is empty")
	String password;
	String company,technicalcompatibility,companyAddress;
	int experience;
	long mobileNumber; 
	public User() {
		super();
	}
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getTechnicalcompatibility() {
		return technicalcompatibility;
	}
	public void setTechnicalcompatibility(String technicalcompatibility) {
		this.technicalcompatibility = technicalcompatibility;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	@Override
	public String toString() {
		return "User [userId=" + userid + ", email=" + email + ", password=" + password + ", company=" + company
				+ ", technicalcompatibility=" + technicalcompatibility + ", companyAddress=" + companyAddress
				+ ", experience=" + experience + ", mobileNumber=" + mobileNumber + "]";
	}
}
