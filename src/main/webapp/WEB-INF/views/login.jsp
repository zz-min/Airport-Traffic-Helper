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
</head>
<body>
	<h1>Login success!!</h1>
	<div id="selectContainer">
			<div id="serchFlightFormContainer">
			<form id="serchFlightForm">
				<label>항공사 : </label> 
				<select name="checkedAirline" id="checkedAirline" class="checkedserchFlight">
					<option value="none" style="opacity: 0.4">=== (선택) ===&nbsp&nbsp&nbsp</option>
					<%-- <c:forEach var="i" begin="0" end="${fn:length(airlineNameList)-1}">
						<option value="${airlineNameList[i]}">${airlineNameList[i]}&nbsp&nbsp&nbsp</option>
					</c:forEach> --%>
				</select>
				
				<label>출발날짜 : </label> 
				<input type="text" id="checkedDep_date" class="datepicker" required="required"/>
				
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
					<%-- <c:forEach var="i" begin="0" end="${fn:length(airportNameList)-1}">
						<option value="${airportNameList[i]}">${airportNameList[i]}&nbsp&nbsp&nbsp</option>
					</c:forEach> --%>
				</select>
				
				<input type="button" value="항공편 찾기" id="serchFlightBtn"/>
			</form>
			</div>
		</div>
		<div>

		</div>
</body>
</html>