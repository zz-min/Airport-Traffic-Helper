package com.web.controlloer;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class dispatcher
 */
@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PROPERTIES_FILE = "db.properties";
	private Properties props;
	private HthService hthService = null;
	private HandlerMapping mapper = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
    }
    
    @Override
	public void init() throws ServletException {
    	System.out.println("DispatcherServlet init");
    	mapper = new HandlerMapping();
    	props = new Properties();
    	hthService= new HthServiceImpl();
        try {
            
            props.load(this.getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE));
        } catch (IOException e) {
            System.out.println("Properties File Load Fail!");
            e.printStackTrace();
        }
        System.out.println("resources-env => "+props.getProperty("env"));
        String driver = props.getProperty("");
		String url = props.getProperty("jdbc.url");
		String userName = props.getProperty("jdbc.username");
		String password = props.getProperty("jdbc.password");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// step #1. get request parameters
				request.setCharacterEncoding("UTF-8");

				String path = request.getRequestURI();
				System.out.println("path >>" + path);
				
				String viewName = null;

				// step #2. data processing ==> dispatch request to controller
				ControllerInterface handler = mapper.getHandler(path);
				
				if (path.contains("api")) {// REST API 기술
					String data = handler.handleRequest(request, response, hthService);
					
					// step #3. output processing results
					response.setContentType("text/html;charset=UTF-8");
					response.getWriter().write(data);

				} else {//페이지 이동
					if (handler != null) {
						//session이 있거나 cookie가 존재하면 넘어가기 -> 아니라면 알람띄우고 메인페이지
						viewName = handler.handleRequest(request, response, hthService);
					}
					// step #3. output processing results
					if (viewName == null) {
						viewName = "error.jsp";
					} else {
						viewName = viewName.trim();// 공백제거함
						viewName = "/WEB-INF/views/" + viewName;

						RequestDispatcher view = request.getRequestDispatcher(viewName);
						view.forward(request, response);
					}
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
