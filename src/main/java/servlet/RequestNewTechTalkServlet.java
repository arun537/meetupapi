package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.TechTalkDetails;
import utils.RequestNewTechTalkServletHelper;

/**
 * Servlet implementation class RequestNewTechTalkServlet
 */
public class RequestNewTechTalkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestNewTechTalkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = sdf.parse(request.getParameter("techtalkdate"));
			Date newdate = new Date(date.getTime());
			TechTalkDetails newtechtalkrequest = new TechTalkDetails();
			newtechtalkrequest.setTitle(request.getParameter("title"));
			newtechtalkrequest.setDescription(request.getParameter("description"));
			newtechtalkrequest.setPresentor(request.getParameter("presentor"));
			newtechtalkrequest.setTechTalkDate(newdate);
			RequestNewTechTalkServletHelper.AddRquestForTechTalk(newtechtalkrequest);
			response.sendRedirect("home.jsp");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
