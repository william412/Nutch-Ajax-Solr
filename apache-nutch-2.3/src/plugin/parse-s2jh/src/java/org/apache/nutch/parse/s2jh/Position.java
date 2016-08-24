package org.apache.nutch.parse.s2jh;

import java.io.Serializable;

public class Position implements Serializable{
	
	private static final long serialVersionUID = -8886610638618815014L;
	
	private String positionName; 
	private String companyName;
	private String positionLink;
	private String workPlace;
	private String postTime;
	
	public String getPostTime() {
		return postTime;
	}
	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getPositionLink() {
		return positionLink;
	}
	public void setPositionLink(String positionLink) {
		this.positionLink = positionLink;
	}
	public String getWorkPlace() {
		return workPlace;
	}
	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}
}
