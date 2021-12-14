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
		
		try {
			airlineNameList=OpenApiGetAirmanList.getAirmanNmList();
			request.setAttribute("airlineNameList", airlineNameList);//항공사이름리스트
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			airportNameList=OpenApiGetArprtList.getArprtNmList();
			request.setAttribute("airportNameList", airportNameList);//공항이름리스트
		} catch (IOException e) {
			e.printStackTrace();
		}
		Jwt jwt=new Jwt();
		
		return "login.jsp";
	}

}
