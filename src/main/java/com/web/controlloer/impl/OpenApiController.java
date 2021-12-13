package com.web.controlloer.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.controlloer.ControllerInterface;
import com.web.controlloer.HthService;

public class OpenApiController implements ControllerInterface {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, HthService hthService) {
		String returnMassage="abc";
		ObjectMapper mapper = new ObjectMapper();
		
		/* /api/openapi/[4번째 temp값]
		 * getArprtList - 공항목록 조회 
		 * getAirmanList - 항공사목록 조회 
		 * getFlightOpratInfoList - 항공운행정보목록 조회
		 */

		String path = request.getRequestURI();
		String[] temp=path.split("/");
		String query=request.getQueryString();
		System.out.println("OpenApiController path >>"+path+"?"+query);
		System.out.println(temp[3]);
		if (temp[3].equals("getArprtList")) {// 공항목록 조회
			OpenApiGetArprtList oag_arprt = new OpenApiGetArprtList();
		} else if (temp[3].equals("getAirmanList")) {// 항공사목록 조회
			OpenApiGetAirmanList oag_airman = new OpenApiGetAirmanList();

		}else if(temp[3].equals("getFlightOpratInfoList")) {//항공운행정보목록 조회
			OpenApiGetFlightOpratInfoList oag_flightOprat=new OpenApiGetFlightOpratInfoList();
		}
		
		return returnMassage;
	}

}
