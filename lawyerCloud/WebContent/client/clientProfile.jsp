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
	<title> Client Profile </title>
	<!--Main Css Start-->
	<link rel="stylesheet" href="css/main.css">
	<!--Main Css End-->
	<!-- favicon-icon -->
	<link rel="icon" type="image/png" href="images/Favicon.png">
	<!-- favicon-icon -->
	<script src="js/modernizr.min.js"></script>  
	
	
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
	
	
				
				
											
				<!--first box start-->
				<c:forEach items="${sessionScope.clientProfileLs}" var="z">
				
				<div class="col-lg-3 col-md-3 col-sm-6" style="margin-top: 5%;margin-bottom: 5%;margin-left: 35%">
					<div class="attorney_img_wrap attorney_second_wrap">
						<div class="attorney_img"><img src="<%=request.getContextPath()%>/doc/${z.fileName}" style="width:300px;height:300px" alt="image"/>
							
						</div>
						<div class="hw_thumb_title">
							<h5>
									<a>${z.firstName } ${z.lastName }</a>
								</h5>
							
							
							
							<p>&nbsp;</p>
							<div class="overlay_social">
									<a href="<%=request.getContextPath()%>/ClientRegisterController?flag=editProfile" title="Edit Profile"> <i class="fa fa-edit">
										</i></a>
									<a href="<%=request.getContextPath()%>/ClientRegisterController?flag=changePassword" title="Change Password"> <i class="fa fa-expeditedssl">
										</i></a>
									<a href="<%=request.getContextPath()%>/ClientRegisterController?flag=changeImage" title="Change Profile Image"> <i class="fa fa-file-image-o">
										</i></a>	
								</div>
						</div>
					</div>
				</div>
				</c:forEach>
				<!--first box end-->
	<!--  			
			</div>
		</div>
	</div>
	
	
	-->
	
	
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
	<!-- jQuery  -->
        <script src="js/jquery.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/metisMenu.min.js"></script>
        <script src="js/waves.js"></script>
        <script src="js/jquery.slimscroll.js"></script>

        <!-- Parsley js -->

        <!-- App js -->
        <script src="js/jquery.core.js"></script>
        <script src="js/jquery.app.js"></script>
	

        <script type="text/javascript">
            $(document).ready(function() {
                //$('form').parsley();
            });
        </script>
	
</body>
<!-- Body End -->
</html>