<div class="left side-menu">
                <div class="slimscroll-menu" id="remove-scroll">

                    <!--- Sidemenu -->
                    <div id="sidebar-menu">
                        <!-- Left Menu Start -->
                        <ul class="metismenu" id="side-menu">
                            <li class="menu-title">Navigation</li>
                            <li>
                                <a href="index.jsp">
                                    <i class="fi-air-play"></i><span class="badge badge-danger badge-pill pull-right"></span> <span> Home </span>
                                </a>
                            </li>

                            
                            <li>
                                <a href="javascript: void(0);"><i class="fi-globe"></i> <span> Manage Area </span> <span class="menu-arrow"></span></a>
                                <ul class="nav-second-level" aria-expanded="false">
                                    <li><a href="<%=request.getContextPath()%>/AreaController?flag=loadStateAndCity">Add Area</a></li>
                                    <li><a href="<%=request.getContextPath()%>/AreaController?flag=searchArea">View Area</a></li>  
                                </ul>
                            </li>
                            
                            <li>
                                <a href="javascript: void(0);"><i class="fi-globe"></i> <span> Manage City </span> <span class="menu-arrow"></span></a>
                                <ul class="nav-second-level" aria-expanded="false">
                                    <li><a href="<%=request.getContextPath()%>/StateController?flag=loadState">Add City</a></li>
                                    <li><a href="<%=request.getContextPath()%>/CityController?flag=searchCity">View City</a></li>  
                                </ul>
                            </li>
                            
                            <li>
                                <a href="javascript: void(0);"><i class="fi-globe"></i> <span> Manage State </span> <span class="menu-arrow"></span></a>
                                <ul class="nav-second-level" aria-expanded="false">
                                    <li><a href="addState.jsp">Add State</a></li>
                                    <li><a href="<%=request.getContextPath()%>/StateController?flag=searchState">View State</a></li>  
                                </ul>
                            </li>
                            
                            <li>
                                <a href="javascript: void(0);"><i class="fi-layers"></i> <span> Manage Category </span> <span class="menu-arrow"></span></a>
                                <ul class="nav-second-level" aria-expanded="false">
                                    <li><a href="addCategory.jsp">Add Category</a></li>
                                    <li><a href="<%=request.getContextPath()%>/CategoryController?flag=searchCategory">View Category</a></li>  
                                </ul>
                            </li>
                            
                            <li>
                                <a href="javascript: void(0);"><i class="fi-layers"></i> <span> Manage SubCategory </span> <span class="menu-arrow"></span></a>
                                <ul class="nav-second-level" aria-expanded="false">
                                    <li><a href="<%=request.getContextPath()%>/CategoryController?flag=loadCategory">Add Sub Category</a></li>
                                    <li><a href="<%=request.getContextPath()%>/SubCategoryController?flag=searchSubCategory">View Sub Category</a></li>  
                                </ul>
                            </li>
                            
                            <li>
                                <a href="javascript: void(0);"><i class="fi-head"></i> <span> Manage Lawyer </span> <span class="menu-arrow"></span></a>
                                <ul class="nav-second-level" aria-expanded="false">
                                    <li><a href="<%=request.getContextPath()%>/LawyerRegisterController?flag=searchLawyer">View Lawyer</a></li>  
                                </ul>
                            </li>
                            
                            <li>
                                <a href="javascript: void(0);"><i class="fi-head"></i> <span> Manage Client </span> <span class="menu-arrow"></span></a>
                                <ul class="nav-second-level" aria-expanded="false">
                                    <li><a href="<%=request.getContextPath()%>/ClientRegisterController?flag=searchClient">View Client</a></li>  
                                </ul>
                            </li>
                            
                            <li>
                                <a href="javascript: void(0);"><i class="fi-location"></i> <span> Manage Complain </span> <span class="menu-arrow"></span></a>
                                <ul class="nav-second-level" aria-expanded="false">
                                    <li><a href="<%=request.getContextPath()%>/ComplainController?flag=searchComplainForAdmin">View Complain</a></li>  
                                </ul>
                            </li>
                            
                            <li>
                                <a href="javascript: void(0);"><i class="fi-file"></i> <span> Manage Testimonial </span> <span class="menu-arrow"></span></a>
                                <ul class="nav-second-level" aria-expanded="false">
                                    <li><a href="<%=request.getContextPath()%>/TestimonialController?flag=searchTestimonial">View Testimonial</a></li>  
                                </ul>
                            </li>
                            
                            <li>
                                <a href="javascript: void(0);"><i class="fi-location"></i> <span> Manage Feedback </span> <span class="menu-arrow"></span></a>
                                <ul class="nav-second-level" aria-expanded="false">
                                    <li><a href="<%=request.getContextPath()%>/FeedbackController?flag=searchFeedbackForAdmin">View Feedback</a></li>  
                                </ul>
                            </li>
                            
                            <li>
                                <a href="javascript: void(0);"><i class=fi-open></i> <span> Manage ContactUs </span> <span class="menu-arrow"></span></a>
                                <ul class="nav-second-level" aria-expanded="false">
                                    <li><a href="<%=request.getContextPath()%>/ContactUsController?flag=searchContactUsDetails">View ContactUs</a></li>  
                                </ul>
                            </li>

                            <!-- <li>
                                <a href="javascript: void(0);"><i class="fi-mail"></i><span> Email </span> <span class="menu-arrow"></span></a>
                                <ul class="nav-second-level" aria-expanded="false">
                                    <li><a href="email-inbox.html">Inbox</a></li>
                                    <li><a href="email-read.html">Read Email</a></li>
                                    <li><a href="email-compose.html">Compose Email</a></li>
                                </ul>
                            </li>  

                            <li>
                                <a href="javascript: void(0);"><i class="fi-disc"></i><span class="badge badge-warning pull-right">09</span> <span> Forms </span></a>
                                <ul class="nav-second-level" aria-expanded="false">
                                    <li><a href="form-elements.html">Form Elements</a></li>
                                    <li><a href="form-advanced.html">Form Advanced</a></li>
                                    <li><a href="form-validation.html">Form Validation</a></li>
                                    <li><a href="form-pickers.html">Form Pickers</a></li>
                                    <li><a href="form-wizard.html">Form Wizard</a></li>
                                    <li><a href="form-mask.html">Form Masks</a></li>
                                    <li><a href="form-wysiwig.html">Wysiwig Editors</a></li>
                                    <li><a href="form-x-editable.html">X Editable</a></li>
                                    <li><a href="form-uploads.html">Multiple File Upload</a></li>
                                </ul>
                            </li>

                            <li>
                                <a href="javascript: void(0);"><i class="fi-layout"></i> <span> Tables </span> <span class="menu-arrow"></span></a>
                                <ul class="nav-second-level" aria-expanded="false">
                                    <li><a href="tables-basic.html">Basic Tables</a></li>
                                    <li><a href="tables-datatable.html">Data Tables</a></li>
                                    <li><a href="tables-responsive.html">Responsive Table</a></li>
                                    <li><a href="tables-tablesaw.html">Tablesaw Tables</a></li>
                                    <li><a href="tables-editable.html">Editable Tables</a></li>
                                </ul>
                            </li> 

                            <li class="menu-title">More</li>

                            <li>
                                <a href="javascript: void(0);"><i class="fi-map"></i> <span> Maps </span> <span class="menu-arrow"></span></a>
                                <ul class="nav-second-level" aria-expanded="false">
                                    <li><a href="maps-google.html">Google Maps</a></li>
                                    <li><a href="maps-vector.html">Vector Maps</a></li>
                                    <li><a href="maps-mapael.html">Mapael Maps</a></li>
                                </ul>
                            </li>

                            <li><a href="calendar.html"><i class="fi-clock"></i> <span>Calendar</span> </a></li>

                            <li>
                                <a href="javascript: void(0);"><i class="fi-paper-stack"></i><span> Pages </span> <span class="menu-arrow"></span></a>
                                <ul class="nav-second-level" aria-expanded="false">
                                    <li><a href="page-starter.html">Starter Page</a></li>
                                    <li><a href="page-login.html">Login</a></li>
                                    <li><a href="page-register.html">Register</a></li>
                                    <li><a href="page-logout.html">Logout</a></li>
                                    <li><a href="page-recoverpw.html">Recover Password</a></li>
                                    <li><a href="page-lock-screen.html">Lock Screen</a></li>
                                    <li><a href="page-confirm-mail.html">Confirm Mail</a></li>
                                    <li><a href="page-404.html">Error 404</a></li>
                                    <li><a href="page-404-alt.html">Error 404-alt</a></li>
                                    <li><a href="page-500.html">Error 500</a></li>
                                </ul>
                            </li>

                            <li>
                                <a href="javascript:void(0);"><i class="fi-marquee-plus"></i><span class="badge badge-success pull-right">Hot</span> <span> Extra Pages </span></a>
                                <ul class="nav-second-level" aria-expanded="false">
                                    <li><a href="extras-timeline.html">Timeline</a></li>
                                    <li><a href="extras-invoice.html">Invoice</a></li>
                                    <li><a href="extras-faq.html">FAQ</a></li>
                                    <li><a href="extras-pricing.html">Pricing</a></li>
                                    <li><a href="extras-email-template.html">Email Templates</a></li>
                                </ul>
                            </li>

                            <li>
                                <a href="javascript: void(0);"><i class="fi-share"></i> <span> Multi Level </span> <span class="menu-arrow"></span></a>
                                <ul class="nav-second-level nav" aria-expanded="false">
                                    <li><a href="javascript: void(0);">Level 1.1</a></li>
                                    <li><a href="javascript: void(0);" aria-expanded="false">Level 1.2 <span class="menu-arrow"></span></a>
                                        <ul class="nav-third-level nav" aria-expanded="false">
                                            <li><a href="javascript: void(0);">Level 2.1</a></li>
                                            <li><a href="javascript: void(0);">Level 2.2</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </li> -->

                        </ul>

                    </div>
                    <!-- Sidebar -->
                    <div class="clearfix"></div>

                </div>
                <!-- Sidebar -left -->

            </div>
