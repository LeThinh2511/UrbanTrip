package com.urbantrip.controllers.Tour;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.urbantrip.model.Tour;

@WebServlet("/ShowTour")
public class ShowTour extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ShowTour() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Tour tour = new Tour();
		ResultSet rs = tour.getListTour();
		request.setAttribute("rs", rs);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
