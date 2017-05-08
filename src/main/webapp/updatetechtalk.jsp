<%@page import="models.TechTalkDetails"%>
<%@page import="utils.AdminServletHelper"%>
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
	<%
		int techTalkId = Integer.parseInt(request.getParameter("registerButton"));
		System.out.println(request.getParameter("registerButton"));
		TechTalkDetails techtalk = AdminServletHelper.gettechTalkById(techTalkId);
		
	%>
	
	<div class="main">
		<div class="container">
			<form action="UpdateTechTalkServlet" method="post">
				<h3 style="color: black;">Update TechTalk Form</h3>
				
				<fieldset>
					<input type="hidden" name="techtalkid" value=<%=techTalkId %>>
				</fieldset>
				<fieldset>
					<input type="text" tabindex="1" placeholder=<%=techtalk.getTitle()%>
						name="title" required autofocus>
				</fieldset>
				<fieldset>
					<input type="text" tabindex="2"
						placeholder=<%=techtalk.getDescription()%> name="description" required>
				</fieldset>
				<fieldset>
					<input type="text" tabindex="3"
						placeholder=<%=techtalk.getPresentor()%> name="presentor" required>
				</fieldset>
				<fieldset>
					<input type=date tabindex="4"
						placeholder=<%=techtalk.getTechTalkDate()%> name="techtalkdate"  required>
				</fieldset>
				<fieldset>
					<button name="submit" type="submit">Update</button>
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>