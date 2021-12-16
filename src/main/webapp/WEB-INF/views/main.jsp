<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>main</title>
	<!-- Jquery사용 URL -->	
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
	<link href="/css/common.css" rel="stylesheet" type="text/css"><!-- 공통 -->
	<link href="/css/main.css" rel="stylesheet" type="text/css"><!-- 공통 -->
</head>
<body>
	<div><h1>Hello, Airport Traffic Helper System</h1></div>
	
	<div>
		<a href="https://airport-traffic-helper-domain-service.auth.ap-northeast-2.amazoncognito.com/login?response_type=token&client_id=3623uipq359h9r0u6vegbob8hc&redirect_uri=http://localhost:8081/login_main"> Login </a>
	</div>
	
	<div><input type="button" value="TEST" id="testBtn"onclick = "location.href = '/login_main'" /></div>
</body>
</html>
