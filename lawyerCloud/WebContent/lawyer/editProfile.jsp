
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
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
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title> Lawyer Edit Profile </title>
	<!--Main Css Start-->
	<link rel="stylesheet" href="css/main.css">
	<!--Main Css End-->
	<!-- favicon-icon -->
	<link rel="icon" type="image/png" href="images/Favicon.png">
	<!-- favicon-icon -->
	
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
		
		function getSubCategory()
		{
		 	var categoryId=document.getElementById("categoryId");
			 //alert(categoryId.value); 
				removeSubCategory();
					var htp=new XMLHttpRequest();
			
			htp.onreadystatechange=function()
				{ 
					if(htp.readyState==4)
						{
							var jsn=JSON.parse(htp.responseText);				
							
							for(var i=0;i<jsn.length;i++)
								{
									var opt=document.createElement("option");
									opt.value=jsn[i].subCategoryId;
									opt.text=jsn[i].subCategoryName;
									document.test.subCategoryId.options.add(opt);
								}
						}
				}
			htp.open("get","<%=request.getContextPath()%>/CityController?flag=selSubCategoryClient&categoryId="+categoryId.value,true);
			htp.send();
		}
		function removeSubCategory()
		{
			
			var removesubCategory =document.test.subCategoryId.options.length;
			
			for(var i=removesubCategory-1;i>0;i--)
	            {
				
	            document.test.subCategoryId.options[i].remove();
	            
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
		<!-- SLIDER --><!-- <img src="images/banner-bg.jpg" class="img-responsive" alt="banner"> -->
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
					<div class="contact_form_heading" style="margin-top: 4%">
						<h3> </h3>
						<h3>Edit Profile</h3> </div>
				</div>
				
				
				
				
				
				<div class="lw_contact_form">
				
					<c:forEach items="${sessionScope.lawyerProfileLs}" var="z">
				
					<form name="test" method="post" action="<%=request.getContextPath()%>/LawyerRegisterController" enctype="multipart/form-data">
						
						
						
						
						<div class="col-lg-6 col-md-6 col-sm-6">
							<input type="text" name="firstName" value="${z.firstName }" placeholder="First Name*" class="contact_input" required id="uname"/> </div>
						
						<div class="col-lg-6 col-md-6 col-sm-6">
							<input type="text" name="lastName" value="${z.lastName }" placeholder="Last Name*"  class="contact_input" required id="uemail"/> </div>
						
						<%-- <div class="col-lg-6 col-md-6 col-sm-6">
							<input type="email" name="email" value="${z.loginVO.email }" placeholder="Email*"  class="contact_input" required id="uphone"/> </div>
							
						<div class="col-lg-6 col-md-6 col-sm-6">
							<input type="password" name="password" value="${z.loginVO.password }" placeholder="Password*"  class="contact_input" required id="uphone"/> </div> --%>
							
						<div class="col-lg-6 col-md-6 col-sm-6">
							<input type="number" name="mobileNumber" value="${z.mobileNumber }" placeholder="Mobile Number*"  class="contact_input" required id="uphone"/> </div>		
						
						
						<div class="col-lg-6 col-md-6 col-sm-6">
						
							<select name="stateId" class="form_select" id="stateId" onchange="getCity()" >
								
								  <c:forEach items="${sessionScope.stateList}" var="i">

												<c:if test="${i.stateId eq z.stateVO.stateId }" >
                                                   <option value="${i.stateId}" selected="selected">${i.stateName}</option>
												</c:if>

												<c:if test="${i.stateId ne z.stateVO.stateId }">
                                                   <option value="${i.stateId}">${i.stateName}</option>
												</c:if>
                                                   
                                                        
                                 </c:forEach>							
							</select>
							
						</div>
						
						<div class="col-lg-6 col-md-6 col-sm-6">
						
							<select name="cityId" class="form_select" id="cityId" onchange="getArea()">
								
								<option value="0">Select City</option>
								
								<c:forEach items="${sessionScope.cityList}" var="p">
								
                                                <c:if test="${p.cityId eq z.cityVO.cityId}">   
                                                   <option value="${p.cityId}" selected="selected">${p.cityName}</option>
                                                   </c:if>
                                                   <c:if test="${p.cityId ne z.cityVO.cityId}">   
                                                   <option value="${p.cityId}">${p.cityName}</option>
                                                   </c:if>       
                                                   
                                </c:forEach>
								
							</select>
							
						</div>
						
						<div class="col-lg-6 col-md-6 col-sm-6">
							<select name="areaId" class="form_select" id="areaId">
								
								<option value="0">Select Area</option>
								
								<c:forEach items="${sessionScope.areaList}" var="r">
								
								<c:if test="${r.areaId eq z.areaVO.areaId}">   
                                                   <option value="${r.areaId}" selected="selected">${r.areaName}</option>
                                                   </c:if>
                                                   <c:if test="${r.areaId ne z.areaVO.areaId}">   
                                                   <option value="${r.areaId}">${r.areaName}</option>
                                                   </c:if>
							
								</c:forEach>
								
							</select>
							
						</div>
						
						
						<div class="col-lg-6 col-md-6 col-sm-6">
						
							<select name="categoryId" class="form_select" id="categoryId" onchange="getSubCategory()">
								
								<c:forEach items="${sessionScope.categoryList}" var="p">
								
                                                <c:if test="${p.categoryId eq z.categoryVO.categoryId}">   
                                                   <option value="${p.categoryId}" selected="selected">${p.categoryName}</option>
                                                   </c:if>
                                                   <c:if test="${p.categoryId ne z.categoryVO.categoryId}">   
                                                   <option value="${p.categoryId}">${p.categoryName}</option>
                                                   </c:if>       
                                                   
                                </c:forEach>
								
							</select>
							
						</div>
						
						<div class="col-lg-6 col-md-6 col-sm-6">
						
							<select name="subCategoryId" class="form_select" id="subCategoryId">
								
								<option value="0">Sub Category</option>
									
									<c:forEach items="${sessionScope.subCategoryList}" var="p">
								
                                                <c:if test="${p.subCategoryId eq z.subCategoryVO.subCategoryId}">   
                                                   <option value="${p.subCategoryId}" selected="selected">${p.subCategoryName}</option>
                                                   </c:if>
                                                   <c:if test="${p.subCategoryId ne z.subCategoryVO.subCategoryId}">   
                                                   <option value="${p.subCategoryId}">${p.subCategoryName}</option>
                                                   </c:if>       
                                                   
                                </c:forEach>
								
							</select>
							
						</div>
						
						<div class="col-lg-6 col-md-6 col-sm-6">
							<input type="text" name="experience" value="${z.experience }" placeholder="Experience*" required  class="contact_input" id="uphone"/> </div>
						
						
						
						<div class="col-lg-6 col-md-6 col-sm-6">
							<input type="text" name="qualification" value="${z.qualification }" placeholder="Educational Qualification*" required  class="contact_input" id="uphone"/> </div>
						
						<div class="col-lg-12 col-md-12 col-sm-12">
						
						 <textarea name="address"  class="contact_textarea" placeholder="Address*" required id="mesg">${z.address }</textarea>
						 
						</div>
						
						
						<input type="hidden" name="registerId" value="${z.registerId}">
						<input type="hidden" name="fileName" value="${z.fileName}">
						<input type="hidden" name="filePath" value="${z.filePath}">
						<input type="hidden" name="loginId" value="${z.loginVO.loginId}">
											
						
						<input type="hidden" name="flag" value="editProfile">
						
						<div class="col-lg-6 col-md-6 col-sm-6">
							<div class="submit-btn-frm col-lg-12" >
								<input type="submit" value="Submit" class="submit_btn">
							</div>
						</div>
							
							<div class="col-lg-12">
								
                                                       </div>
							
					</form>
                    </c:forEach>                              
                                                  
                                                      
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
	
</body>
<!-- Body End -->
</html>