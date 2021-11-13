package com.web.controlloer.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.controlloer.ControllerInterface;
import com.web.controlloer.HthService;

public class IndexController implements ControllerInterface {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, HthService hthService) {
		return "main.jsp";
	}

}
