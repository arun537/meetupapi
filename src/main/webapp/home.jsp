<%@page import="utils.RegisterationServletHelper"%>
<%@page import="models.TechTalkDetails"%>
<%@page import="utils.HomePageHelper"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="models.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href='http://fonts.googleapis.com/css?family=Oswald'
	rel='stylesheet' type='text/css'>
<link href="css/home.css" rel="stylesheet">
</head>
<body>
	<div class="intro">
		<h3>
			Welcome<%=(((UserDao) (session.getAttribute("user"))).getUserName())%></h3>
	</div>
	<form action="LogoutServlet" method="post">
		<span style="margin-left: 1180px; margin-top: 20px">
		 <input class='button' type="submit" value="logout">
		</span>
	</form>
	<div id="container">
		<%
			HttpSession session2 = request.getSession();
			UserDao user =(UserDao) session2.getAttribute("user");
			ResultSet set = HomePageHelper.getTechTalkResultSet();
			while (set.next()) {

				TechTalkDetails techmodel = new TechTalkDetails();
				techmodel.setTechTalkId(set.getInt(1));
				techmodel.setTitle(set.getString(2));
				techmodel.setDescription(set.getString(3));
				techmodel.setPresentor(set.getString(4));
				techmodel.setTechTalkDate(set.getDate(5));
		%>

		<div class="pricetab">
			<h1><%=techmodel.getPresentor()%></h1>
			<h1><%=techmodel.getTitle()%></h1>
			<div class="price">
				<h1><%=techmodel.getTechTalkDate()%></h1>
			</div>
			<div class="infos">
				<h1><%=techmodel.getDescription()%></h1>
			</div>
			<% if(!RegisterationServletHelper.isRegisteredAlready(techmodel.getTechTalkId(), user.getEmailId())){%>
			<div class="pricefooter">


				<form action="RegisterationServlet" method="post">
					<button class="button" type="submit" name="registerButton"
						value=<%=techmodel.getTechTalkId() %>>register</button>
				</form>
			</div>

			<%}else{%>
			<div class="pricefooter">
				<div class="button">
					<input class="button" name="registerButton" disabled="disabled">Already
					registered
					</button>
				</div>
			</div>

			<%	} %>

		</div>
	</div>


	<%
			}
		%>
	</div>
</body>
</html>