package com.web.controlloer;

import java.util.HashMap;
import java.util.Map;

import com.web.controlloer.impl.IndexController;


public class HandlerMapping {
	private Map<String, ControllerInterface> handlerMapper = null;

	public HandlerMapping() {
		handlerMapper = new HashMap<String, ControllerInterface>();

		handlerMapper.put("/main", new IndexController());
		/*
		 * handlerMapper.put("/main", new IndexController());
		 * 
		 * handlerMapper.put("/main/studio", new MainController());
		 * handlerMapper.put("/main/rental", new MainController());
		 * handlerMapper.put("/main/consulting", new MainController());
		 * 
		 * handlerMapper.put("/api/users", new ApiUserController());
		 * handlerMapper.put("/api/schedules", new ApiScheduleController());
		 * handlerMapper.put("/api/contents", new ApiContentController());
		 */
	}

	public ControllerInterface getHandler(String path) {
		String[] temp=path.split("/"); 
		// /main/1라면 [0]='', [1]="main", [2]="1"가 저장됨
		
		if(temp.length>3) {//리소스가 2개 초과면 2개까지 분류만 path로 넘기기
			return handlerMapper.get("/"+temp[1]+"/"+temp[2]);
		}else {
			return handlerMapper.get(path);
		}
	}
}
