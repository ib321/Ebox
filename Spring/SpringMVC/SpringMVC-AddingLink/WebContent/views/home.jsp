<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Event Weekend</title>
<style type="text/css">
#grad1 {
	height: 50%;
	background: lightsteelblue;
	background: linear-gradient(lightsteelblue, lightskyblue);
}

body {
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: center;
}

.header {
	background-color: lightsteelblue;
	width: 100%;
}

.footer {
	position: absolute;
	right: 0;
	bottom: 0;
	left: 0;
	height: 5%;
	text-align: center;
}

.userDetails {
	text-align: center;
}

#content {
	top: 220;
	left: 150;
	text-align: center;
}

p {
	margin-left: 20px;
	font-family: 'Courier New', Courier, 'Lucida Sans Typewriter',
		'Lucida Typewriter', monospace;
	font-size: 16px;
	font-style: normal;
	font-variant: normal;
	font-weight: bold;
	line-height: 26.4px;
}

.boxed {
	width: 40%;
	padding-top: 5px;
	padding-right: 180px;
	padding-left: 5px;
	border: 2px solid black;
	margin: 10px;
	text-align: left;
}

.p1 {
	color: white;
}
</style>
</head>

<body>

	<div class="header">
		<table>
			<tr>
				<td><img
					src="${pageContext.request.contextPath}webapp/resources/images/abcevents.png"
					height="120" width="150" style="float: left"></td>
				<td><span style="vertical-align: middle">
						<h1
							style="font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif">Enriching
							Entertainment</h1>
				</span></td>
			</tr>
		</table>
		<span style="float: right"> <a href="<c:url value="/home/" />">Home</a>&nbsp&nbsp
			<a href="<c:url value="/contactUs/" />">Contact Us</a>&nbsp&nbsp <a
			href="<c:url value="/todaysEvents/" />">Today's Events</a>
		</span>
	</div>
	<br>
	<br>
	<div id="content">
		<p align="center" class="boxed">"All work and no play makes Jack a
			dull boy!" . In this age of internet and technology, we are not
			entertained but distracted by the constant notifications and an itch
			to look at what is going somewhere else. Why not give us an
			opportunity to entertain you. We have a variety of events here. Of
			course, it may be less cool , but we bet you will feel refreshed.
			Bring in your family! Bring in your friends! YO-HO-HO! Let's enjoy
			the weekend as nature made us to enjoy!!!</p>
	</div>
	<br>
	<div id="userDetails">
		<h2>User Details</h2>

		<table border="1">
			<tr>
				<th>Name</th>
				<th>Phone number</th>
				<th>email id</th>
				<th colspan="4">Address</th>
			</tr>
			<c:forEach var="user" items="${userList}">
				<tr>
					<td><h3>${user.userName}</h3></td>
					<td>${user.phoneNumber}</td>
					<td>${user.emailId}</td>
					<td>${user.line1}</td>
					<td>${user.line2}</td>
					<td>${user.city}</td>
					<td>${user.pincode}</td>
				</tr>
			</c:forEach>
		</table>
	</div>



</body>

</html>