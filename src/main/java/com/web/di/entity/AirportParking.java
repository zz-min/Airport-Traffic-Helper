package com.web.di.entity;

public class AirportParking {
	private String airportKor; // 공항 이름
	private String parkingAirportCodeName;//공항 주차장 이름
	private String parkingCongestion;//주차장 상태
	private String parkingCongestionDegree;//주차장 상태 수치
	
	
	public AirportParking(String airportKor, String parkingAirportCodeName, String parkingCongestion,
			String parkingCongestionDegree) {
		super();
		this.airportKor = airportKor;
		this.parkingAirportCodeName = parkingAirportCodeName;
		this.parkingCongestion = parkingCongestion;
		this.parkingCongestionDegree = parkingCongestionDegree;
	}

	public String getAirportKor() {
		return airportKor;
	}

	public void setAirportKor(String airportKor) {
		this.airportKor = airportKor;
	}

	public String getParkingAirportCodeName() {
		return parkingAirportCodeName;
	}

	public void setParkingAirportCodeName(String parkingAirportCodeName) {
		this.parkingAirportCodeName = parkingAirportCodeName;
	}

	public String getParkingCongestion() {
		return parkingCongestion;
	}

	public void setParkingCongestion(String parkingCongestion) {
		this.parkingCongestion = parkingCongestion;
	}

	public String getParkingCongestionDegree() {
		return parkingCongestionDegree;
	}

	public void setParkingCongestionDegree(String parkingCongestionDegree) {
		this.parkingCongestionDegree = parkingCongestionDegree;
	}

	@Override
	public String toString() {
		return "airportParking [airportKor=" + airportKor + ", parkingAirportCodeName=" + parkingAirportCodeName
				+ ", parkingCongestion=" + parkingCongestion + ", parkingCongestionDegree=" + parkingCongestionDegree
				+ "]";
	}
}
