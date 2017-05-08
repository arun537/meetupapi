package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.jdbc.PreparedStatement;

import models.UserDao;
import utils.RegisterationServletHelper;
import utils.SqlConnection;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegisterationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int techTalkId = Integer.parseInt(request.getParameter("registerButton"));
		UserDao user = (UserDao)session.getAttribute("user");
		try {
			RegisterationServletHelper.insertIntoRegisterList(techTalkId, user.getEmailId());
			if(RegisterationServletHelper.isRegisteredAlready(techTalkId, user.getEmailId())){
				System.out.println("in if where update happened");
				response.sendRedirect("home.jsp");
			}
			else{
				System.out.println("in else where update doesn't happen");
				response.sendRedirect("home.jsp");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
