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

import com.web.di.entity.Airport;
/*Service Key
 * fhy41313p5usuDFdab0hFuBpAm0r2ByZwbHyFOFtRnOVjvXRYSJVdLJ64xx7FFryhq3fk9%2B6fuiLaBaoF9EZqg%3D%3D
 * fhy41313p5usuDFdab0hFuBpAm0r2ByZwbHyFOFtRnOVjvXRYSJVdLJ64xx7FFryhq3fk9+6fuiLaBaoF9EZqg==
 * */
public class OpenApiGetArprtList {// 공항목록 조회 Arprt / airport
	
	private static String common()  throws IOException{
		StringBuilder urlBuilder = new StringBuilder("http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getArprtList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=fhy41313p5usuDFdab0hFuBpAm0r2ByZwbHyFOFtRnOVjvXRYSJVdLJ64xx7FFryhq3fk9%2B6fuiLaBaoF9EZqg%3D%3D"); /*Service Key*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
       // System.out.println("Response code: " + conn.getResponseCode());
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
//<?xml version="1.0" encoding="UTF-8" standalone="yes"?><response><header><resultCode>00</resultCode><resultMsg>NORMAL SERVICE.</resultMsg></header><body><items><item><airportId>NAARKJB</airportId><airportNm>무안</airportNm></item><item><airportId>NAARKJJ</airportId><airportNm>광주</airportNm></item><item><airportId>NAARKJK</airportId><airportNm>군산</airportNm></item><item><airportId>NAARKJY</airportId><airportNm>여수</airportNm></item><item><airportId>NAARKNW</airportId><airportNm>원주</airportNm></item><item><airportId>NAARKNY</airportId><airportNm>양양</airportNm></item><item><airportId>NAARKPC</airportId><airportNm>제주</airportNm></item><item><airportId>NAARKPK</airportId><airportNm>김해</airportNm></item><item><airportId>NAARKPS</airportId><airportNm>사천</airportNm></item><item><airportId>NAARKPU</airportId><airportNm>울산</airportNm></item><item><airportId>NAARKSI</airportId><airportNm>인천</airportNm></item><item><airportId>NAARKSS</airportId><airportNm>김포</airportNm></item><item><airportId>NAARKTH</airportId><airportNm>포항</airportNm></item><item><airportId>NAARKTN</airportId><airportNm>대구</airportNm></item><item><airportId>NAARKTU</airportId><airportNm>청주</airportNm></item></items></body></response>
	}
	public String getArprtId(String name) throws IOException {
		String id=null;
		String input = common();
		JSONObject vJsonObj = XML.toJSONObject(input);
		JSONObject vJsonObj1= (JSONObject) vJsonObj.get("response");
		JSONObject vJsonObj2= (JSONObject) vJsonObj1.get("body");
		JSONObject vJsonObj3= (JSONObject) vJsonObj2.get("items");
		JSONArray dataArr = (JSONArray) vJsonObj3.get("item");
		for(int i=0;i<dataArr.length();i++) {
			String str=dataArr.getJSONObject(i).get("airportNm").toString();
			if(str.equals(name)) id=dataArr.getJSONObject(i).get("airportId").toString();
        }
		return id;
	}
	public String getArprtNm(String id) throws IOException  {
		String name=null;
		String input = common();
		JSONObject vJsonObj = XML.toJSONObject(input);
		JSONObject vJsonObj1= (JSONObject) vJsonObj.get("response");
		JSONObject vJsonObj2= (JSONObject) vJsonObj1.get("body");
		JSONObject vJsonObj3= (JSONObject) vJsonObj2.get("items");
		JSONArray dataArr = (JSONArray) vJsonObj3.get("item");
		for(int i=0;i<dataArr.length();i++) {
			String str=dataArr.getJSONObject(i).get("airportId").toString();
			if(str.equals(id)) name=dataArr.getJSONObject(i).get("airportNm").toString();
        }
		return name;
	}
	public List<String>  getArprtIdList() throws IOException{
		List<String> airportIdList=new ArrayList<String>();
		String input = common();
		JSONObject vJsonObj = XML.toJSONObject(input);
		JSONObject vJsonObj1= (JSONObject) vJsonObj.get("response");
		JSONObject vJsonObj2= (JSONObject) vJsonObj1.get("body");
		JSONObject vJsonObj3= (JSONObject) vJsonObj2.get("items");
		JSONArray dataArr = (JSONArray) vJsonObj3.get("item");
		for(int i=0;i<dataArr.length();i++) {
			airportIdList.add(dataArr.getJSONObject(i).get("airportId").toString());
        }
		return airportIdList;
	}
	public static List<String>  getArprtNmList() throws IOException{
		List<String> airportNmList=new ArrayList<String>();
		String input = common();
		JSONObject vJsonObj = XML.toJSONObject(input);
		JSONObject vJsonObj1= (JSONObject) vJsonObj.get("response");
		JSONObject vJsonObj2= (JSONObject) vJsonObj1.get("body");
		JSONObject vJsonObj3= (JSONObject) vJsonObj2.get("items");
		JSONArray dataArr = (JSONArray) vJsonObj3.get("item");
		for(int i=0;i<dataArr.length();i++) {
			airportNmList.add(dataArr.getJSONObject(i).get("airportNm").toString());
        }
		return airportNmList;
	}

	public List<Airport>  getArprtAllList() throws IOException{
        List<Airport> airportAllList=new ArrayList<Airport>();
        String input = common();
        JSONObject vJsonObj = XML.toJSONObject(input);
        //System.out.println(vJsonObj);
        //{"response":{"header":{"resultCode":"00","resultMsg":"NORMAL SERVICE."},"body":{"items":{"item":[{"airportId":"NAARKJB","airportNm":"무안"},{"airportId":"NAARKJJ","airportNm":"광주"},{"airportId":"NAARKJK","airportNm":"군산"},{"airportId":"NAARKJY","airportNm":"여수"},{"airportId":"NAARKNW","airportNm":"원주"},{"airportId":"NAARKNY","airportNm":"양양"},{"airportId":"NAARKPC","airportNm":"제주"},{"airportId":"NAARKPK","airportNm":"김해"},{"airportId":"NAARKPS","airportNm":"사천"},{"airportId":"NAARKPU","airportNm":"울산"},{"airportId":"NAARKSI","airportNm":"인천"},{"airportId":"NAARKSS","airportNm":"김포"},{"airportId":"NAARKTH","airportNm":"포항"},{"airportId":"NAARKTN","airportNm":"대구"},{"airportId":"NAARKTU","airportNm":"청주"}]}}}}
        
        JSONObject vJsonObj1= (JSONObject) vJsonObj.get("response");
        //System.out.println(vJsonObj1);
        //{"header":{"resultCode":"00","resultMsg":"NORMAL SERVICE."},"body":{"items":{"item":[{"airportId":"NAARKJB","airportNm":"무안"},{"airportId":"NAARKJJ","airportNm":"광주"},{"airportId":"NAARKJK","airportNm":"군산"},{"airportId":"NAARKJY","airportNm":"여수"},{"airportId":"NAARKNW","airportNm":"원주"},{"airportId":"NAARKNY","airportNm":"양양"},{"airportId":"NAARKPC","airportNm":"제주"},{"airportId":"NAARKPK","airportNm":"김해"},{"airportId":"NAARKPS","airportNm":"사천"},{"airportId":"NAARKPU","airportNm":"울산"},{"airportId":"NAARKSI","airportNm":"인천"},{"airportId":"NAARKSS","airportNm":"김포"},{"airportId":"NAARKTH","airportNm":"포항"},{"airportId":"NAARKTN","airportNm":"대구"},{"airportId":"NAARKTU","airportNm":"청주"}]}}}
        
        JSONObject vJsonObj2= (JSONObject) vJsonObj1.get("body");
        //System.out.println(vJsonObj2);
        //{"items":{"item":[{"airportId":"NAARKJB","airportNm":"무안"},{"airportId":"NAARKJJ","airportNm":"광주"},{"airportId":"NAARKJK","airportNm":"군산"},{"airportId":"NAARKJY","airportNm":"여수"},{"airportId":"NAARKNW","airportNm":"원주"},{"airportId":"NAARKNY","airportNm":"양양"},{"airportId":"NAARKPC","airportNm":"제주"},{"airportId":"NAARKPK","airportNm":"김해"},{"airportId":"NAARKPS","airportNm":"사천"},{"airportId":"NAARKPU","airportNm":"울산"},{"airportId":"NAARKSI","airportNm":"인천"},{"airportId":"NAARKSS","airportNm":"김포"},{"airportId":"NAARKTH","airportNm":"포항"},{"airportId":"NAARKTN","airportNm":"대구"},{"airportId":"NAARKTU","airportNm":"청주"}]}}
        
        JSONObject vJsonObj3= (JSONObject) vJsonObj2.get("items");
        //System.out.println(vJsonObj3);
        //{"item":[{"airportId":"NAARKJB","airportNm":"무안"},{"airportId":"NAARKJJ","airportNm":"광주"},{"airportId":"NAARKJK","airportNm":"군산"},{"airportId":"NAARKJY","airportNm":"여수"},{"airportId":"NAARKNW","airportNm":"원주"},{"airportId":"NAARKNY","airportNm":"양양"},{"airportId":"NAARKPC","airportNm":"제주"},{"airportId":"NAARKPK","airportNm":"김해"},{"airportId":"NAARKPS","airportNm":"사천"},{"airportId":"NAARKPU","airportNm":"울산"},{"airportId":"NAARKSI","airportNm":"인천"},{"airportId":"NAARKSS","airportNm":"김포"},{"airportId":"NAARKTH","airportNm":"포항"},{"airportId":"NAARKTN","airportNm":"대구"},{"airportId":"NAARKTU","airportNm":"청주"}]}
        		
        JSONArray dataArr = (JSONArray) vJsonObj3.get("item");
        //System.out.println(dataArr);
        //[{"airportId":"NAARKJB","airportNm":"무안"},{"airportId":"NAARKJJ","airportNm":"광주"},{"airportId":"NAARKJK","airportNm":"군산"},{"airportId":"NAARKJY","airportNm":"여수"},{"airportId":"NAARKNW","airportNm":"원주"},{"airportId":"NAARKNY","airportNm":"양양"},{"airportId":"NAARKPC","airportNm":"제주"},{"airportId":"NAARKPK","airportNm":"김해"},{"airportId":"NAARKPS","airportNm":"사천"},{"airportId":"NAARKPU","airportNm":"울산"},{"airportId":"NAARKSI","airportNm":"인천"},{"airportId":"NAARKSS","airportNm":"김포"},{"airportId":"NAARKTH","airportNm":"포항"},{"airportId":"NAARKTN","airportNm":"대구"},{"airportId":"NAARKTU","airportNm":"청주"}]

        for(int i=0;i<dataArr.length();i++) {
        	//System.out.println(dataArr.getJSONObject(i));//{"airportId":"NAARKJB","airportNm":"무안"}
        	//System.out.println(dataArr.getJSONObject(i).get("airportId"));//NAARKJB
        	//System.out.println(dataArr.getJSONObject(i).get("airportNm"));//무안
        	Airport a=new Airport(dataArr.getJSONObject(i).get("airportId").toString(),dataArr.getJSONObject(i).get("airportNm").toString());
        	airportAllList.add(a);
        }
		return airportAllList;
	}

}
