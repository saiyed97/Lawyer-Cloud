package Controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ComplainDAO;
import DAO.FeedbackDAO;
import DAO.TestimonialDAO;
import VO.ClientRegisterVO;
import VO.ComplainVO;
import VO.FeedbackVO;
import VO.LawyerRegisterVO;
import VO.LoginVO;

/**
 * Servlet implementation class FeedbackController
 */
@WebServlet("/FeedbackController")
public class FeedbackController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedbackController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String flag = request.getParameter("flag");
		
		if(flag.equals("searchFeedbackForAdmin"))
		{
			searchFeedbackForAdmin(request,response);
			response.sendRedirect("admin/viewFeedback.jsp");
		}
		
		if(flag.equals("feedbackToAdminByLawyer"))
		{
			response.sendRedirect("lawyer/feedback.jsp");
		}
		
		if(flag.equals("viewClientSentFeedbacks"))
		{
			viewClientSentFeedbacks(request,response);
			response.sendRedirect("client/viewSentFeedback.jsp");
		}
		
		if(flag.equals("viewLawyerSentFeedbacks"))
		{
			viewLawyerSentFeedbacks(request,response);
			response.sendRedirect("lawyer/viewSentFeedback.jsp");
		}
		
		if(flag.equals("searchFeedbackForLawyer"))
		{
			searchFeedbackForLawyer(request,response);
			response.sendRedirect("lawyer/receivedFeedback.jsp");
		}
	}

	private void searchFeedbackForLawyer(HttpServletRequest request,
			HttpServletResponse response) 
	{
		HttpSession session = request.getSession();
		long loginId1 = (Long)session.getAttribute("userID");
		int loginId = (int)loginId1;
		
		LoginVO   loginVO = new  LoginVO();
		loginVO.setLoginId(loginId);
		
		/*ComplainVO complainVO = new ComplainVO();
		complainVO.setToLoginVO(loginVO);*/
		
		FeedbackDAO feedbackDAO = new FeedbackDAO();
		List complainList = feedbackDAO.searchFeedbackForLawyer(loginVO);
		
		
		session.setAttribute("complainList", complainList);
		
	}

	private void viewLawyerSentFeedbacks(HttpServletRequest request,
			HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		long loginId1 = (Long)session.getAttribute("userID");
		int loginId = (int)loginId1;
		
		LoginVO   loginVO = new  LoginVO();
		loginVO.setLoginId(loginId);
				
		FeedbackVO feedbackVO = new FeedbackVO();
		feedbackVO.setFromLoginVO(loginVO);
		
		FeedbackDAO feedbackDAO = new FeedbackDAO();
		List feedbackList = feedbackDAO.searchLawyerSentComplains(feedbackVO);
		
		session.setAttribute("feedbackList", feedbackList);
		
	}

	private void viewClientSentFeedbacks(HttpServletRequest request,
			HttpServletResponse response) 
	{
		HttpSession session = request.getSession();
		long loginId1 = (Long)session.getAttribute("userID");
		int loginId = (int)loginId1;
		
		LoginVO   loginVO = new  LoginVO();
		loginVO.setLoginId(loginId);
				
		FeedbackVO feedbackVO = new FeedbackVO();
		feedbackVO.setFromLoginVO(loginVO);
		
		FeedbackDAO feedbackDAO = new FeedbackDAO();
		List feedbackList = feedbackDAO.searchClientSentComplains(feedbackVO);
		
		session.setAttribute("feedbackList", feedbackList);
		
	}

	private void searchFeedbackForAdmin(HttpServletRequest request,
			HttpServletResponse response) 
	{
		FeedbackDAO feedbackDAO = new FeedbackDAO();
		List feedbackList = feedbackDAO.searchFeedbackForAdmin();
		
		HttpSession session = request.getSession();
		session.setAttribute("feedbackList", feedbackList);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String flag = request.getParameter("flag");
		
		if(flag.equals("feedback"))
		{
			insertFeedback(request,response);
			response.sendRedirect("client/index.jsp");
		}
		
		if(flag.equals("feedbackToAdminByLawyer"))
		{
			insertFeedback(request,response);
			response.sendRedirect("lawyer/index.jsp");
		}
	}

	private void insertFeedback(HttpServletRequest request,
			HttpServletResponse response) 
	{
		int feedbackToRegisterId = Integer.parseInt(request.getParameter("feedbackToRegisterId"));
		
		String feedbackSubject = request.getParameter("feedbackSubject");
		String feedbackDescription = request.getParameter("feedbackDescription");
		
		FeedbackVO feedbackVO = new FeedbackVO();
		
		feedbackVO.setFeedbackSubject(feedbackSubject);
		feedbackVO.setFeedbackDescription(feedbackDescription);
		
		Date d = new Date();
		String date = d.toString();
		
		feedbackVO.setFeedbackDateAndTime(date);
		
		HttpSession session = request.getSession();
		long loginId1 = (Long)session.getAttribute("userID");
		int loginId = (int)loginId1;
		
		LoginVO loginVO = new LoginVO();
		loginVO.setLoginId(loginId);
		
		
		/*Data to get name*/
		
		TestimonialDAO testimonialDAO = new TestimonialDAO();
		List roleList = testimonialDAO.searchRole(loginVO);
		LoginVO roleListObj = (LoginVO)roleList.get(0);
		String role = roleListObj.getRole();
		
		String name = "";
		
		if(role.equals("Client"))
		{
			long clientRegisterId1 = (Long)session.getAttribute("clientRegisterId");
			int clientRegisterId = (int)clientRegisterId1;	
			
			ClientRegisterVO clientRegisterVO = new ClientRegisterVO();
			clientRegisterVO.setRegisterId(clientRegisterId);
			
			List clientList = testimonialDAO.searchClientDetails(clientRegisterVO);
			ClientRegisterVO clientListObj = (ClientRegisterVO)clientList.get(0);
			String firstName = clientListObj.getFirstName();
			String lastName = clientListObj.getLastName();
			name = firstName+" "+lastName;
		}
		
		if(role.equals("Lawyer"))
		{
			long lawyerRegisterId1 = (Long)session.getAttribute("lawyerRegisterId");
			int lawyerRegisterId = (int)lawyerRegisterId1;	
			
			LawyerRegisterVO lawyerRegisterVO = new LawyerRegisterVO();
			lawyerRegisterVO.setRegisterId(lawyerRegisterId);
			
			List lawyerList = testimonialDAO.searchLawyerDetails(lawyerRegisterVO);
			LawyerRegisterVO lawyerListObj = (LawyerRegisterVO)lawyerList.get(0);
			String firstName = lawyerListObj.getFirstName();
			String lastName = lawyerListObj.getLastName();
			name = firstName+" "+lastName;
		}	
		
		/*Data to get name*/
		
		
		feedbackVO.setName(name);	
		
		feedbackVO.setFromLoginVO(loginVO);;
				
		LawyerRegisterVO lawyerRegisterVO = new LawyerRegisterVO();
		
		LoginVO loginVO1 = new LoginVO();
		
		FeedbackDAO feedbackDAO = new FeedbackDAO();
		
		String toName;
		
		if(feedbackToRegisterId != 1)
		{
			lawyerRegisterVO.setRegisterId(feedbackToRegisterId);
		
			List ls = feedbackDAO.searchloginId(lawyerRegisterVO); 
			LawyerRegisterVO lv = (LawyerRegisterVO) ls.get(0);		
		
			int lwId = lv.getLoginVO().getLoginId();		
		
			System.out.println("loginID LWWWW>>>"+lwId);

			loginVO1.setLoginId(lwId);
			feedbackVO.setToLoginVO(loginVO1);
			
			List ls1 = feedbackDAO.searchName(lawyerRegisterVO);
			LawyerRegisterVO lrVO = (LawyerRegisterVO)ls1.get(0);
			String fn = lrVO.getFirstName();
			String ln = lrVO.getLastName();
			toName = fn+" "+ln;
			feedbackVO.setToName(toName);
		}
		
		else
		{
			loginVO1.setLoginId(feedbackToRegisterId);
			feedbackVO.setToLoginVO(loginVO1);
			
			toName = "Admin";
			feedbackVO.setToName(toName);
		}
		
		feedbackDAO.insertFeedback(feedbackVO);
	}
}
