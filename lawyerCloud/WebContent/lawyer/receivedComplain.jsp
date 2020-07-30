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

<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"   %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- Header Start -->
<head>

	<base href="${pageContext.request.contextPath }/lawyer/">

	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title> Received Complains </title>
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
							Received Complains
						</h3> </div>
			</div>
			<!--main row start-->
			<div class="row">
				<div class="col-lg-15 col-md-15 col-sm-15">
					
					
					<table border="1" class="table">
                                        <thead>
                                        <tr>
                                            <!-- <th>ID</th> -->
                                            <th>Client Name</th>
                                            <th>Client Email-Id</th>
                                            <!--<th>Client Contact Number</th> -->
                                            <th>Subject</th>
                                            <th>Description</th>
                                            <th>Date And Time</th>
                                            <th>Status</th>
                                            <th>Reply Description</th>
                                            <!-- <th>Action</th> -->
                                            
                                        </tr>
                                        </thead>


                                        <tbody>
                                        
                                        <c:forEach items="${sessionScope.complainList}" var="i">
										
										<tr>
											<td>${i.name}</td>
											<td>${i.fromLoginVO.email}</td> 
											<td>${i.complainSubject}</td>
											<td>${i.complainDescription}</td>
											<td>${i.complainDateAndTime}</td>
											<%-- <td>${i.complainTo}</td> --%>
											<td>${i.complainStatus}</td>
											<td>${i.replyDescription}</td>
											<%-- <td>${i.loginVO.loginId}</td> --%>
																						
											<%-- <td><a href="<%=request.getContextPath()%>/ComplainController?flag=complainReply&complainId=${i.complainId}">Reply</a></td> --%>
											<c:set var="k" value="${i.replyDescription}"></c:set>
												<c:if test="${fn:length(k) eq 0}">
													<td><a href="<%=request.getContextPath()%>/ComplainController?flag=complainReplyByLawyer&complainId=${i.complainId}">Reply</a></td>
												</c:if>
										
										</tr>
										
										</c:forEach>
                                        
                                        </tbody>
                                    </table>
					
					
					
					<!--contact box end-->
				</div>
				
				
			</div>
			<!--main row start-->
		</div>
	</div>
	<!--contact  section End-->
	<!-- map section start-->
	
	<!-- map section End-->
	<!--contact form section start-->
	
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