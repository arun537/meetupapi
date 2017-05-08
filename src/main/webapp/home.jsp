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

<link href='css/admin.css' rel='stylesheet' type='text/css'>
</head>
<body>
	<div class="main">
		<div>
			<h3>
				Welcome      <%=(((UserDao) (session.getAttribute("user"))).getUserName())%></h3>
		</div>
		<span>
			<form action="LogoutServlet" method="post">
				<span style="margin-left: 1180px; margin-top: 20px"> <input
					class='button' type="submit" name="Logout" value="logout">
				</span>
			</form>
		</span> <span>
			<form action="requestTechTalk.jsp">
					<input type="submit"
					value="Request For New TechTalk" name="Request For New TechTalk">
			</form>
		</span>
		<div>
			<table>
				<thead>
					<tr>
						<th>Title</th>
						<th>Description</th>
						<th>Presentor</th>
						<th>Date</th>
						<th>option</th>
					</tr>
				</thead>
				<%
					HttpSession session2 = request.getSession();
					UserDao user = (UserDao) session2.getAttribute("user");
					ResultSet set = HomePageHelper.getTechTalkResultSet();
					while (set.next()) {

						TechTalkDetails techmodel = new TechTalkDetails();
						techmodel.setTechTalkId(set.getInt(1));
						techmodel.setTitle(set.getString(2));
						techmodel.setDescription(set.getString(3));
						techmodel.setPresentor(set.getString(4));
						techmodel.setTechTalkDate(set.getDate(5));
				%>

				<tr>
					<td><strong><%=techmodel.getTitle()%>></strong></td>
					<td><%=techmodel.getDescription()%></td>
					<td><%=techmodel.getPresentor()%></td>
					<td><%=techmodel.getTechTalkDate()%></td>




					<%
						if (!RegisterationServletHelper.isRegisteredAlready(techmodel.getTechTalkId(), user.getEmailId())) {
					%>


					<td>
						<form action="RegisterationServlet" method="post">
							<button  type="submit" name="registerButton"
								value=<%=techmodel.getTechTalkId()%>>register</button>
						</form>
					</td>


					<%
						} else {
					%>

					<td><button  name="registerButton"
						disabled="disabled">Already registered</td>


					<%
						}
					%>




					<%
						}
					%>
				</tr>
			</table>

		</div>
	</div>
</body>
</html>