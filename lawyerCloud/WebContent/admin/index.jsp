<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt"%>
    <!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Home Admin</title>
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
                                    <h4 class="page-title float-left">Dashboard</h4>

                                    <ol class="breadcrumb float-right">
                                        <li class="breadcrumb-item"><a href="index.jsp">Lawyer Cloud</a></li>
                                        <li class="breadcrumb-item active">Dashboard</li>
                                    </ol>

                                    <div class="clearfix"></div>
                                </div>
                            </div>
                        </div>
                        <!-- end row -->


                        <div class="row">
                            <div class="col-xs-12 col-md-6 col-lg-6 col-xl-3">
                                <div class="card-box tilebox-one">
                                    <i class="fi-head float-right"></i>
                                    <h6 class="text-muted text-uppercase mb-3">Lawyers</h6>
                                    <h4 class="mb-3" data-plugin="counterup">${sessionScope.lyList }</h4>
                                    <!-- <span class="badge badge-primary"> +11% </span> <span class="text-muted ml-2 vertical-middle">From previous period</span> -->
                                </div>
                            </div>

                            <div class="col-xs-12 col-md-6 col-lg-6 col-xl-3">
                                <div class="card-box tilebox-one">
                                    <i class="fi-head float-right"></i>
                                    <h6 class="text-muted text-uppercase mb-3">Clients</h6>
                                    <h4 class="mb-3" data-plugin="counterup">${sessionScope.clList }</h4>
                                    <!-- <span class="badge badge-primary"> -29% </span> <span class="text-muted ml-2 vertical-middle">From previous period</span> -->
                                </div>
                            </div>

                            <div class="col-xs-12 col-md-6 col-lg-6 col-xl-3">
                                <div class="card-box tilebox-one">
                                    <i class="fi-inbox float-right"></i>
                                    <h6 class="text-muted text-uppercase mb-3">Requests</h6>
                                    <h4 class="mb-3" data-plugin="counterup">${sessionScope.rqList }</h4>
                                    <!-- <span class="badge badge-primary"> 0% </span> <span class="text-muted ml-2 vertical-middle">From previous period</span> -->
                                </div>
                            </div>

                            <div class="col-xs-12 col-md-6 col-lg-6 col-xl-3">
                                <div class="card-box tilebox-one">
                                    <i class="fi-location float-right"></i>
                                    <h6 class="text-muted text-uppercase mb-3">Complains</h6>
                                    <h4 class="mb-3" data-plugin="counterup">${sessionScope.cmpList }</h4>
                                    <!-- <span class="badge badge-primary"> +89% </span> <span class="text-muted ml-2 vertical-middle">Last year</span> -->
                                </div>
                            </div>
                        </div>





<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>

 <c:forEach items="${sessionScope.catList }" var="i">
	
	<input type="hidden" name="xvalue" value="${i.categoryName }" />
	
</c:forEach> 
	
<!-- <input type="hidden" name="xvalue" value="hhhh" />
<input type="hidden" name="xvalue" value="O-" />
<input type="hidden" name="xvalue" value="B+" />
<input type="hidden" name="xvalue" value="AB+" />
<input type="hidden" name="xvalue" value="A-" />
<input type="hidden" name="xvalue" value="O-" />
<input type="hidden" name="xvalue" value="B-" />
<input type="hidden" name="xvalue" value="AB-" /> -->


<%--  <c:forEach items="${sessionScope.catList}" var="i">
	
	<input type="hidden" name="yvalue" value="45" />
	
</c:forEach> 
 --%>

<input type="hidden" name="yvalue" value="<%= session.getAttribute("categoryListOne") %>" />
<input type="hidden" name="yvalue" value="<%= session.getAttribute("categoryListTwo") %>" />
<input type="hidden" name="yvalue" value="<%= session.getAttribute("categoryListThree") %>" />
<input type="hidden" name="yvalue" value="<%= session.getAttribute("categoryListFour") %>" />
<input type="hidden" name="yvalue" value="<%= session.getAttribute("categoryListFive") %>" />
<input type="hidden" name="yvalue" value="<%= session.getAttribute("categoryListSix") %>" />
<input type="hidden" name="yvalue" value="<%= session.getAttribute("categoryListSeven") %>" />
<input type="hidden" name="yvalue" value="<%= session.getAttribute("categoryListEight") %>" />
<input type="hidden" name="yvalue" value="<%= session.getAttribute("categoryListNine") %>" />
<input type="hidden" name="yvalue" value="<%= session.getAttribute("categoryListTen") %>" />
<!-- <input type="hidden" name="yvalue" value="56" />
<input type="hidden" name="yvalue" value="64" />
<input type="hidden" name="yvalue" value="34" />
<input type="hidden" name="yvalue" value="89" />
 --> 


                        

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
        <script src="js/jquery.waypoints.min.js"></script>
        <script src="js/jquery.counterup.min.js"></script>

        <!-- Chart JS -->
        <script src="js/chart.bundle.js"></script>

        <!-- init dashboard -->
        <script src="js/jquery.dashboard.init.js"></script>

        <!-- App js -->
        <script src="js/jquery.core.js"></script>
        <script src="js/jquery.app.js"></script>

		<script src="js/highcharts.js"></script>
		<style>
		.highcharts-credits
		{
		display:none;
		}
		</style>
		<script>
var xvalue= document.getElementsByName("xvalue");
var xdata = [];
var yvalue= document.getElementsByName("yvalue");
var ydata = [];
for(var i=0;i<xvalue.length;i++)
{
	xdata.push(xvalue[i].value);
	ydata.push(parseFloat(yvalue[i].value));
}
Highcharts.chart({
    chart: {
	renderTo:"container",

        type: 'column'
    },
    title: {
        text: 'Total Requests Per Services'
    },
    subtitle: {
        text: ''
    },
    xAxis: {
        categories: xdata,
        crosshair: true
    },
    yAxis: {
        min: 0,
        title: {
            text: 'Number of Requests'
        }
    },
    plotOptions: {
        column: {
            pointPadding: 0.2,
            borderWidth: 0
        }
    },
    series: [{
        name: 'Services',
        data: ydata

    }]
});
</script>
		
    </body>
</html>