<div class="wrapper_main lw_second_nav_wrapper" style="top:172px">
			<div class="container">
				<div class="col-lg-12 col-md-12 col-sm-12">
					<!-- navbar toggle start -->
					<div class="navbar-header pull-right">
						<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar"> <i class="fa fa-list-ul">
								</i> </button>
					</div>
					<!-- navbar toggle end-->
					<!--navbar collapse start-->
					<div class="row">
						<div class="lw_navigations">
							<div class="collapse navbar-collapse" id="myNavbar">
								<div class="col-lg-9 col-md-9 col-sm-12">
									<nav>
										<ul class="menu">
											<li> <a href="<%=request.getContextPath()%>/lawyer/index.jsp">
														Home
													</a>											
											</li>
											
											<li> <a href="<%=request.getContextPath()%>/RequestLawyerController?flag=searchRequest">
														Client Request
													</a> </li>
											
											<li> <a>
														Complains
												 </a>
												 
												 <ul class="sub-menu">
													
													<li> <a href="<%=request.getContextPath()%>/ComplainController?flag=complainToAdminByLawyer">
																Post
															</a> 
													</li>
													
													<li> <a href="<%=request.getContextPath()%>/ComplainController?flag=viewLawyerSentComplains">
																Sent Complains
														 </a>
													</li>
													
													<li> <a href="<%=request.getContextPath()%>/ComplainController?flag=searchComplainForLawyer">
																Received Complains
														 </a>
													</li>
													
												  </ul>
											 </li>
													
								
											
											<%-- <li> <a href="<%=request.getContextPath()%>/TestimonialController?flag=testimonialLawyer">
														Testimonial
													</a> </li> --%>
													
													
											<li> <a>
														Feedbacks
												 </a>
												 
												 <ul class="sub-menu">
													
													<li> <a href="<%=request.getContextPath()%>/FeedbackController?flag=feedbackToAdminByLawyer">
																Send
															</a> 
													</li>
													
													<li> <a href="<%=request.getContextPath()%>/FeedbackController?flag=viewLawyerSentFeedbacks">
																Sent Feedbacks
														 </a>
													</li>
													
													<li> <a href="<%=request.getContextPath()%>/FeedbackController?flag=searchFeedbackForLawyer">
																Received Feedbacks
														 </a>
													</li>
													
												  </ul>
											 </li>
											
																	
											
											<li> <a href="<%=request.getContextPath()%>/TestimonialController?flag=testimonialLawyer">
														Testimonial
													</a> </li>
													
											<li> <a href="<%=request.getContextPath()%>/LawyerRegisterController?flag=lawyerProfile">
														My Profile
													</a> </li>		
													
											
											<%-- <li> <a href="<%=request.getContextPath()%>/lawyer/contactUs.jsp">
														contact us
													</a> </li> --%>
		
											<%-- <li> <a href="<%=request.getContextPath()%>/user/newIndex.jsp">
														Logout
													</a> </li> --%>		
											
											
										</ul>
									</nav>
									<!--navbar collapse end-->
								</div>
								<!-- navbar-form start -->
								<!-- <div class="col-lg-3 col-md-3 col-sm-12">
									<form class="navbar-form">
										<div class="input-group input_grp">
											<div class="input-group-btn">
												<button class="btn nav_search" type="submit"> <i class="glyphicon glyphicon-search">
														</i> </button>
											</div>
											<input type="text" class="form_control" name="srch-term" id="srch-term"> </div>
									</form>
								</div> -->
								<!-- navbar-form start -->
							</div>
						</div>
					</div>
				</div>
				<!--row main-->
			</div>
			<!--container-->
		</div>