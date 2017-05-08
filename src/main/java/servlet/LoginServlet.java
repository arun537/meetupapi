package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.UserDao;
import utils.LoginServletHelper;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcherLogin = request.getRequestDispatcher("/login.jsp");
		RequestDispatcher requestDispatcherAdmin = request.getRequestDispatcher("/admin.jsp");
		HttpSession session=request.getSession();
		String email=request.getParameter("emailId");
		String password=request.getParameter("password");
		System.out.println(email+password);
		if(email=="" || password==""){
			System.out.println("in first if");
			request.setAttribute("message", "please enter email address and passowrd");		
			requestDispatcherLogin.include(request, response);
		}
		else{
			if(email.equals("admin@atmecs.com") && password.equals("admin")){
				System.out.println("in if admin");
				UserDao admin = new UserDao(email, "admin");
				session.setAttribute("admin",admin);
				requestDispatcherAdmin.include(request, response);
			}else{
				if(LoginServletHelper.isUserExist(email, password)){
					System.out.println("in second if");
					UserDao user = LoginServletHelper.getcurrentUser(email, password);	
					session.setAttribute("user",user);
					response.sendRedirect("home.jsp");
				}else{
					System.out.println("in else");
					request.setAttribute("message", "please enter enter correct email address and password");		
					requestDispatcherLogin.include(request, response);
				}
			}
		}
	}


}
