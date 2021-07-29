package com.all.access.model;

public class Area {

	int areaID ;
	String areaName;
	int cityID;
	public int getAreaID() {
		return areaID;
	}
	public void setAreaID(int areaID) {
		this.areaID = areaID;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public int getCityID() {
		return cityID;
	}
	public void setCityID(int cityID) {
		this.cityID = cityID;
	}
	
	
	public Area(int areaID, String areaName, int cityID) {
		super();
		this.areaID = areaID;
		this.areaName = areaName;
		this.cityID = cityID;
	}
	
}
