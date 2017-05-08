package models;

import java.sql.Date;

public class TechTalkDetails {
	
	private int techTalkId;
	private String title,description,presentor;
	private Date techTalkDate;
	
	public TechTalkDetails() {
		super();
	}
	public TechTalkDetails(int techTalkId, String title, String description, String presentor, Date techTalkDate) {
		super();
		this.techTalkId = techTalkId;
		this.title = title;
		this.description = description;
		this.presentor = presentor;
		this.techTalkDate = techTalkDate;
	}
	public int getTechTalkId() {
		return techTalkId;
	}
	public void setTechTalkId(int techTalkId) {
		this.techTalkId = techTalkId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPresentor() {
		return presentor;
	}
	public void setPresentor(String presentor) {
		this.presentor = presentor;
	}
	public Date getTechTalkDate() {
		return techTalkDate;
	}
	public void setTechTalkDate(Date date) {
		this.techTalkDate = date;
	}
	@Override
	public String toString() {
		return "TechTalkDetails [Title=" + title + ", Description=" + description
				+ ", Presentor=" + presentor + ", TechTalkDate=" + techTalkDate + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((presentor == null) ? 0 : presentor.hashCode());
		result = prime * result + ((techTalkDate == null) ? 0 : techTalkDate.hashCode());
		result = prime * result + techTalkId;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TechTalkDetails other = (TechTalkDetails) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (presentor == null) {
			if (other.presentor != null)
				return false;
		} else if (!presentor.equals(other.presentor))
			return false;
		if (techTalkDate == null) {
			if (other.techTalkDate != null)
				return false;
		} else if (!techTalkDate.equals(other.techTalkDate))
			return false;
		if (techTalkId != other.techTalkId)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	

}
