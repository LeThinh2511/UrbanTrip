package com.urbantrip.controllers.Tour;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.urbantrip.model.DAL;
import com.urbantrip.model.Tour;

/**
 * Servlet implementation class newTour
 */
@WebServlet("/addnewTour")
public class newTour extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newTour() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("to new tour: ");
		String tourName = request.getParameter("tourName");
		String tourDescription = request.getParameter("tourDescription");
		Double tourPrice = Double.parseDouble(request.getParameter("tourPrice"));
		String tourType = request.getParameter("tourType");
		
		Tour tour = new Tour(tourName, tourDescription, tourPrice, tourType);
		
		DAL dal = new DAL();
		
		dal.addNewTour(tour);

		response.sendRedirect(request.getContextPath()+ "/admin");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
