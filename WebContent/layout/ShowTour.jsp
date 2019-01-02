<!-- TOURS Grid -->
    <%@page import="com.urbantrip.model.Tour"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.urbantrip.model.DAL"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.sql.ResultSet,java.sql.SQLException"%>
<section class="bg-light" id="portfolio">
      <div class="container">
        <div class="row">
          <div class="col-lg-12 text-center">
            <h2 class="section-heading text-uppercase">TOUR</h2>
            <h3 class="section-subheading text-muted">We currently provide these tours:</h3>
          </div>
        	<% 
        		DAL dal = new DAL();
        		ArrayList<Tour> allTours = dal.getAllTour() ; 
        	%>
        <% try { 
        	for (int i = 0; i < allTours.size(); i++) { 
        		Tour tour = allTours.get(i); %>        		<div class="col-md-4 col-sm-6 portfolio-item">
					<a class="portfolio-link" data-toggle="modal" href="#portfolioModal<%=tour.getIdTour()%>">		              <div class="portfolio-hover">
		                <div class="portfolio-hover-content">
		                  <i class="fas fa-plus fa-3x"></i>
		                </div>
		              </div>
		              <img class="img-fluid" src="img/tours/<%=tour.getImagePath()%>" alt="">
		            </a>
		            <div class="portfolio-caption">
		              <h4><%= tour.getName() %></h4>
		              <p class="text-muted"><%= tour.getType() %></p>
		            </div>
		          </div>

        	<% } 
        	} catch (Exception se) {
        		se.printStackTrace();
        	} %>
        </div>
      </div>
    </section>