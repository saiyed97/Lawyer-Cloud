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

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">

<!--<![endif]-->
<!-- Header Start -->
<head>

	<base href="${pageContext.request.contextPath }/client/">

	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title> Accept Request </title>
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
		<!-- SLIDER -->
		<!-- section end -->
		<!-- SLIDER -->
	</div>
	<!--wrapper-->
	<!--practice area section start-->
	
	<!--practice area section End-->
	<!--mission section start-->
	
	<!--mission Section End-->
	<!--Client section Start-->
	
	<!-- wrapper -->
	<!--Client section End-->
	<!-- Our Attorneys Section start-->
	
		

	<div class="wrapper_main lw_history_section">
		<div class="container">
			<div class="row">
				<!-- <div class="col-lg-12 col-md-12 col-sm-12"> -->
				
					<!-- <div class="col-lg-6 col-md-6 col-sm-6"> -->
					
					<div class="lw_contact_form">
						
						<form action="<%=request.getContextPath()%>/RequestLawyerController" method="post">
						
							<c:forEach items="${sessionScope.clientRequestList }" var="i">
							
								<div class="col-lg-10 col-md-10 col-sm-10" style="margin-top: 5%">
								
									<label >Request Description</label>
								
								<textarea name="requestDescription" class="contact_input" required value="${i.requestDescription }" id="mesg">${i.requestDescription }</textarea>
								
								</div>
                                        
                                        <input type="hidden" name="requestLawyerId" value="${i.requestLawyerId}">
                                        
                                        <input type="hidden" name="registerId" value="${i.lawyerRegisterVO.registerId}">
                                        
                                        <input type="hidden" name="loginId" value="${i.loginVO.loginId}">
                                        
                                        <input type="hidden" name="mobileNumber" value="${i.mobileNumber}">
                                        
                                        <input type="hidden" name="requestDateAndTime" value="${i.requestDateAndTime}">
                                        
                                        <input type="hidden" name="requestStatus" value="${i.requestStatus}">
                                        
                                        <input type="hidden" name="requestReplyDescription" value="${i.requestReplyDescription}">
                                        
                                        <input type="hidden" name="categoryId" value="${i.categoryVO.categoryId}">
										
										<input type="hidden" name="flag" value="insertAcceptRequestDescription">
							
							</c:forEach>		
							
							
							<div class="col-lg-10 col-md-10 col-sm-10" style="margin-top: 5%">
							
							<textarea name="acceptRequestDescription" class="contact_input" placeholder="Write a Accept Request Description*" required id="mesg"></textarea>
							
							</div>
							
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
				<!-- </div> -->
			</div>
		</div>
	</div>			
				
											
	
	
	<!-- Our Attorneys Section End-->
	<!-- Crousel Section End-->
	
	<!-- Crousel Section End-->
	
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
</body>
<!-- Body End -->
</html>