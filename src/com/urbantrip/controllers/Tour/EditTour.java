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
 * Servlet implementation class EditTour
 */
@WebServlet("/EditTour")
public class EditTour extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTour() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("to edit tour: " + request.getParameter("id"));
		int id = Integer.parseInt(request.getParameter("id"));
		String tourName = request.getParameter("edittourName");
		System.out.println("\nname: " + tourName);
		String tourDescription = request.getParameter("edittourDescription");
		System.out.println("\nname: " + tourDescription);
		String price = request.getParameter("edittourPrice");
		System.out.println("\nname: " + price);
		Double tourPrice = Double.parseDouble(price);
		String tourType = request.getParameter("edittourType");
		
		Tour tour = new Tour(tourName, tourName, tourPrice, tourType);
		
		DAL dal = new DAL();
		
		dal.editTour(tour, id);

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
