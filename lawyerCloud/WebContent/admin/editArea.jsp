<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

    <!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Edit Area</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
        <meta content="A fully featured admin theme which can be used to build CRM, CMS, etc." name="description" />
        <meta content="Coderthemes" name="author" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />

        <!-- App favicon -->
        <link rel="shortcut icon" href="images/favicon.ico">

        <!-- App css -->
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="css/icons.css" rel="stylesheet" type="text/css" />
        <link href="css/metismenu.min.css" rel="stylesheet" type="text/css" />
        <link href="css/style.css" rel="stylesheet" type="text/css" />

        <script src="js/modernizr.min.js"></script>
		
		<script type="text/javascript">
     

	function getCity()
	{
	/* alert("In function"); */
		var stateId=document.getElementById("stateId");
		/* alert(st); */
		removeCity();
				var htp=new XMLHttpRequest();
		
		htp.onreadystatechange=function()
			{
			/* alert("In State" + i++); */
				if(htp.readyState==4)
					{
					/* alert("In if"); */
						var jsn=JSON.parse(htp.responseText);				
						/* alert("In json start"); */
						for(var i=0;i<jsn.length;i++)
							{
								var opt=document.createElement("option");
								opt.value=jsn[i].cityId;
								opt.text=jsn[i].cityName;
								document.test.cityId.options.add(opt);
							}
					}
			}
		htp.open("get","<%=request.getContextPath()%>/CityController?flag=selectCity&stateId="+stateId.value,true);
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
</script>
		
    </head>


    <body>

        <!-- Begin page -->
        <div id="wrapper">

            <!-- Top Bar Start -->
            <jsp:include page="header.jsp"></jsp:include>
            <!-- Top Bar End -->


            <!-- ========== Left Sidebar Start ========== -->
            <jsp:include page="menu.jsp"></jsp:include>
            <!-- Left Sidebar End -->



            <!-- ============================================================== -->
            <!-- Start right Content here -->
            <!-- ============================================================== -->
            <div class="content-page">
                <!-- Start content -->
                <div class="content">
                    <div class="container-fluid">

                        <div class="row">
                            <div class="col-12">
                                <div class="page-title-box">
                                    <h4 class="page-title float-left">Edit Area</h4>

                                    <ol class="breadcrumb float-right">
                                        <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
                                        <li class="breadcrumb-item active">Manage Area</li>
                                        <li class="breadcrumb-item active">Edit Area</li>
                                    </ol>

                                    <div class="clearfix"></div>
                                </div>
                            </div>
                        </div>
                        <!-- end row -->


                        <div class="row">
                            <div class="col-lg-12">

                                <div class="card-box">
                                    <h4 class="header-title m-t-0">Edit Area</h4>
                                   

                                    <c:forEach items="${sessionScope.areaList}" var="r">
                                    
                                    <form name = "test"method="post" action="<%=request.getContextPath()%>/AreaController">
                                        <div class="form-group">
                                            <label for="userName">State<span class="text-danger">*</span></label>
                                            <select name="stateName" parsley-trigger="change" required
                                                   placeholder="Enter State" class="form-control" id="stateId" onchange="getCity()">
                                                   
                                            <c:forEach items="${sessionScope.stateList}" var="i">

												<c:if test="${i.stateId eq r.stateVO.stateId }" >
                                                   <option value="${i.stateId}" selected="selected">${i.stateName}</option>
												</c:if>

												<c:if test="${i.stateId ne r.stateVO.stateId }">
                                                   <option value="${i.stateId}">${i.stateName}</option>
												</c:if>
                                                   
                                                        
                                            </c:forEach>
                                                   
                                        </select>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label for="emailAddress">City<span class="text-danger">*</span></label>
                                            <select name="cityName" parsley-trigger="change" required
                                                   placeholder="Enter City" class="form-control" id="cityId">
															
													 <option value="0">Select City</option> 		
															                                                   
                                             <c:forEach items="${sessionScope.cityList}" var="p">
                                                <c:if test="${p.cityId eq r.cityVO.cityId}">   
                                                   <option value="${p.cityId}" selected="selected">${p.cityName}</option>
                                                   </c:if>
                                                   <c:if test="${p.cityId ne r.cityVO.cityId}">   
                                                   <option value="${p.cityId}">${p.cityName}</option>
                                                   </c:if>       
                                                   
                                            </c:forEach>       
                                                   
                                        </select>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label for="pass1">Area<span class="text-danger">*</span></label>
                                            <input id="pass1" type="text" name="areaName" value="${r.areaName}" placeholder="Enter Area Name" required
                                                   class="form-control">
                                        </div>
										
										<input type="hidden" name="areaId" value="${r.areaId}">
										<input type="hidden" name="flag" value="updateArea">

										
                                        <div class="form-group text-right m-b-0">
                                            <button class="btn btn-gradient waves-effect waves-light" type="submit">
                                                Submit
                                            </button>
                                            <button type="reset" class="btn btn-light waves-effect m-l-5">
                                                Cancel
                                            </button>
                                        </div>

                                    </form>
                                    
									</c:forEach>
                                </div> <!-- end card-box -->
                            </div>
                            <!-- end col -->

                            <div class="col-lg-6">
                                
                            </div> <!-- end col -->
                        </div>
                        <!-- end row -->

                        
                        <!-- end row -->

                    </div> <!-- container -->

                </div> <!-- content -->
                
                <!-- footer -->
                <%-- <jsp:include page="footer.jsp"></jsp:include> --%>
                <!-- footer -->


            </div>


            <!-- ============================================================== -->
            <!-- End Right content here -->
            <!-- ============================================================== -->


        </div>
        <!-- END wrapper -->



        <!-- jQuery  -->
        <script src="js/jquery.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/metisMenu.min.js"></script>
        <script src="js/waves.js"></script>
        <script src="js/jquery.slimscroll.js"></script>

        <!-- Parsley js -->
        <script type="text/javascript" src="js/parsley.min.js"></script>

        <!-- App js -->
        <script src="js/jquery.core.js"></script>
        <script src="js/jquery.app.js"></script>

        <script type="text/javascript">
            $(document).ready(function() {
                $('form').parsley();
            });
        </script>

    </body>
</html>