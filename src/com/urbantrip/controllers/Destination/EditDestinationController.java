package com.urbantrip.controllers.Destination;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.urbantrip.model.DAL;
import com.urbantrip.model.Destination;

/**
 * Servlet implementation class EditDestination
 */
@WebServlet("/EditDestination")
public class EditDestinationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDestinationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAL dal = new DAL();
		if (request.getParameter("id") != null) {
			int id = Integer.parseInt(request.getParameter("id"));
			
			Destination destination = dal.getDestination(id);
			System.out.println(destination.getName());
			request.setAttribute("destination", destination);
			request.getRequestDispatcher("EditDestination.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAL dal = new DAL();
		System.out.println(request.getParameter("idDestination"));
		System.out.println(request.getParameter("idTour"));
		int id = Integer.parseInt(request.getParameter("idDestination"));
		int idTour = Integer.parseInt(request.getParameter("idTour"));
		String name = request.getParameter("name");
		Destination destination = dal.getDestination(id);
		destination.setName(name);
		destination.setIdTour(idTour);
		dal.updateDestination(destination);
		response.sendRedirect("destination.jsp");
	}

}
