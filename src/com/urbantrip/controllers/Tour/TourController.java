package com.urbantrip.controllers.Tour;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.urbantrip.model.DAL;
import com.urbantrip.model.Tour;

@WebServlet("/TourController")
public class TourController extends HttpServlet {	private DAL dal;
	
	public TourController() throws SQLException, ClassNotFoundException {
		super();
		dal = new DAL();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect("/layout/admin/tour.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
