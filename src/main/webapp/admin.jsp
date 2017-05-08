<%@page import="utils.LoginServletHelper"%>
<%@page import="models.TechTalkDetails"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href='css/admin.css' rel='stylesheet' type='text/css'>
<link href='css/button.css' rel='stylesheet'>
<link href='css/login.css' rel='stylesheet'>
</head>
<body>
	<div class="main">
			<form action="LogoutServlet" method="post">
			<span  style="margin-left: 1180px; margin-top: 20px" >
				<input class='button' type="submit" value="logout">
			</span>
		</form>

		<%
			ResultSet techTalkList = LoginServletHelper.getListOfTechTalk();
			if (techTalkList.next()) {
				System.out.println("in admin jsp result set is not empty");
			} else {
				System.out.println("in admin jsp result set is empty");
			}
		%>
		<div>

			<h2 style="color: white; margin-bottom: 10px;">Welcome Admin</h2>
			<hr>
			<!-- <p style="margin-top: 20px; margin-left: 1120px">aur sunao</p> -->
			<div style="margin-top: 20px; margin-left: 760px; margin-bottom: 20px" >
				<span style="float: left;">
					<form action="newtechtalk.jsp">
						<button class="btn btn-default"">Add New talk</button>
					</form>
				</span> 
				<span style="float: right;">
				<form action="SeeNewRequestServlet" method="post">
						<button class="btn btn-success" style="margin-right: 220px">See New Requests</button>
				</form>
				</span>
			</div>
		</div >
		<table >
			<thead>
				<tr>
					<th>Title</th>
					<th>Date</th>
					<th>Description</th>
					<th>Presentor</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<%
					while (techTalkList.next()) {
						System.out.println("in while loop start");
						System.out.println(techTalkList.getString(2));
						System.out.println(techTalkList.getString("title"));
						TechTalkDetails techTalk = new TechTalkDetails();
						techTalk.setTechTalkId(techTalkList.getInt(1));
						techTalk.setTitle(techTalkList.getString(2));
						techTalk.setDescription(techTalkList.getString(3));
						techTalk.setPresentor(techTalkList.getString(4));
						techTalk.setTechTalkDate(techTalkList.getDate(5));
						System.out.println(techTalk + "in while of admin.jsp");
				%>




				<tr>
					<td><strong><%=techTalk.getTitle()%></strong></td>
					<td><%=techTalk.getTechTalkDate()%></td>
					<td><%=techTalk.getDescription()%></td>
					<td><%=techTalk.getPresentor()%></td>
					<td>
						<form action="updatetechtalk.jsp">
							<button class="button" type="submit" name="registerButton"
								value=<%=techTalk.getTechTalkId()%>>Update</button>
						</form>
					</td>
					<td>
						<form action="AdminDeleteServlet" method="post">
							<button class="button" type="submit" name="registerButton"
								value=<%=techTalk.getTechTalkId()%>>Delete</button>
						</form>
					</td>
				</tr>


				<%
					}
				%>
			</tbody>
		</table>
		<form action="approverequest.jsp"><button type="submit"></button>
		</form>
	</div>

</body>
</html>