<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign In into Tech Talk</title>
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/login.css">
<link rel='stylesheet' href="css/button.css">
</head>
<body>


	<div class="main">
		<div class="container">

			<center>
				<div class="middle">
					<div id="login">
						<h4><%=request.getAttribute("message")%></h4>
						<form action="LoginServlet" method="post">
							<fieldset class="clearfix">
								<p>
									<span class="fa fa-user"></span><input type="text"
										Placeholder="EmailId" name="emailId"
										pattern="[a-z0-9._]+@atmecs.com" required>
								</p>
								<!-- JS because of IE support; better: placeholder="Username" -->
								<p>
									<span class="fa fa-lock"></span><input type="password"
										Placeholder="Password" name="password" required maxlength="16">
								</p>
								<!-- JS because of IE support; better: placeholder="Password" -->

								<div>
									<span
										style="width: 48%; text-align: left; display: inline-block;"><a
										class="small-text" href="#">Forgot password?</a></span> <span
										style="width: 50%; text-align: right; display: inline-block;"><input
										type="submit" value="Sign In"></span>
								</div>
							</fieldset>
							<div class="clearfix"></div>
						</form>
						<div class="clearfix"></div>
					</div>
					<!-- end login -->
					<div class="logo">
						TECHTALK

						<div class="clearfix"></div>
					</div>

				</div>
			</center>
		</div>
	</div>
</body>
</html>