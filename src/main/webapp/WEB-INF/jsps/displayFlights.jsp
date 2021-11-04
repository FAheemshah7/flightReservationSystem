<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page isELIgnored="false" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flights Information</title>

</head>
<body>
<h2>
Flights Information
</h2>

<table>
<tr>
<th> Air Lines </th>
<th> Departure City </th>
<th> Arrival City </th>
<th> Departure Time </th>
</tr>
<c:forEach items="${flights}" var="flight">
<tr>
<td>${flight.operAirline} </td>
<td>${flight.dCity} </td>
<td>${flight.arCity} </td>
<td>${flight.estimedDepartureTime} </td>
<td><a href="showCompleteReservation?flightId=${flight.id}">Select </a></td>
</tr>

</c:forEach>
</table>
</body>
</html>