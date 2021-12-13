package com.web.controlloer;

import java.util.HashMap;
import java.util.Map;

import com.web.controlloer.impl.IndexController;
import com.web.controlloer.impl.OpenApiController;

public class HandlerMapping {
	private Map<String, ControllerInterface> handlerMapper = null;

	public HandlerMapping() {
		handlerMapper = new HashMap<String, ControllerInterface>();

		handlerMapper.put("/main", new IndexController());
		handlerMapper.put("/login_main", new LoginMainController());//로그인 성공시 들어가는 URL
		handlerMapper.put("/test", new TestController());
		
		handlerMapper.put("/api/openapi", new OpenApiController());
		/*
		 * handlerMapper.put("/main", new IndexController());
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
