<%@page import="java.util.ArrayList"%>
<%@page import="com.urbantrip.model.DAL"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.urbantrip.model.Tour"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Body</title>
</head>
<body>
	<jsp:include page="services.jsp"></jsp:include>
	<jsp:include page="ShowTour.jsp"></jsp:include>



	<!-- About -->
	<section id="about">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2 class="section-heading text-uppercase">About</h2>
					<h3 class="section-subheading text-muted">Lorem ipsum dolor
						sit amet consectetur.</h3>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<ul class="timeline">
						<li>
							<div class="timeline-image">
								<img class="rounded-circle img-fluid" src="img/about/1.jpg"
									alt="">
							</div>
							<div class="timeline-panel">
								<div class="timeline-heading">
									<h4>2009-2011</h4>
									<h4 class="subheading">Our Humble Beginnings</h4>
								</div>
								<div class="timeline-body">
									<p class="text-muted">Lorem ipsum dolor sit amet,
										consectetur adipisicing elit. Sunt ut voluptatum eius
										sapiente, totam reiciendis temporibus qui quibusdam,
										recusandae sit vero unde, sed, incidunt et ea quo dolore
										laudantium consectetur!</p>
								</div>
							</div>
						</li>
						<li class="timeline-inverted">
							<div class="timeline-image">
								<img class="rounded-circle img-fluid" src="img/about/2.jpg"
									alt="">
							</div>
							<div class="timeline-panel">
								<div class="timeline-heading">
									<h4>March 2011</h4>
									<h4 class="subheading">An Agency is Born</h4>
								</div>
								<div class="timeline-body">
									<p class="text-muted">Lorem ipsum dolor sit amet,
										consectetur adipisicing elit. Sunt ut voluptatum eius
										sapiente, totam reiciendis temporibus qui quibusdam,
										recusandae sit vero unde, sed, incidunt et ea quo dolore
										laudantium consectetur!</p>
								</div>
							</div>
						</li>
						<li>
							<div class="timeline-image">
								<img class="rounded-circle img-fluid" src="img/about/3.jpg"
									alt="">
							</div>
							<div class="timeline-panel">
								<div class="timeline-heading">
									<h4>December 2012</h4>
									<h4 class="subheading">Transition to Full Service</h4>
								</div>
								<div class="timeline-body">
									<p class="text-muted">Lorem ipsum dolor sit amet,
										consectetur adipisicing elit. Sunt ut voluptatum eius
										sapiente, totam reiciendis temporibus qui quibusdam,
										recusandae sit vero unde, sed, incidunt et ea quo dolore
										laudantium consectetur!</p>
								</div>
							</div>
						</li>
						<li class="timeline-inverted">
							<div class="timeline-image">
								<img class="rounded-circle img-fluid" src="img/about/4.jpg"
									alt="">
							</div>
							<div class="timeline-panel">
								<div class="timeline-heading">
									<h4>July 2014</h4>
									<h4 class="subheading">Phase Two Expansion</h4>
								</div>
								<div class="timeline-body">
									<p class="text-muted">Lorem ipsum dolor sit amet,
										consectetur adipisicing elit. Sunt ut voluptatum eius
										sapiente, totam reiciendis temporibus qui quibusdam,
										recusandae sit vero unde, sed, incidunt et ea quo dolore
										laudantium consectetur!</p>
								</div>
							</div>
						</li>
						<li class="timeline-inverted">
							<div class="timeline-image">
								<h4>
									Be Part <br>Of Our <br>Story!
								</h4>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</section>

	<!-- Team -->
	<section class="bg-light" id="team">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2 class="section-heading text-uppercase">Our Amazing Team</h2>
					<h3 class="section-subheading text-muted">Lorem ipsum dolor
						sit amet consectetur.</h3>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4">
					<div class="team-member">
						<img class="mx-auto rounded-circle" src="img/team/1.jpg" alt="">
						<h4>Kay Garland</h4>
						<p class="text-muted">Lead Designer</p>
						<ul class="list-inline social-buttons">
							<li class="list-inline-item"><a href="#"> <i
									class="fab fa-twitter"></i>
							</a></li>
							<li class="list-inline-item"><a href="#"> <i
									class="fab fa-facebook-f"></i>
							</a></li>
							<li class="list-inline-item"><a href="#"> <i
									class="fab fa-linkedin-in"></i>
							</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="team-member">
						<img class="mx-auto rounded-circle" src="img/team/2.jpg" alt="">
						<h4>Larry Parker</h4>
						<p class="text-muted">Lead Marketer</p>
						<ul class="list-inline social-buttons">
							<li class="list-inline-item"><a href="#"> <i
									class="fab fa-twitter"></i>
							</a></li>
							<li class="list-inline-item"><a href="#"> <i
									class="fab fa-facebook-f"></i>
							</a></li>
							<li class="list-inline-item"><a href="#"> <i
									class="fab fa-linkedin-in"></i>
							</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="team-member">
						<img class="mx-auto rounded-circle" src="img/team/3.jpg" alt="">
						<h4>Diana Pertersen</h4>
						<p class="text-muted">Lead Developer</p>
						<ul class="list-inline social-buttons">
							<li class="list-inline-item"><a href="#"> <i
									class="fab fa-twitter"></i>
							</a></li>
							<li class="list-inline-item"><a href="#"> <i
									class="fab fa-facebook-f"></i>
							</a></li>
							<li class="list-inline-item"><a href="#"> <i
									class="fab fa-linkedin-in"></i>
							</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-8 mx-auto text-center">
					<p class="large text-muted">Lorem ipsum dolor sit amet,
						consectetur adipisicing elit. Aut eaque, laboriosam veritatis,
						quos non quis ad perspiciatis, totam corporis ea, alias ut unde.</p>
				</div>
			</div>
		</div>
	</section>

	<!-- Clients -->
	<section class="py-5">
		<div class="container">
			<div class="row">
				<div class="col-md-3 col-sm-6">
					<a href="#"> <img class="img-fluid d-block mx-auto"
						src="img/logos/envato.jpg" alt="">
					</a>
				</div>
				<div class="col-md-3 col-sm-6">
					<a href="#"> <img class="img-fluid d-block mx-auto"
						src="img/logos/designmodo.jpg" alt="">
					</a>
				</div>
				<div class="col-md-3 col-sm-6">
					<a href="#"> <img class="img-fluid d-block mx-auto"
						src="img/logos/themeforest.jpg" alt="">
					</a>
				</div>
				<div class="col-md-3 col-sm-6">
					<a href="#"> <img class="img-fluid d-block mx-auto"
						src="img/logos/creative-market.jpg" alt="">
					</a>
				</div>
			</div>
		</div>
	</section>

	<!-- Contact -->
	<section id="contact">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2 class="section-heading text-uppercase">Contact Us</h2>
					<h3 class="section-subheading text-muted">Lorem ipsum dolor
						sit amet consectetur.</h3>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<form id="contactForm" name="sentMessage" novalidate="novalidate"
						action="<%=request.getContextPath()%>/addNewTrip" method="post">
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<input class="form-control" id = "touristName" type="text"
										placeholder="Your Name *" required="required"
										data-validation-required-message="Please enter your name."
										name="touristName">
									<p class="help-block text-danger"></p>
								</div>
								<div class="form-group">
									<input class="form-control" id = "numOfParticipants" type="text"
										placeholder="Number of Participants *" required="required"
										data-validation-required-message="Please enter your number of Participants"
										name="numOfParticipants">
									<p class="help-block text-danger"></p>
								</div>
								<div class="form-group">
									<input class="form-control" id = "phoneNumber" type="tel"
										placeholder="Your Phone *" required="required"
										data-validation-required-message="Please enter your phone number."
										name="phoneNumber">
									<p class="help-block text-danger"></p>
								</div>
								<div class="form-group">
									<select class="form-control" id ="chosenTour" name="chosenTour">
										<option selected style="padding: 20px">Cycling Tour</option>
										<option style="padding: 20px">Walking Tour</option>
									</select>
								</div>
								<div class="form-group">
									<input class="form-control" id = "hotelAddress" type="text"
										placeholder="Your hotel address *" required="required"
										data-validation-required-message="Please enter your hotel address."
										name="hotelAddress">
									<p class="help-block text-danger"></p>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<input class="form-control" id="nationality" type="text"
										placeholder="Your nationality" required="required"
										data-validation-required-message="Please enter your nationality."
										name="nationality">
									<p class="help-block text-danger"></p>
								</div>
								<div class="form-group">
									<input class="form-control" id="emailTourist" type="email"
										placeholder="Your Email *" required="required"
										data-validation-required-message="Please enter your email address."
										name="email">
									<p class="help-block text-danger"></p>
								</div>

								<div class="form-group">
									<textarea class="form-control" id="message"
										placeholder="Your Message *" required="required"
										data-validation-required-message="Please enter a message."
										name="message"></textarea>
									<p class="help-block text-danger"></p>
								</div>
							</div>
							<div class="clearfix"></div>
							<div class="col-lg-12 text-center">
								<div id="success"></div>
								<button class="btn btn-primary btn-xl text-uppercase"
									type="submit" ONCLICK="button1()">Send Message</button>
								<SCRIPT>
							        function button1()
							        {
							        	if ($('#touristName').val() != ""
							        		&& $('#numOfParticipants').val() != ""
						        			&& $('#nationality').val() != ""
					        				&& $('#emailTourist').val() != "")
							        	sentMessage.submit();
							        } 
							    </SCRIPT>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>


	<!-- Tour Modals -->
	<%
		DAL dal = new DAL();
		ArrayList<Tour> allTours = dal.getAllTour();

		try {
			for (int i = 0; i < allTours.size(); i++) {
				Tour tour = allTours.get(i);
	%>
	<div class="portfolio-modal modal fade"
		id="portfolioModal<%=tour.getIdTour()%>" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="close-modal" data-dismiss="modal">
					<div class="lr">
						<div class="rl"></div>
					</div>
				</div>
				<div class="container">
					<div class="row">
						<div class="col-lg-8 mx-auto">
							<div class="modal-body">
								<!-- Project Details Go Here -->
								<h2 class="text-uppercase"><%=tour.getName()%></h2>
								<p class="item-intro text-muted"><%=tour.getType()%></p>
								<img class="img-fluid d-block mx-auto"
									src="img/tours/<%=tour.getImagePath()%>" alt="">
								<p><%=tour.getDescription()%></p>
								<ul class="list-inline">
									<li>Price: <%=tour.getPrice()%></li>
								</ul>
								<button class="btn btn-primary" data-dismiss="modal"
									type="button">
									<i class="fas fa-times"></i> Close
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%
		}
		} catch (Exception se) {
			se.printStackTrace();
		}
	%>

</body>
</html>