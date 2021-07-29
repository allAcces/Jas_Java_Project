package com.all.access.model;

public class States 
{
	int stateId;
	String stateName;
	
	public States() {}

	public States(int stateId, String stateName) {
		this.stateId = stateId;
		this.stateName = stateName;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	
}
