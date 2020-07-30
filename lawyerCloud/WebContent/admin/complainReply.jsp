<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

    <!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Complain Reply</title>
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
                                    <h4 class="page-title float-left">Complain Reply</h4>

                                    <ol class="breadcrumb float-right">
                                        <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
                                        <li class="breadcrumb-item active">Manage Complain</li>
                                        <li class="breadcrumb-item active">View Complain</li>
                                    </ol>

                                    <div class="clearfix"></div>
                                </div>
                            </div>
                        </div>
                        <!-- end row -->


                        <div class="row">
                            <div class="col-lg-12">

                                <div class="card-box">
                                    <h4 class="header-title m-t-0">Complain Reply</h4>
                                   

                                    <form method="post" action="<%=request.getContextPath()%>/ComplainController">
                                       
                                       <c:forEach items="${sessionScope.complainList}" var="i">
                                        
                                        <div class="form-group">
                                            <label for="pass1">Complain Subject<span class="text-danger">*</span></label>
                                            <input id="pass1" type="text"  name="complainSubject" value="${i.complainSubject}" placeholder="Enter State Name" required
                                                   class="form-control">
                                        </div>
                                        
                                        <div class="form-group">
                                            <label for="pass1">Complain Description<span class="text-danger">*</span></label>
                                            <input id="pass1" type="text"  name="complainDescription" value="${i.complainDescription}" placeholder="Enter State Name" required
                                                   class="form-control">
                                        </div>                                           
                                         
                                         
                                         <input type="hidden" name="complainId" value="${i.complainId}">
                                        
                                        <input type="hidden" name="complainDateAndTime" value="${i.complainDateAndTime}">
                                        
                                        <input type="hidden" name="complainStatus" value="${i.complainStatus}">
                                        
                                        <input type="hidden" name="name" value="${i.name}">
                                        
                                        <input type="hidden" name="replyDescription" value="${i.replyDescription}">
                                        
                                        <input type="hidden" name="fromLoginId" value="${i.fromLoginVO.loginId}">
                                        
                                        <input type="hidden" name="toLoginId" value="${i.toLoginVO.loginId}">
                                         
                                        <input type="hidden" name="toName" value="${i.toName}"> 
                                        
										</c:forEach>
										
										<div class="form-group">
                                            <label for="pass1">Complain Reply<span class="text-danger">*</span></label>
                                            <input id="pass1" type="text" name="complainReply" placeholder="Enter Complain Reply" required
                                                   class="form-control">
                                        </div>                                       
                                        
										
										<input type="hidden" name="flag" value="complainReply">

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