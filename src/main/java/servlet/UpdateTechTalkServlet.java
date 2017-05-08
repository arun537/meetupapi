package servlet;

import java.awt.font.TextHitInfo;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.TechTalkDetails;
import utils.SqlConnection;
import utils.UpdateTechTalkHelper;

/**
 * Servlet implementation class UpdateTechTalkServlet
 */
public class UpdateTechTalkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTechTalkServlet() {
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
		System.out.println("in update tech talk servlet");
		//Connection connection = SqlConnection.getconnection();
		try {
		TechTalkDetails techtalk = new TechTalkDetails();
		//System.out.println(request.getParameter("techtalkid")+"in tech talk id print"+request.getParameter("flag"));
		techtalk.setTechTalkId(Integer.parseInt(request.getParameter("techtalkid")));
		techtalk.setTitle(request.getParameter("title"));
		techtalk.setDescription(request.getParameter("description"));
		techtalk.setPresentor(request.getParameter("presentor"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = sdf.parse(request.getParameter("techtalkdate"));
		java.sql.Date newdate = new Date(date.getTime());
		techtalk.setTechTalkDate(newdate);
		UpdateTechTalkHelper.updateTechTalkDeatils(techtalk);
		System.out.println(techtalk);
		response.sendRedirect("admin.jsp");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		}
		
}
