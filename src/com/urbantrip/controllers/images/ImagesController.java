package com.urbantrip.controllers.images;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.urbantrip.model.DAL;

/**
 * Servlet implementation class ImagesController
 */
@WebServlet("/ImagesController")
public class ImagesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImagesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Check point 111111111");
		DAL dal = new DAL();
		int id = Integer.parseInt(request.getParameter("id"));
		byte[] content = dal.getImage(id);
		response.setContentType("image/gif");
        response.setContentLength(content.length);
        response.getOutputStream().write(content);
        System.out.println("Check point 11111222333");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
