<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html>
<!--
**********************************************************************************************************
Copyright (c) 2016 Thewebdeals
********************************************************************************************************** -->
<!--
Template Name: Lawyer - A Multipurpose Template
Version: 1.0.0
Author: Thewebdeals


-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- Header Start -->
<head>
	<base href="${pageContext.request.contextPath }/client/">

	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title> Contact-Us </title>
	<!--Main Css Start-->
	<link rel="stylesheet" href="css/main.css">
	<!--Main Css End-->
	<!-- favicon-icon -->
	<link rel="icon" type="image/png" href="images/Favicon.png">
	<!-- favicon-icon -->
</head>
<!-- Header End -->
<!-- Body Start -->
<body>
	<!--Header Start-->
	<!--Top bar section Start-->
	
	<jsp:include page="header1.jsp"></jsp:include>
	
	<!--wrapper-->
	<!--Top bar section End-->
	<!--Menu Section Start-->
	
	<jsp:include page="menu1.jsp"></jsp:include>
	
	<!--wrapper-->
	<!--Menu Section End-->
	<!--Header End-->
	<!--slider section Start-->
	<div class="wrapper_main lw_header_banner">
		<!-- SLIDER --><img src="images/banner-bg.jpg" class="img-responsive" alt="banner">
		<!-- section end -->
		<!-- SLIDER -->
	</div>
	<!--wrapper-->
	<!--contact  section Start-->
	<div class="wrapper_main lw_contact_us_section">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12">
					<h3 class="lw_heading_middle">
							contact us
						</h3> </div>
			</div>
			<!--main row start-->
			<div class="row">
			
			
			
			
			
				<div class="col-lg-4 col-md-4 col-sm-4">
					<div class="contact_wrape_box">
						<div class="col-lg-2 col-md-2 col-sm-12 col-xs-12"> 
							<svg version="1.1" id="address_icon" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
							width="22px" height="33.917px" viewBox="0 0 22 33.917" enable-background="new 0 0 22 33.917" xml:space="preserve">
								<g>
									<path fill="none"  d="M20.64,15.4l-7.255,15.424c-0.418,0.877-1.335,1.415-2.292,1.415s-1.873-0.538-2.272-1.415
									L1.548,15.4c-0.519-1.097-0.658-2.352-0.658-3.567c0-5.64,4.563-10.203,10.203-10.203c5.639,0,10.204,4.563,10.204,10.203
									C21.297,13.048,21.156,14.304,20.64,15.4z M11.093,6.731c-2.81,0-5.102,2.292-5.102,5.102s2.292,5.102,5.102,5.102
									s5.102-2.292,5.102-5.102S13.903,6.731,11.093,6.731z"/>
								</g>
							</svg>
							</div>
						<div class="col-lg-10 col-md-10 col-sm-12 col-xs-12">
							<div class="lw_contact_right_detalis">
								<h4>
											address
										</h4>
								<p> Computer Science Department, University of Regina </p>
							</div>
						</div>
					</div>
					<!--contact box end-->
				</div>
				<div class="col-lg-4 col-md-4 col-sm-4">
					<div class="contact_wrape_box">
						<div class="col-lg-2 col-md-2 col-sm-12 col-xs-12">
                           <i class="fa fa-envelope-o">
									</i> </div>
						<div class="col-lg-10 col-md-10 col-sm-12 col-xs-12">
							<div class="lw_contact_right_detalis">
								<h4>
											email
										</h4>
								<p> lawyercloud10298@gmail.com
									<br/>  </p>
							</div>
						</div>
					</div>
					<!--contact box end-->
				</div>
				<div class="col-lg-4 col-md-4 col-sm-4">
					<div class="contact_wrape_box">
						<div class="col-lg-2 col-md-2 col-sm-12 col-xs-12"> 
							<svg version="1.1" id="call_icon" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
							width="27px" height="27px" viewBox="0 0 27 27" enable-background="new 0 0 27 27" xml:space="preserve">
								<g>
									<path fill="none" d="M25.806,23.553c-0.374,0.873-1.371,1.442-2.173,1.888c-1.051,0.57-2.119,0.908-3.312,0.908
									c-1.656,0-3.152-0.677-4.666-1.229c-1.086-0.392-2.137-0.873-3.116-1.479c-3.027-1.869-6.678-5.52-8.547-8.547
									c-0.605-0.979-1.086-2.03-1.478-3.116c-0.552-1.514-1.229-3.01-1.229-4.666c0-1.193,0.338-2.262,0.908-3.312
									C2.639,3.2,3.208,2.202,4.081,1.829c0.587-0.267,1.834-0.552,2.475-0.552c0.125,0,0.249,0,0.374,0.053
									c0.374,0.125,0.766,0.998,0.943,1.354c0.57,1.015,1.122,2.048,1.709,3.045c0.285,0.463,0.819,1.033,0.819,1.585
									c0,1.086-3.223,2.671-3.223,3.633c0,0.48,0.445,1.104,0.694,1.531c1.799,3.241,4.042,5.485,7.284,7.283
									c0.427,0.25,1.05,0.694,1.531,0.694c0.961,0,2.546-3.223,3.633-3.223c0.552,0,1.121,0.534,1.584,0.819
									c0.998,0.588,2.03,1.14,3.045,1.709c0.356,0.179,1.229,0.57,1.354,0.944c0.054,0.124,0.054,0.249,0.054,0.374
									C26.357,21.719,26.072,22.965,25.806,23.553z"/>
								</g>
							</svg>
									</div>
						<div class="col-lg-10 col-md-10 col-sm-12 col-xs-12">
							<div class="lw_contact_right_detalis">
								<h4>
											phone
										</h4>
								<p> +1 306 9978 786
									 </p>
							</div>
						</div>
					</div>
					<!--contact box end-->
				</div>
			</div>
			<!--main row start-->
		</div>
	</div>
	<!--contact  section End-->
	<!-- map section start-->
	<div class="wrapper_main contact_map_section">
		<!-- <div class="lw_map_part">
			<div id="contact_google_map"></div>
		</div> -->
	</div>
	<!-- map section End-->
	<!--contact form section start-->
	<div class="wrapper_main contact_form_section">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="contact_form_heading" style="margin-bottom: 2%">
						<h5>Quick</h5>
						<h3>Contact form</h3> </div>
				</div>
				<div class="lw_contact_form">
					<form method="post" action="<%=request.getContextPath()%>/ContactUsController">
					
						<div class="col-lg-6 col-md-6 col-sm-6">
							<input type="text" name="name" placeholder="Name*" class="contact_input" required id="uname"/> </div>
							
						<div class="col-lg-6 col-md-6 col-sm-6">
							<input type="email" name="email" placeholder="Email*"  class="contact_input" required id="uemail"/> </div>
							
						<div class="col-lg-6 col-md-6 col-sm-6">
							<input type="number" name="mobileNumber" placeholder="Phone*"  class="contact_input" required id="uphone"/> </div>
							
						<div class="col-lg-6 col-md-6 col-sm-6">
							<select name="service" class="form_select" id="services">
							
								<option value="0">Service*</option>
								
								<c:forEach items="${sessionScope.categoryList}" var="i">
							  
									<option value="${i.categoryId}">${i.categoryName}</option>
								
							  	</c:forEach>
								
							</select>
						</div>
						
						<div class="col-lg-12 col-md-12 col-sm-12">
						 <textarea name="description" class="contact_textarea" placeholder="comment*" required id="mesg"></textarea>
						</div>
						
						<input type="hidden" name="flag" value="insertContactUsDetails">
						
						<div class="col-lg-6 col-md-6 col-sm-6">
							<div class="submit-btn-frm col-lg-12" >
								<input type="submit" value="Submit" class="submit_btn">
							</div>
						</div>
						
					</form>
                                                      <div class="col-lg-12">
							<p id="err"></p>
                                                       </div>
				</div>
			</div>
		</div>
	</div>
	<!--contact form end-->
	
	<jsp:include page="footer1.jsp"></jsp:include>
	
	<!--SCRIPT-->
	<script type="text/javascript" src="js/jquery.min.js">
	</script>
	<script type="text/javascript" src="js/bootstrap.min.js">
	</script>
	<script type="text/javascript" src="js/jquery.appear.js">
	</script>
	<!--SCRIPT-->
	<!-- REVOLUTION JS FILES -->
	<script type="text/javascript" src="js/jquery.themepunch.tools.min.js">
	</script>
	<script type="text/javascript" src="js/jquery.themepunch.revolution.min.js">
	</script>
	<script type="text/javascript" src="js/revolution.extension.layeranimation.min.js">
	</script>
	<script type="text/javascript" src="js/revolution.extension.navigation.min.js">
	</script>
	<script type="text/javascript" src="js/revolution.extension.slideanims.min.js">
	</script>
	<script type="text/javascript" src="js/revolution.extension.actions.min.js">
	</script>
	<script type="text/javascript" src="js/revolution.extension.parallax.min.js">
	</script>
	<!-- REVOLUTION JS FiLES -->
	<!--counter js-->
	<script type="text/javascript" src="js/jquery.countTo.js">
	</script>
	<!--counter js-->
	<!-- bx slider script -->
	<script type="text/javascript" src="js/jquery-bxslider.js">
	</script>
	<!-- bx slider script end -->
	<!-- Tabs script start -->
	<script type="text/javascript" src="js/tabs.js">
	</script>
	<!-- Tabs script end -->
	<!-- owl script start -->
	<script type="text/javascript" src="js/owl.carousel.js">
	</script>
	<!-- owl script end -->
	<!--custom js-->
	<script type="text/javascript" src="js/scripts.js">
	</script>
	<!--custom js-->
	<script src="http://maps.googleapis.com/maps/api/js?key=&sensor=false"></script>
	<script>
		$(document).ready(function() {
			var myCenter=new google.maps.LatLng(52.0576897,1.0939546);
			function initialize()
			{
				var mapProp = {
					center:myCenter,
					zoom:11,
					scrollwheel: false,
					mapTypeId:google.maps.MapTypeId.ROADMAP
				};
				var map=new google.maps.Map(document.getElementById("contact_google_map"),mapProp);
				var icon = { 
					url: 'images/map_loation_icon.png'
				};
				var marker=new google.maps.Marker({
					position:myCenter,
					map: map,
					title: 'Lawyer',
					icon: icon
				});
				marker.setMap(map);
				var infowindow = new google.maps.InfoWindow({
					content:"<span>IP Switch</span>"
				});
				google.maps.event.addListener(marker, 'click', function() {
					infowindow.open(map,marker);
				});
			}
			google.maps.event.addDomListener(window, 'load', initialize);
		});
	</script>
</body>
<!-- Body End -->
</html>