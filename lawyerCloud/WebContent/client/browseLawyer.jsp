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
	<title> Browse Lawyer </title>
	<!--Main Css Start-->
	<link rel="stylesheet" href="css/main.css">
	<!--Main Css End-->
	<!-- favicon-icon -->
	<link rel="icon" type="image/png" href="images/Favicon.png">
	<!-- favicon-icon -->
	<script src="js/modernizr.min.js"></script>
	
	<script type="text/javascript">
   
	function getCity()
	{
	 	var stateId=document.getElementById("stateId");
		 //alert(stateId.value); 
			removeCity();
				var htp=new XMLHttpRequest();
		
		htp.onreadystatechange=function()
			{ 
				if(htp.readyState==4)
					{
						var jsn=JSON.parse(htp.responseText);				
						
						for(var i=0;i<jsn.length;i++)
							{
								var opt=document.createElement("option");
								opt.value=jsn[i].cityId;
								opt.text=jsn[i].cityName;
								document.test.cityId.options.add(opt);
							}
					}
			}
		htp.open("get","<%=request.getContextPath()%>/CityController?flag=selCityClient&stateId="+stateId.value,true);
		htp.send();
	}
	function removeCity()
	{
		
		var removecity =document.test.cityId.options.length;
		
		for(var i=removecity-1;i>0;i--)
            {
			
            document.test.cityId.options[i].remove();
            
            }
	}	
		
		 function getArea()
		{
		 //alert("In function"); 
			var cityId=document.getElementById("cityId");
			 //alert(cityId.value); 
			removeArea();
					var htp=new XMLHttpRequest();
			
			htp.onreadystatechange=function()
				{
				 //alert("In City" + i++); 
					if(htp.readyState==4)
						{
						// alert("In if"); 
							var jsn=JSON.parse(htp.responseText);			
							// alert("In json start"); 
							for(var i=0;i<jsn.length;i++)
								{
									var opt=document.createElement("option");
									opt.value=jsn[i].areaId;
									opt.text=jsn[i].areaName;
									document.test.areaId.options.add(opt);
								}
						}
				}
			htp.open("get","<%=request.getContextPath()%>/CityController?flag=selArea&cityId="+cityId.value,true);
			htp.send();
		}
		function removeArea()
		{
			
			var removearea =document.test.areaId.options.length;
			
			for(var i=removearea-1;i>0;i--)
	            {
				
	            document.test.areaId.options[i].remove();
	            
	            }
	
	} 
</script>
	
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
				<div class="col-lg-12 col-md-12 col-sm-12">
				
					<div class="col-lg-6 col-md-6 col-sm-6" style="margin-top: 5%;"></div>
					</div>
					
						
						<div class="lw_contact_form">
						<form name="test" action="<%=request.getContextPath()%>/BrowseLawyerController" method="post">
							
						  <div class="col-lg-6 col-md-6 col-sm-6">
							
							<select name="stateName" class="form_select" parsley-trigger="change" id="stateId" onchange="getCity()">
							<option value="0">Select State</option>
							  <c:forEach items="${sessionScope.stateList}" var="i">
							  
								<option value="${i.stateId}">${i.stateName}</option>
								
							  </c:forEach>	
							
							</select>
							
						  </div>
						  	
						  <div class="col-lg-6 col-md-6 col-sm-6">	
						  	
							<select name="cityName" class="form_select" parsley-trigger="change" id="cityId" onchange="getArea()">
							<option value="0">Select City</option>
							  <%-- <c:forEach items="${sessionScope.cityList}" var="j">
							  
								<option value="${j.cityId}">${j.cityName}</option>
								
							  </c:forEach> --%>	
							
							</select>
							
						  </div>	
								
								
						  <div class="col-lg-6 col-md-6 col-sm-6">
						  						
							<select name="areaName" class="form_select" parsley-trigger="change" id="areaId">
							<option value="0">Select Area</option>
							  <%-- <c:forEach items="${sessionScope.areaList}" var="k">
							  
								<option value="${k.areaId}">${k.areaName}</option>
								
							  </c:forEach> --%>	
							
							</select>
							
						  </div>	
							
						  <div class="col-lg-6 col-md-6 col-sm-6">	
							
							<select name="categoryName" class="form_select" id="services">
							<option value="0">Select Category</option>
							  <c:forEach items="${sessionScope.categoryList}" var="l">
							  
								<option value="${l.categoryId}">${l.categoryName}</option>
								
							  </c:forEach>	
							
							</select>						
							
						  </div>	
							
							 <div class="col-lg-6 col-md-6 col-sm-6">
							<div class="submit-btn-frm col-lg-12" >
								<input type="submit" value="Search" class="submit_btn">
							</div>
							</div>
							
							<input type="hidden" name="flag" value="searchLawyer">
							
							
						</form>
						
					</div>	
									
					</div>
				</div>
			</div>			
				
											
				<!--first box start-->
				<c:forEach items="${sessionScope.lawyerList}" var="z">
				
				<div class="col-lg-3 col-md-3 col-sm-6" style="margin-top: 2%;margin-bottom: 2%;margin-left: 2%">
					<div class="attorney_img_wrap attorney_second_wrap">
						<div class="attorney_img"><img src="<%=request.getContextPath()%>/doc/${z.fileName}" style="width:200px;height:200px" alt="hello"/>
							
						</div>
						<div class="hw_thumb_title">
							<h5>
									<a>${z.firstName } ${z.lastName }</a>
								</h5>
							<p>${z.qualification }</p>
							<p>${z.categoryVO.categoryName } Lawyer</p>
							<p>${z.experience } years Experience</p>
							<p><a href="<%=request.getContextPath()%>/RequestLawyerController?flag=requestLawyer&lawyerId=${z.registerId}&categoryId=${z.categoryVO.categoryId}">Request Me</a></p>
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