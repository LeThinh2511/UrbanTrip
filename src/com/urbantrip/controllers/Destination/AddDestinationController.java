package com.urbantrip.controllers.Destination;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.urbantrip.model.DAL;
import com.urbantrip.model.Destination;

/**
 * Servlet implementation class AddDestinationController
 */
@WebServlet("/AddDestinationController")
@javax.servlet.annotation.MultipartConfig
public class AddDestinationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDestinationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("AddDestination.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAL dal = new DAL();
		int idTour = Integer.parseInt(request.getParameter("idTour"));
		String name = request.getParameter("name");
		InputStream inputStream = null;
		int imageID = dal.getMaxImageID() + 1;
		Destination destination = new Destination(idTour, name, imageID);
		Part filePart = request.getPart("image");
		if (filePart != null) {
            inputStream = filePart.getInputStream();
            dal.addImage(inputStream, imageID);
            dal.addDestination(destination);
            response.sendRedirect("destination.jsp");
        } else {
        	System.out.println("loi upload image");
        }
	}

}
