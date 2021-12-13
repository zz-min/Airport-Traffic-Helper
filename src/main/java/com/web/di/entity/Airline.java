package com.web.di.entity;

public class Airline {
	private String airlineId; // 항공사 아이디
	private String airlineNm; // 항공사 이름
	
	public Airline() {}
	public Airline(String airlineId, String airlineNm) {
		super();
		this.airlineId = airlineId;
		this.airlineNm = airlineNm;
	}

	public String getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(String airlineId) {
		this.airlineId = airlineId;
	}

	public String getAirlineNm() {
		return airlineNm;
	}

	public void setAirlineNm(String airlineNm) {
		this.airlineNm = airlineNm;
	}

	@Override
	public String toString() {
		return "Airline [airlineId=" + airlineId + ", airlineNm=" + airlineNm + "]";
	}
	
	
}
