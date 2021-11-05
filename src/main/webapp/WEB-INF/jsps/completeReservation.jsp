<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Complete Reservation </h2>
AirLine       :${flight.operAirline}<br/>
Departure City:${flight.dCity}<br/>
Arrival City  :${flight.arCity}<br/>

<form action="completeReservation" method="post">
<pre>
<h2>Passenger Details</h2>
First Name :<input type="text" name="pFisrtName" />
Last Name  :<input type="text" name="pLastName" />
Email 	   :<input type="text" name="pEmail" />
Phone #    :<input type="text" name="pPhone" />

<h2>Card Details </h2>
Name on he Card :<input type="text" name="nameOnTheCard"/>
Card No.	 	:<input type="text" name="cardNo"/>
Expiry Date	 	:<input type="text" name="expiryDate"/>
Pin Code	 	:<input type="text" name="pinCode"/>
<input type="hidden" name="id" value="${flight.id}"/>
<input type="submit" value="confirm"/>
</pre>

</form>

</body>
</html>