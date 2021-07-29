package com.all.access.model;

public class City 
{
	private int cityId;
	private String cityName;
	private States stateId;
	
	
	
	public int getCityId() {
		return cityId;
	}



	public void setCityId(int cityId) {
		this.cityId = cityId;
	}



	public String getCityName() {
		return cityName;
	}



	public void setCityName(String cityName) {
		this.cityName = cityName;
	}



	public States getStateId() {
		return stateId;
	}



	public void setStateId(States stateId) {
		this.stateId = stateId;
	}
	
	



	public City(int cityId, String cityName, States stateId) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.stateId = stateId;
	}

	public City() {}

}
