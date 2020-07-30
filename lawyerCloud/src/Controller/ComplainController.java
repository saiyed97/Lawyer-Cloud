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
import DAO.TestimonialDAO;
import VO.ClientRegisterVO;
import VO.ComplainVO;
import VO.LawyerRegisterVO;
import VO.LoginVO;

/**
 * Servlet implementation class ComplaintController
 */
@WebServlet("/ComplainController")
public class ComplainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComplainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String flag = request.getParameter("flag");
		
		if(flag.equals("complain"))
		{
			response.sendRedirect("client/complain.jsp");
		}
		
		if(flag.equals("complainToLawyer"))
		{
			int lawyerId = Integer.parseInt(request.getParameter("lawyerId"));
			
			HttpSession session = request.getSession();
			session.setAttribute("lawyerId", lawyerId);
			
			response.sendRedirect("client/complain.jsp");
		}
		
		
		if(flag.equals("searchComplainForAdmin"))
		{
			searchComplainForAdmin(request,response);
			response.sendRedirect("admin/viewComplain.jsp");
		}
		
		if(flag.equals("complainReply"))
		{
			searchComplainForComplainreply(request,response);
			response.sendRedirect("admin/complainReply.jsp");
		}
		
		if(flag.equals("searchComplainForLawyer"))
		{
			searchComplainForLawyer(request,response);
			response.sendRedirect("lawyer/receivedComplain.jsp");
		}
		
		if(flag.equals("complainReplyByLawyer"))
		{
			searchComplainForComplainreply(request,response);
			response.sendRedirect("lawyer/complainReply.jsp");
		}
		
		if(flag.equals("complainToAdminByLawyer"))
		{
			response.sendRedirect("lawyer/complain.jsp");
		}
		
		if(flag.equals("viewLawyerSentComplains"))
		{
			viewLawyerSentComplains(request,response);
			response.sendRedirect("lawyer/viewSentComplain.jsp");
		}
		
		if(flag.equals("viewClientSentComplains"))
		{
			viewClientSentComplains(request,response);
			response.sendRedirect("client/viewSentComplain.jsp");
		}
		
	}
	

	private void searchComplainForLawyer(HttpServletRequest request,
			HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		long loginId1 = (Long)session.getAttribute("userID");
		int loginId = (int)loginId1;
		
		LoginVO   loginVO = new  LoginVO();
		loginVO.setLoginId(loginId);
		
		/*ComplainVO complainVO = new ComplainVO();
		complainVO.setToLoginVO(loginVO);*/
		
		ComplainDAO complainDAO = new ComplainDAO();
		List complainList = complainDAO.searchComplainForLawyer(loginVO);
		
		
		session.setAttribute("complainList", complainList);
		
	}

	private void viewClientSentComplains(HttpServletRequest request,
			HttpServletResponse response) 
	{
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		long loginId1 = (Long)session.getAttribute("userID");
		int loginId = (int)loginId1;
		
		LoginVO   loginVO = new  LoginVO();
		loginVO.setLoginId(loginId);
				
		ComplainVO complainVO = new ComplainVO();
		complainVO.setFromLoginVO(loginVO);
		
		ComplainDAO complainDAO = new ComplainDAO();
		List complainList = complainDAO.searchClientSentComplains(complainVO);
		
		session.setAttribute("complainList", complainList);
	}

	private void viewLawyerSentComplains(HttpServletRequest request,
			HttpServletResponse response) 
	{
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		long loginId1 = (Long)session.getAttribute("userID");
		int loginId = (int)loginId1;
		
		LoginVO   loginVO = new  LoginVO();
		loginVO.setLoginId(loginId);
				
		ComplainVO complainVO = new ComplainVO();
		complainVO.setFromLoginVO(loginVO);
		
		ComplainDAO complainDAO = new ComplainDAO();
		List complainList = complainDAO.searchLawyerSentComplains(complainVO);
		
		session.setAttribute("complainList", complainList);
		
	}

	private void searchComplainForComplainreply(HttpServletRequest request,
			HttpServletResponse response) 
	{
			
		ComplainVO complainVO = new ComplainVO();
		
		int complainId =Integer.parseInt(request.getParameter("complainId"));
		complainVO.setComplainId(complainId);
		ComplainDAO complainDAO = new ComplainDAO();
		List complainList = complainDAO.searchComplainForComplainReply(complainVO);
		
		ComplainVO complainVO1 = (ComplainVO)complainList.get(0);
		String toName = complainVO1.getToName();
		
		System.out.println("TONAME = "+toName);
		
		
		HttpSession session = request.getSession();
		session.setAttribute("complainList", complainList);
	
		/*session.setAttribute("toName", toName);*/
	}

	private void searchComplainForAdmin(HttpServletRequest request,HttpServletResponse response) 
	{
		
		ComplainDAO complainDAO = new ComplainDAO();
		
		ComplainVO complainVO = new ComplainVO();
		
		List complainList = complainDAO.searchComplainForAdmin(complainVO);
		
		HttpSession session = request.getSession();
		session.setAttribute("complainList", complainList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String flag = request.getParameter("flag");
		
		if(flag.equals("complain"))
		{
			insertComplain(request,response);
			response.sendRedirect("client/index.jsp");
		}
		
		if(flag.equals("complainReply"))
		{
			insertComplainReply(request,response);
			searchComplainForAdmin(request,response);
			response.sendRedirect("admin/viewComplain.jsp");
		}
		
		if(flag.equals("complainReplyByLawyer"))
		{
			insertComplainReply(request,response);
			searchComplainForLawyer(request,response);
			response.sendRedirect("lawyer/receivedComplain.jsp");
		}
		
		if(flag.equals("complainToAdminByLawyer"))
		{
			insertComplain(request,response);
			response.sendRedirect("lawyer/index.jsp");
		}
	}


	private void insertComplainReply(HttpServletRequest request,
			HttpServletResponse response) 
	{
		String complainSubject = request.getParameter("complainSubject");
		String complainDescription = request.getParameter("complainDescription");
		
		String complainReply = request.getParameter("complainReply");
		int complainId = Integer.parseInt(request.getParameter("complainId"));
		/*String complainStatus = request.getParameter("complainStatus");*/
		String complainDateAndTime = request.getParameter("complainDateAndTime");
		/*String replyDescription = request.getParameter("replyDescription");*/
		int fromLoginId = Integer.parseInt(request.getParameter("fromLoginId"));
		int toLoginId = Integer.parseInt(request.getParameter("toLoginId"));
		String toName = request.getParameter("toName");
		System.out.println("toname"+toName);
		String name = request.getParameter("name");
		
		ComplainVO complainVO = new ComplainVO();
		
		complainVO.setComplainId(complainId);
		complainVO.setComplainSubject(complainSubject);
		complainVO.setComplainDescription(complainDescription);
		complainVO.setComplainDateAndTime(complainDateAndTime);
		complainVO.setComplainStatus("Resolved");
		/*complainVO.setComplainTo(complainTo);*/
		complainVO.setReplyDescription(complainReply);
		complainVO.setName(name);
		complainVO.setToName(toName);
		
		LoginVO loginVO = new LoginVO();
		loginVO.setLoginId(fromLoginId);
		complainVO.setFromLoginVO(loginVO);
		
		LoginVO loginVO1 = new LoginVO();
		loginVO1.setLoginId(toLoginId);
		complainVO.setToLoginVO(loginVO1);
		
		ComplainDAO complainDAO = new ComplainDAO();
		complainDAO.insertComplainReply(complainVO);
	}

	private void insertComplain(HttpServletRequest request,
			HttpServletResponse response) 
	{
		
		int complainToRegisterId = Integer.parseInt(request.getParameter("complainToRegisterId"));
		
		System.out.println("id .....///"+complainToRegisterId);
		
		String complainSubject = request.getParameter("complainSubject");
		String complainDescription = request.getParameter("complainDescription");
		
		HttpSession session = request.getSession();
		long loginId1 = (Long)session.getAttribute("userID");
		int loginId = (int)loginId1;
		
		LoginVO   loginVO = new  LoginVO();
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
		
		
		
		ComplainVO complainVO = new ComplainVO();
		
		complainVO.setName(name);
		
		complainVO.setComplainSubject(complainSubject);
		complainVO.setComplainDescription(complainDescription);
		/*complainVO.setComplainTo(complainTo);*/
		
		Date d = new Date();
		String date = d.toString();
		
		complainVO.setComplainDateAndTime(date);
		complainVO.setComplainStatus("Pending");
		
		System.out.println("client login id = "+loginId);
		
		/*loginVO.setLoginId(loginId);*/
		complainVO.setFromLoginVO(loginVO);
		
		
		
		/*int lid = (int) session.getAttribute("lawyerId");
		System.out.println("lawwwww=="+lid);*/
		
		LawyerRegisterVO lawyerRegisterVO = new LawyerRegisterVO();
		
		System.out.println("lawyer register id"+complainToRegisterId);
		
		LoginVO loginVO1 = new LoginVO();
		
		ComplainDAO complainDAO = new ComplainDAO();
		
		
		
		if(complainToRegisterId != 1)
		{
			lawyerRegisterVO.setRegisterId(complainToRegisterId);
			
			System.out.println("id......"+complainToRegisterId);
			
			List ls = complainDAO.searchloginId(lawyerRegisterVO); 
			LawyerRegisterVO lv = (LawyerRegisterVO) ls.get(0);		
		
			int lwId = lv.getLoginVO().getLoginId();		
		
			System.out.println("loginID LWWWW>>>"+lwId);

			loginVO1.setLoginId(lwId);
			complainVO.setToLoginVO(loginVO1);
			
			
			List ls1 = complainDAO.searchName(lawyerRegisterVO);
			LawyerRegisterVO lrVO = (LawyerRegisterVO)ls1.get(0);
			String fn = lrVO.getFirstName();
			String ln = lrVO.getLastName();
			String toName = fn+" "+ln;
			complainVO.setToName(toName);
			
		}
		
		else
		{
			loginVO1.setLoginId(complainToRegisterId);
			complainVO.setToLoginVO(loginVO1);
			
			String toName = "Admin";
			complainVO.setToName(toName);
		}
		
		complainDAO.insertComplain(complainVO);
	}
}
