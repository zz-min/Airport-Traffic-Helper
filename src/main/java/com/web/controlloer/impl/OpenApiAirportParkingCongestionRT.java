package com.web.controlloer.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import com.web.di.entity.AirportParking;
/*Service Key
 * fhy41313p5usuDFdab0hFuBpAm0r2ByZwbHyFOFtRnOVjvXRYSJVdLJ64xx7FFryhq3fk9%2B6fuiLaBaoF9EZqg%3D%3D
 * fhy41313p5usuDFdab0hFuBpAm0r2ByZwbHyFOFtRnOVjvXRYSJVdLJ64xx7FFryhq3fk9+6fuiLaBaoF9EZqg==
 * */
public class OpenApiAirportParkingCongestionRT {
	
	private static String common(String airportCode)  throws IOException{
		StringBuilder urlBuilder = new StringBuilder("http://openapi.airport.co.kr/service/rest/AirportParkingCongestion/airportParkingCongestionRT"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=fhy41313p5usuDFdab0hFuBpAm0r2ByZwbHyFOFtRnOVjvXRYSJVdLJ64xx7FFryhq3fk9%2B6fuiLaBaoF9EZqg%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("schAirportCode","UTF-8") + "=" + URLEncoder.encode(airportCode, "UTF-8")); 
        /*"GMP, PUS, CJU, TAE, KWJ, RSU, USN, KUV, WJU, CJJ" 김포국제공항, 김해국제공항, 제주국제공항, 대구국제공항, 광주공항, 여수공항, 울산공항, 군산공항, 원주공항, 청주국제공항*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        return sb.toString();
	}
	
	public List<AirportParking> getAirportParkingList(String airportCode) throws IOException {
		List<AirportParking> airportParkingList=new ArrayList<AirportParking>();
		String input = common(airportCode);
		JSONObject vJsonObj = XML.toJSONObject(input);
		JSONObject vJsonObj1= (JSONObject) vJsonObj.get("response");
		JSONObject vJsonObj2= (JSONObject) vJsonObj1.get("body");
		JSONObject vJsonObj3= (JSONObject) vJsonObj2.get("items");
		JSONArray dataArr = (JSONArray) vJsonObj3.get("item");
		for(int i=0;i<dataArr.length();i++) {
			AirportParking a=new AirportParking(dataArr.getJSONObject(i).get("airportKor").toString(),
					dataArr.getJSONObject(i).get("parkingAirportCodeName").toString(),
					dataArr.getJSONObject(i).get("parkingCongestion").toString(),
					dataArr.getJSONObject(i).get("parkingCongestionDegree").toString());
			airportParkingList.add(a);
    }
		return airportParkingList;
	}
	
}
