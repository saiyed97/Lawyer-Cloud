package Filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import DAO.LoginDAO;
import VO.CategoryVO;
import VO.ClientRegisterVO;
import VO.ComplainVO;
import VO.LawyerRegisterVO;
import VO.LoginVO;
import VO.RequestLawyerVO;

@WebFilter("/*")
public class LoginFilter implements Filter 
{

   
    public LoginFilter() 
    {
    	
    }
    
    
	public void destroy() 
	{
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		HttpSession session =((HttpServletRequest) request).getSession();
	
		RequestDispatcher requestDispatcher;
		
		String flag = request.getParameter("flag");
		
		String uri = ((HttpServletRequest)request).getRequestURI();
		System.out.println("Before>>>>>>"+uri);
		
		if(uri.contains("/css") || uri.contains("/CityController")|| uri.contains("jsonSubCategory.jsp") || uri.contains("/AreaController") || uri.contains("/js") && !uri.contains(".jsp") || uri.contains("/img")|| uri.contains("/fonts")|| uri.contains("/images") || uri.contains("/doc")  || uri.contains("user/newIndex.jsp") || uri.contains("user/aboutUs.jsp")|| uri.contains("admin/step1.jsp")|| uri.contains("admin/step2.jsp") || uri.contains("ContactUsController") || uri.contains("user/contactUs.jsp") || uri.contains("user/services.jsp")|| uri.contains("client/services.jsp")|| uri.contains("client/changeImage.jsp")|| uri.contains("lawyer/changeImage.jsp")|| uri.contains("lawyer/services.jsp")||uri.contains("client/changePassword.jsp")||uri.contains("lawyer/changePassword.jsp")||uri.contains("client/clientProfile.jsp")||uri.contains("lawyer/editProfile.jsp")||uri.contains("lawyer/lawyerProfile.jsp") ||uri.contains("client/editProfile.jsp")|| uri.contains("user/lawyers.jsp") || uri.contains("user/clientRegister.jsp") || uri.contains("user/lawyerRegister.jsp")|| uri.contains("lawyer/css")|| uri.contains("client/css")||uri.contains("client/index.jsp")||uri.contains("jsoncity.jsp")||uri.contains("jsonArea.jsp")||uri.contains("ComplainController")||uri.contains("client/complain.jsp")||uri.contains("lawyer/viewSentComplain.jsp")||uri.contains("lawyer/complainReply.jsp")||uri.contains("lawyer/receivedComplain.jsp")||uri.contains("client/viewSentComplain.jsp")||uri.contains("TestimonialController")||uri.contains("client/testimonial.jsp")||uri.contains("lawyer/testimonial.jsp")||uri.contains("lawyer/viewComplain.jsp")||uri.contains("lawyer/complainReply.jsp")||uri.contains("FeedbackController")||uri.contains("client/feedback.jsp")||uri.contains("client/viewSentFeedback.jsp")||uri.contains("lawyer/viewSentFeedback.jsp")||uri.contains("lawyer/receivedFeedback.jsp")||uri.contains("BrowseLawyerController")||uri.contains("client/browseLawyer.jsp")||uri.contains("RequestLawyerController")||uri.contains("client/requestDescription.jsp") ||uri.contains("lawyer/acceptRequest.jsp")||uri.contains("lawyer/rejectRequest.jsp")||uri.contains("client/aboutUs.jsp")||uri.contains("client/contactUs.jsp")||uri.contains("lawyer/aboutUs.jsp")||uri.contains("lawyer/contactUs.jsp")||uri.contains("ComplainController")||uri.contains("lawyer/complain.jsp")||uri.contains("FeedbackController")||uri.contains("lawyer/feedback.jsp")||uri.contains("lawyer/clientRequest.jsp")||uri.contains("client/myRequest.jsp")||uri.contains("lawyer/index.jsp")||uri.contains("ClientRegisterController")||uri.contains("LawyerRegisterController"))
		{ 
			System.out.println("After>>>>>>"+uri);
			chain.doFilter(request,response);
			
		}
		
		else if (flag!= null && flag.equals("logout")) 
		{
		
			session.invalidate();
		
			requestDispatcher = request.getRequestDispatcher("/admin/login.jsp");
			
			requestDispatcher.forward(request, response);
			
		}
		
		else if(flag != null && flag.equals("login") )
		{
			String emailId = request.getParameter("emailId");
			
			String password = request.getParameter("password");
		
			System.out.println(emailId+""+password);
			
			LoginVO LoginVO = new LoginVO();
			
			LoginVO.setEmail(emailId);
			
			LoginVO.setPassword(password);
			
			LoginDAO loginDAO = new LoginDAO();
			
			List list =  loginDAO.authentication(LoginVO);
			
			if(list != null && list.size()>=1)
			{
				LoginVO user=(LoginVO) list.get(0);
				
				long y = user.getLoginId();
			
				session.setAttribute("userID",y);
				
				System.out.println(user.getRole());
			
				String type = user.getRole();
			
				session.setAttribute("usertype",type);
				
				System.out.println(y);
				
				if(type.equalsIgnoreCase("Admin"))
				{
					List ls =  loginDAO.search(LoginVO);
					session.setAttribute("lyList",ls.size());
					
					List ls1 =  loginDAO.search1(LoginVO);
					session.setAttribute("clList",ls1.size());
					
					RequestLawyerVO requestLawyerVO = new RequestLawyerVO();
					
					List ls2 =  loginDAO.search2(requestLawyerVO);
					session.setAttribute("rqList",ls2.size());
					
					ComplainVO complainVO = new ComplainVO();
					
					List ls3 =  loginDAO.search3(complainVO);
					session.setAttribute("cmpList",ls3.size());
					
					CategoryVO categoryVO = new CategoryVO();
					
					List ls4 =  loginDAO.search4(categoryVO);
					session.setAttribute("catList",ls4);
					
					List categoryListOne =  loginDAO.search5(requestLawyerVO);
					session.setAttribute("categoryListOne",categoryListOne.size());
					
					List categoryListTwo =  loginDAO.search6(requestLawyerVO);
					session.setAttribute("categoryListTwo",categoryListTwo.size());
					
					List categoryListThree =  loginDAO.search7(requestLawyerVO);
					session.setAttribute("categoryListThree",categoryListThree.size());
					
					List categoryListFour =  loginDAO.search8(requestLawyerVO);
					session.setAttribute("categoryListFour",categoryListFour.size());
					
					List categoryListFive =  loginDAO.search9(requestLawyerVO);
					session.setAttribute("categoryListFive",categoryListFive.size());
					
					List categoryListSix =  loginDAO.search10(requestLawyerVO);
					session.setAttribute("categoryListSix",categoryListSix.size());
					
					List categoryListSeven =  loginDAO.search11(requestLawyerVO);
					session.setAttribute("categoryListSeven",categoryListSeven.size());
					
					List categoryListEight =  loginDAO.search12(requestLawyerVO);
					session.setAttribute("categoryListEight",categoryListEight.size());
					
					List categoryListNine =  loginDAO.search13(requestLawyerVO);
					session.setAttribute("categoryListNine",categoryListNine.size());
					
					List categoryListTen =  loginDAO.search14(requestLawyerVO);
					session.setAttribute("categoryListTen",categoryListTen.size());
					
					
					requestDispatcher = request.getRequestDispatcher("/admin/index.jsp");  
					requestDispatcher.forward(request,response);
				}

				else if(type.equalsIgnoreCase("Lawyer"))
				{

					int y1 = (int)y;
					
					LawyerRegisterVO lawyerRegisterVO = new LawyerRegisterVO();
					LoginVO loginVO = new LoginVO();
					loginVO.setLoginId(y1);
					lawyerRegisterVO.setLoginVO(loginVO);
					
					List lawyerRegisterList1 =  loginDAO.searchLawyerRegisterList(lawyerRegisterVO);
					
					LawyerRegisterVO lawyerRegisterList = (LawyerRegisterVO) lawyerRegisterList1.get(0);
					
					long z = lawyerRegisterList.getRegisterId();
					session.setAttribute("lawyerRegisterId", z);
					
					
					requestDispatcher = request.getRequestDispatcher("/lawyer/index.jsp");  
					requestDispatcher.forward(request,response);
				}
				else if(type.equalsIgnoreCase("Client"))
				{
					
					int y1 = (int)y;
					
					ClientRegisterVO clientRegisterVO = new ClientRegisterVO();
					LoginVO loginVO = new LoginVO();
					loginVO.setLoginId(y1);
					clientRegisterVO.setLoginVO(loginVO);
					
					List clientRegisterList1 =  loginDAO.searchClientRegisterList(clientRegisterVO);
					
					ClientRegisterVO clientRegisterList = (ClientRegisterVO)clientRegisterList1.get(0);
					
					long z = clientRegisterList.getRegisterId();
					session.setAttribute("clientRegisterId", z);
					
					
					requestDispatcher = request.getRequestDispatcher("/client/index.jsp");  
					requestDispatcher.forward(request,response);
				}
				else
				{
					requestDispatcher = request.getRequestDispatcher("/admin/login.jsp");  
					requestDispatcher.forward(request,response);  
				}
			}
			else
			{
				requestDispatcher = request.getRequestDispatcher("/admin/login.jsp");
				requestDispatcher.forward(request,response);  		
			}	
		}
		else if(session.getAttribute("userID") != null)
		{
			String h = (String)session.getAttribute("usertype");
		
			if(h!=null && h.equals("admin"))
			{
			
				chain.doFilter(request,response);
			}
			
			else if(h!=null && h.equals("user"))
			{
				chain.doFilter(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("/admin/login.jsp");  
				rd.forward(request,response);
			}
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("/admin/login.jsp");  
			rd.forward(request,response);  
			
		}
	}

		public void init(FilterConfig fConfig) throws ServletException 
		{
			
		}

}