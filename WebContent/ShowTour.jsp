<!-- TOURS Grid -->
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
        	<% ResultSet rs = (ResultSet) request.getAttribute("rs"); %>
        <% try { 
        	while (rs.next()) {%>
        		<div class="col-md-4 col-sm-6 portfolio-item">
		            <a class="portfolio-link" data-toggle="modal" href="#portfolioModal<%=rs.getString(1)%>">
		              <div class="portfolio-hover">
		                <div class="portfolio-hover-content">
		                  <i class="fas fa-plus fa-3x"></i>
		                </div>
		              </div>
		              <img class="img-fluid" src="<%=rs.getString(6)%>" alt="">
		            </a>
		            <div class="portfolio-caption">
		              <h4><%= rs.getString(2) %></h4>
		              <p class="text-muted"><%= rs.getString(5) %></p>
		            </div>
		          </div>

        	<% } 
        	} catch (SQLException se) {
        		se.printStackTrace();
        	} %>
        </div>
      </div>
    </section>