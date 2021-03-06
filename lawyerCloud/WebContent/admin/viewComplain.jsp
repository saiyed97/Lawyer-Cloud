<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    
    <!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>View Complains</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
        <meta content="A fully featured admin theme which can be used to build CRM, CMS, etc." name="description" />
        <meta content="Coderthemes" name="author" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />

        <!-- App favicon -->
        <link rel="shortcut icon" href="images/favicon.ico">

        <!-- DataTables -->
        <link href="css/dataTables.bootstrap4.min.css" rel="stylesheet" type="text/css" />
        <link href="css/buttons.bootstrap4.min.css" rel="stylesheet" type="text/css" />
        <!-- Responsive datatable examples -->
        <link href="css/responsive.bootstrap4.min.css" rel="stylesheet" type="text/css" />

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
                                    <h4 class="page-title float-left">View Complains</h4>

                                    <ol class="breadcrumb float-right">
                                        <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
                                        <li class="breadcrumb-item active">Manage Complains</li>
                                        <li class="breadcrumb-item active">View Complains</li>
                                    </ol>

                                    <div class="clearfix"></div>
                                </div>
                            </div>
                        </div>
                        <!-- end row -->


                        <div class="row">
                            <div class="col-12">
                                <div class="card-box table-responsive">
                                    <h4 class="m-t-0 header-title"><b>View Complains</b></h4>
                                    

                                    <table id="datatable" class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <!-- <th>ID</th> -->
                                            <th>Name</th>
                                            <!-- <th>Image</th> -->
                                            <th>Email Id</th>
                                            <!-- <th>Mobile Number</th> -->
                                            <th>Subject</th>
                                            <th>Description</th>
                                            <th>Date and Time</th>
                                            <!-- <th>Complain To</th> -->
                                            <th>Status</th>
                                            <th>Reply Description</th>
                                            <!-- <th>Login ID</th> -->
                                            <th>Role</th>
                                        
                                            <!-- <th>Complain Reply</th> -->                                            
                                            
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
											<td>${i.fromLoginVO.role}</td>
											<%-- <td>${i.loginVO.loginId}</td> --%>
																						
											<%-- <td><a href="<%=request.getContextPath()%>/ComplainController?flag=complainReply&complainId=${i.complainId}">Reply</a></td> --%>
											<c:set var="k" value="${i.replyDescription}"></c:set>
												<c:if test="${fn:length(k) eq 0}">
													<td><a href="<%=request.getContextPath()%>/ComplainController?flag=complainReply&complainId=${i.complainId}">Reply</a></td>
												</c:if>
										
										</tr>
										
										
										</c:forEach>
                                        
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div> <!-- end row -->


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

        <!-- Required datatable js -->
        <script src="js/jquery.dataTables.min.js"></script>
        <script src="js/dataTables.bootstrap4.min.js"></script>
        <!-- Buttons examples -->
        <script src="js/dataTables.buttons.min.js"></script>
        <script src="js/buttons.bootstrap4.min.js"></script>
        <script src="js/jszip.min.js"></script>
        <script src="js/pdfmake.min.js"></script>
        <script src="js/vfs_fonts.js"></script>
        <script src="js/buttons.html5.min.js"></script>
        <script src="js/buttons.print.min.js"></script>
        <!-- Responsive examples -->
        <script src="js/dataTables.responsive.min.js"></script>
        <script src="js/responsive.bootstrap4.min.js"></script>

        <!-- App js -->
        <script src="js/jquery.core.js"></script>
        <script src="js/jquery.app.js"></script>

        <script type="text/javascript">
            $(document).ready(function() {
                $('#datatable').DataTable();

                //Buttons examples
                var table = $('#datatable-buttons').DataTable({
                    lengthChange: false,
                    buttons: ['copy', 'excel', 'pdf']
                });

                table.buttons().container()
                        .appendTo('#datatable-buttons_wrapper .col-md-6:eq(0)');
            } );

        </script>

    </body>
</html>