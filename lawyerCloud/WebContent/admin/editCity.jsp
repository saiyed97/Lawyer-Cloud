<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

    <!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Edit City</title>
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
                                    <h4 class="page-title float-left">Edit City</h4>

                                    <ol class="breadcrumb float-right">
                                        <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
                                        <li class="breadcrumb-item active">Manage City</li>
                                        <li class="breadcrumb-item active">Edit City</li>
                                    </ol>

                                    <div class="clearfix"></div>
                                </div>
                            </div>
                        </div>
                        <!-- end row -->


                        <div class="row">
                            <div class="col-lg-12">

                                <div class="card-box">
                                    <h4 class="header-title m-t-0">Edit City</h4>
                                   
                                   <c:forEach var="r" items="${sessionScope.editCityList}">
                                   
                                    <form action="<%=request.getContextPath()%>/CityController" method="post">
                                    
                                    <div class="form-group">
                                            <label for="userName">State<span class="text-danger">*</span></label>
                                            <select name="stateName" parsley-trigger="change" required
                                                   placeholder="Enter State" class="form-control" id="userName">
                                                   
                                                   <c:forEach items="${sessionScope.editStateList}" var="i">
                                                   
                                                   <c:if test="${i.stateId eq r.stateVO.stateId }">
                                                       <option value="${i.stateId}" selected="selected">${i.stateName}</option>
                                                   </c:if>
                                                   
                                                   <c:if test="${i.stateId ne r.stateVO.stateId }">
                                                       <option value="${i.stateId}">${i.stateName}</option>
                                                   </c:if>
                                             
                                                   </c:forEach>
                                                   
                                        </select>
                                        </div>
                                    
                                     
                                        
                                        <div class="form-group">
                                            <label for="pass1">City<span class="text-danger">*</span></label>
                                            <input id="pass1" type="text" name="cityName" value="${r.cityName }" placeholder="Enter City Name" required
                                                   class="form-control">
                                        </div>

										<input type="hidden" name="cityId" value="${r.cityId}"> 
										<input type="hidden" name="flag" value="updateCity">
										
										</c:forEach>
											

                                        <div class="form-group text-right m-b-0">
                                            <button class="btn btn-gradient waves-effect waves-light" type="submit">
                                                Submit
                                            </button>
                                            <button type="reset" class="btn btn-light waves-effect m-l-5">
                                                Cancel
                                            </button>
                                        </div>
										
                                    </form>
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