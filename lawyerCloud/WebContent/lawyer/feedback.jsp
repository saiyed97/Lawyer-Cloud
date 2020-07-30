<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

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
	<title> Feedback </title>
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
	<!--contact  section End-->
	<!-- map section start-->
	
	<!-- map section End-->
	<!--contact form section start-->
	<div class="wrapper_main contact_form_section">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="contact_form_heading">
						
						<h3>Send a Feedback</h3> </div>
				</div>
				<div class="lw_contact_form">
					<form method="post" action="<%=request.getContextPath()%>/FeedbackController">
						
						<!-- <div class="col-lg-12 col-md-6 col-sm-6">
							<select name="to" placeholder="To*" class="form_select" id="services">
							
								<option>Admin</option>
								<option>Lawyer</option>
                                            
							</select>
						</div> -->
						
						<div class="col-lg-12 col-md-6 col-sm-6">
							<input type="text" name="feedbackSubject" placeholder="Feedback Subject*" class="contact_input" required id="uname"/> 
						</div>
						
													
						<div class="col-lg-12 col-md-12 col-sm-12">
						 <textarea name="feedbackDescription" class="contact_textarea" placeholder="Feedback Description*" required id="mesg"></textarea>
						</div>		
	
						<input type="hidden" name="feedbackToRegisterId" value="1">
						<input type="hidden" name="flag" value="feedbackToAdminByLawyer">
						
						
						<div class="col-lg-6 col-md-6 col-sm-6">
							<div class="submit-btn-frm col-lg-12" >
								<input type="submit" value="Post" class="submit_btn">
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