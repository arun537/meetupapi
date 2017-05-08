<%@page import="models.UserDao"%>
<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href='css/newtechtalk.css' rel='stylesheet'>
<link href="css/login.css" rel='stylesheet'>
</head>
<body>

	<div class="main">
		<div class="container">
			<form id="contact" action="RequestNewTechTalkServlet" method="post">
				<h2>Request New TechTalk Form</h2>

				<fieldset>
					<input placeholder="TechTalk Title" type="text" name="title"
						required autofocus>
				</fieldset>
				<fieldset>
					<input placeholder="Description" type="text" name="description"
						required>
				</fieldset>
				<fieldset>
					<input placeholder="Presentor Name" type="text" name="presentor"  tabindex="3"
						required >
				</fieldset>
				<fieldset>
					<input placeholder="Date for TechTalk" name="techtalkdate" type="date" tabindex="4"
						required>
				</fieldset>
				<fieldset>
					<button name="submit" type="submit" id="contact-submit">Submit</button>
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>