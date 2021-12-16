<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.util.*"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
	<!-- Jquery사용 URL -->	
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
	<script src="/js/main.js?d" defer></script>
	<link href="/css/common.css" rel="stylesheet" type="text/css"><!-- 공통 -->
	<link href="/css/login.css" rel="stylesheet" type="text/css"><!-- 모든 다이알로그 공통 -->
</head>
<body>
	<h1>Hi, user :)</h1>
	<div id="selectContainer">
			<div id="serchFlightFormContainer">
			<form id="serchFlightForm">
				<label>항공사 : </label> 
				<select name="checkedAirline" id="checkedAirline" class="checkedserchFlight">
					<option value="none" style="opacity: 0.4">=== (필수) ===&nbsp&nbsp&nbsp</option>
					<c:forEach var="i" begin="0" end="${fn:length(airlineNameList)-1}">
						<option value="${airlineNameList[i]}">${airlineNameList[i]}&nbsp&nbsp&nbsp</option>
					</c:forEach>
				</select>
				
				<label>출발날짜 : </label> 
				<input type="text" id="checkedDep_date" placeholder="'2021-01-05'형식으로 입력하시오." required="required"/>
				
				<label>출발지 : </label> 
				<select name="checkedOrigin" id="checkedOrigin" class="checkedserchFlight" required="required">
					<option value="none" style="opacity: 0.4">=== (필수) ===&nbsp&nbsp&nbsp</option>
					<c:forEach var="i" begin="0" end="${fn:length(airportNameList)-1}">
						<option value="${airportNameList[i]}">${airportNameList[i]}&nbsp&nbsp&nbsp</option>
					</c:forEach>
				</select>
				
				<label>도착지 : </label> 
				<select name="checkedDest" id="checkedDest" class="checkedserchFlight" required="required">
					<option value="none" style="opacity: 0.4">=== (필수) ===&nbsp&nbsp&nbsp</option>
					<c:forEach var="i" begin="0" end="${fn:length(airportNameList)-1}">
						<option value="${airportNameList[i]}">${airportNameList[i]}&nbsp&nbsp&nbsp</option>
					</c:forEach>
				</select>
				
				<input type="button" value="선택" id="sBtn" />
			</form>
			</div>
		</div>
		<div>

		</div>
</body>
</html>