package com.web.controlloer;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.controlloer.impl.OpenApiGetAirmanList;
import com.web.controlloer.impl.OpenApiGetArprtList;

public class LoginMainController implements ControllerInterface {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, HthService hthService) {
		
		List<String> airlineNameList;// 항공사 목록
		List<String> airportNameList;// 공항 목록
		
		//airlineNameList=hthService.getAirlineNameList(null);
		
		
		OpenApiGetArprtList arprtList=new OpenApiGetArprtList();   // 공항목록 조회
		OpenApiGetAirmanList airmanList=new OpenApiGetAirmanList();//항공사목록 조회
		try {
			airportNameList=OpenApiGetArprtList.getArprtNmList();
			request.setAttribute("airportNameList", airportNameList);//공항이름리스트
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//airlineNameList=a.getFlightOpratInfoList();
		
		Jwt jwt=new Jwt();
		
		
		
		//request.setAttribute("airlineNameList", airlineNameList);//항공사이름리스트
		
		
		
		return "login.jsp";
	}

}
