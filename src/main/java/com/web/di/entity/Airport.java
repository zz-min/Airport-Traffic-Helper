package com.web.di.entity;

public class Airport {
	private String airporId; // 공항 아이디
	private String airporeNm; // 공항 이름
	
	public Airport() {}
	public Airport(String airporId, String airporeNm) {
		super();
		this.airporId = airporId;
		this.airporeNm = airporeNm;
	}

	public String getAirporId() {
		return airporId;
	}

	public void setAirporId(String airporId) {
		this.airporId = airporId;
	}

	public String getAirporeNm() {
		return airporeNm;
	}

	public void setAirporeNm(String airporeNm) {
		this.airporeNm = airporeNm;
	}

	@Override
	public String toString() {
		return "Airport [airporId=" + airporId + ", airporeNm=" + airporeNm + "]";
	}
}
