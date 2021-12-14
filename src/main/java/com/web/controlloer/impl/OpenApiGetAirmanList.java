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

import com.web.di.entity.Airline;
/*Service Key
 * fhy41313p5usuDFdab0hFuBpAm0r2ByZwbHyFOFtRnOVjvXRYSJVdLJ64xx7FFryhq3fk9%2B6fuiLaBaoF9EZqg%3D%3D
 * fhy41313p5usuDFdab0hFuBpAm0r2ByZwbHyFOFtRnOVjvXRYSJVdLJ64xx7FFryhq3fk9+6fuiLaBaoF9EZqg==
 * */
public class OpenApiGetAirmanList {// 항공사목록 조회  Airman / airline
	
	private static String common()  throws IOException{
		StringBuilder urlBuilder = new StringBuilder("http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getAirmanList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=fhy41313p5usuDFdab0hFuBpAm0r2ByZwbHyFOFtRnOVjvXRYSJVdLJ64xx7FFryhq3fk9%2B6fuiLaBaoF9EZqg%3D%3D"); /*Service Key*/
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
        //System.out.println(sb.toString());
	}
	public String getAirmanId(String name) throws IOException {
		String id=null;
		String input = common();
		JSONObject vJsonObj = XML.toJSONObject(input);
		JSONObject vJsonObj1= (JSONObject) vJsonObj.get("response");
		JSONObject vJsonObj2= (JSONObject) vJsonObj1.get("body");
		JSONObject vJsonObj3= (JSONObject) vJsonObj2.get("items");
		JSONArray dataArr = (JSONArray) vJsonObj3.get("item");
		for(int i=0;i<dataArr.length();i++) {
			String str=dataArr.getJSONObject(i).get("airlineNm").toString();
			if(str.equals(name)) id=dataArr.getJSONObject(i).get("airlineId").toString();
        }
		return id;
	}
	public String getAirmanNm(String id) throws IOException {
		String name=null;
		String input = common();
		JSONObject vJsonObj = XML.toJSONObject(input);
		JSONObject vJsonObj1= (JSONObject) vJsonObj.get("response");
		JSONObject vJsonObj2= (JSONObject) vJsonObj1.get("body");
		JSONObject vJsonObj3= (JSONObject) vJsonObj2.get("items");
		JSONArray dataArr = (JSONArray) vJsonObj3.get("item");
		for(int i=0;i<dataArr.length();i++) {
			String str=dataArr.getJSONObject(i).get("airlineId").toString();
			if(str.equals(id)) name=dataArr.getJSONObject(i).get("airlineNm").toString();
        }
		return name;
	}
	public List<String>  getAirmanIdList() throws IOException{
		List<String> airmanIdList=new ArrayList<String>();
		String input = common();
		JSONObject vJsonObj = XML.toJSONObject(input);
		JSONObject vJsonObj1= (JSONObject) vJsonObj.get("response");
		JSONObject vJsonObj2= (JSONObject) vJsonObj1.get("body");
		JSONObject vJsonObj3= (JSONObject) vJsonObj2.get("items");
		JSONArray dataArr = (JSONArray) vJsonObj3.get("item");
		for(int i=0;i<dataArr.length();i++) {
			airmanIdList.add(dataArr.getJSONObject(i).get("airlineId").toString());
        }
		return airmanIdList;
	}
	public static List<String>  getAirmanNmList() throws IOException{
		List<String> airmanNmList=new ArrayList<String>();
		String input = common();
		JSONObject vJsonObj = XML.toJSONObject(input);
		JSONObject vJsonObj1= (JSONObject) vJsonObj.get("response");
		JSONObject vJsonObj2= (JSONObject) vJsonObj1.get("body");
		JSONObject vJsonObj3= (JSONObject) vJsonObj2.get("items");
		JSONArray dataArr = (JSONArray) vJsonObj3.get("item");
		for(int i=0;i<dataArr.length();i++) {
			airmanNmList.add(dataArr.getJSONObject(i).get("airlineNm").toString());
        }
		return airmanNmList;
	}
	
	public List<Airline> getAirmanList() throws IOException{
		List<Airline> airlinetAllList=new ArrayList<Airline>();
        String input = common();
        JSONObject vJsonObj = XML.toJSONObject(input);
        JSONObject vJsonObj1= (JSONObject) vJsonObj.get("response");
        JSONObject vJsonObj2= (JSONObject) vJsonObj1.get("body");
		JSONObject vJsonObj3= (JSONObject) vJsonObj2.get("items");
		JSONArray dataArr = (JSONArray) vJsonObj3.get("item");
		for(int i=0;i<dataArr.length();i++) {
	        	Airline a=new Airline(dataArr.getJSONObject(i).get("airlineId").toString(),dataArr.getJSONObject(i).get("airlineNm").toString());
	        	airlinetAllList.add(a);
	    }
		return airlinetAllList;
	}
}
