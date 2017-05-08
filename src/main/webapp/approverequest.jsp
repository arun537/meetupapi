<%@page import="models.TechTalkDetails"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="utils.SqlConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>approve/diapprove request</title>
</head>
<body>
<% 
	Connection connection = SqlConnection.getconnection();
	ResultSet techTalkList = connection.createStatement().executeQuery("select * from newtechtalkdetails");
%>
	<div>
		<table>
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
						System.out.println("in while loop start approve");
						//System.out.println(techTalkList.getString(2));
						//System.out.println(techTalkList.getString("title"));
						TechTalkDetails techTalk = new TechTalkDetails();
						techTalk.setTechTalkId(techTalkList.getInt(1));
						techTalk.setTitle(techTalkList.getString(2));
						techTalk.setDescription(techTalkList.getString(3));
						techTalk.setPresentor(techTalkList.getString(4));
						techTalk.setTechTalkDate(techTalkList.getDate(5));
						System.out.println(techTalk + "in approve check techtalk recieved");
				%>




				<tr>
					<td><strong><%=techTalk.getTitle()%></strong></td>
					<td><%=techTalk.getTechTalkDate()%></td>
					<td><%=techTalk.getDescription()%></td>
					<td><%=techTalk.getPresentor()%></td>
					<td>
						<form action="UpdateTechTalkListServlet" method="post">
							<button class="button" type="submit" name="Approve"
								value=<%=techTalk.getTechTalkId()%>>Approve</button>
						</form>
					</td>
					<td>
						<form action="DeleteTechTalkListRequestServlet" method="post">
							<button class="button" type="submit" name="Disapprove"
								value=<%=techTalk.getTechTalkId()%>>Dis-Approve</button>
						</form>
					</td>
				</tr>


				<%
					}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>