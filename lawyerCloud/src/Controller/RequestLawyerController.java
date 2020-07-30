package Controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;







import DAO.RequestLawyerDAO;
import VO.CategoryVO;
import VO.LawyerRegisterVO;
import VO.LoginVO;
import VO.RequestLawyerVO;

/**
 * Servlet implementation class RequestLawyerController
 */
@WebServlet("/RequestLawyerController")
public class RequestLawyerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestLawyerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String flag = request.getParameter("flag");
		
		if(flag.equals("requestLawyer"))
		{
			requestDescription(request,response);
			response.sendRedirect("client/requestDescription.jsp");
		}
		
		if(flag.equals("searchRequest"))
		{
			searchClientRequest(request,response);
			response.sendRedirect("lawyer/clientRequest.jsp");
		}
		
		if(flag.equals("acceptRequest"))
		{
			searchRequest(request,response);
			response.sendRedirect("lawyer/acceptRequest.jsp");
		}
		
		if(flag.equals("rejectRequest"))
		{
			searchRequest(request,response);
			response.sendRedirect("lawyer/rejectRequest.jsp");
		}
		
		if(flag.equals("searchMyRequest"))
		{
			searchMyRequest(request,response);
			response.sendRedirect("client/myRequest.jsp");
		}
		
		if(flag.equals("searchMyRequestToComplain"))
		{
			searchMyRequest(request,response);
			response.sendRedirect("client/complain.jsp");
		}
		
		if(flag.equals("searchMyRequestToFeedback"))
		{
			searchMyRequest(request,response);
			response.sendRedirect("client/feedback.jsp");
		}
	}

	private void searchMyRequest(HttpServletRequest request,
			HttpServletResponse response) 
	{
		HttpSession session = request.getSession();
		
		long clientLoginId1 = (Long)session.getAttribute("userID");
		int clientLoginId = (int)clientLoginId1;
		
		LoginVO loginVO = new LoginVO();
		loginVO.setLoginId(clientLoginId);
		
		RequestLawyerVO requestLawyerVO = new RequestLawyerVO();
		requestLawyerVO.setLoginVO(loginVO);
		
		RequestLawyerDAO requestLawyerDAO = new RequestLawyerDAO();
		List myRequestList = requestLawyerDAO.searchMyRequest(requestLawyerVO);
		
		session.setAttribute("myRequestList", myRequestList);
	}

	private void searchRequest(HttpServletRequest request,
			HttpServletResponse response)
	{
		/*for email-----start*/
		
		String clientEmailId = request.getParameter("clientEmailId");
		
		HttpSession session = request.getSession();
		
		session.setAttribute("clientEmailId", clientEmailId);
		
		long lawyerLoginId1 = (Long)session.getAttribute("userID");
		int lawyerLoginId = (int)lawyerLoginId1;
		
		LoginVO loginVO = new LoginVO();
		loginVO.setLoginId(lawyerLoginId);
		
		LawyerRegisterVO lawyerRegisterVO = new LawyerRegisterVO();
		lawyerRegisterVO.setLoginVO(loginVO);
				
		RequestLawyerDAO requestLawyerDAO = new RequestLawyerDAO();
		
		List ls1 = requestLawyerDAO.searchLoginLs(loginVO);
		LoginVO ls1Obj =(LoginVO)ls1.get(0);
		String lawyerEmailId = ls1Obj.getEmail();
		String lawyerPassword = ls1Obj.getPassword();
		
		session.setAttribute("lawyerEmailId", lawyerEmailId);
		System.out.println("id up}}}}}}"+lawyerEmailId);
		session.setAttribute("lawyerPassword", lawyerPassword);
		
		List ls = requestLawyerDAO.searchLs(lawyerRegisterVO);
		LawyerRegisterVO lsObj = (LawyerRegisterVO)ls.get(0);
		String lawyerMobileNumber = lsObj.getMobileNumber();
		String lawyerFirstName = lsObj.getFirstName();
		String lawyerLastName = lsObj.getLastName();
		String lawyerName = lawyerFirstName+ " "+lawyerLastName;  
		
		session.setAttribute("lawyerName", lawyerName);
		session.setAttribute("lawyerMobileNumber",lawyerMobileNumber);
		
		/*for email-------end*/
		
		
		int requestLawyerId = Integer.parseInt(request.getParameter("requestId"));
		
		RequestLawyerVO requestLawyerVO = new RequestLawyerVO();
		requestLawyerVO.setRequestLawyerId(requestLawyerId);
		
		/*RequestLawyerDAO requestLawyerDAO = new RequestLawyerDAO();*/
		
		List clientRequestList = requestLawyerDAO.searchRequest(requestLawyerVO);
		
		session.setAttribute("clientRequestList", clientRequestList);
		
	}

	private void searchClientRequest(HttpServletRequest request,
			HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		
		long lawyerLoginId1 = (Long)session.getAttribute("userID");
		int lawyerLoginId = (int)lawyerLoginId1;
		
		LoginVO loginVO = new LoginVO();
		loginVO.setLoginId(lawyerLoginId);
		
		LawyerRegisterVO lawyerRegisterVO = new LawyerRegisterVO();
		lawyerRegisterVO.setLoginVO(loginVO);
		
		/*RequestLawyerVO requestLawyerVO = new RequestLawyerVO();
		requestLawyerVO.setLawyerRegisterVO(lawyerRegisterVO);*/
		
		RequestLawyerDAO requestLawyerDAO = new RequestLawyerDAO();
		
		List ls = requestLawyerDAO.searchLs(lawyerRegisterVO);
		
		LawyerRegisterVO lsObj = (LawyerRegisterVO)ls.get(0);
		int lawyerRegisterId = lsObj.getRegisterId();
		 
		loginVO.setLoginId(lawyerRegisterId);
		
		RequestLawyerVO requestLawyerVO = new RequestLawyerVO();
		requestLawyerVO.setLoginVO(loginVO);
		
		List clientRequestList = requestLawyerDAO.searchClientRequest(requestLawyerVO);
		session.setAttribute("clientRequestList", clientRequestList);
	}

	private void requestDescription(HttpServletRequest request,
			HttpServletResponse response) 
	{
		int lawyerId = Integer.parseInt(request.getParameter("lawyerId"));
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		
		HttpSession session = request.getSession();
		session.setAttribute("lawyerId", lawyerId);
		session.setAttribute("categoryId", categoryId);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String flag = request.getParameter("flag");
		
		if(flag.equals("insertRequestDescription"))
		{
			InsertRequestDescription(request,response);
			response.sendRedirect("client/index.jsp");
		}
		
		if(flag.equals("insertAcceptRequestDescription"))
		{
			InsertAcceptRequestDescription(request,response);
			searchClientRequest(request,response);
			response.sendRedirect("lawyer/clientRequest.jsp");
		}
		
		if(flag.equals("insertRejectRequestDescription"))
		{
			InsertRejectRequestDescription(request,response);
			searchClientRequest(request,response);
			response.sendRedirect("lawyer/clientRequest.jsp");
		}
		
	}

	private void InsertRejectRequestDescription(HttpServletRequest request,
			HttpServletResponse response)
	{
		String mobileNumber = request.getParameter("mobileNumber");
		String requestDescription = request.getParameter("requestDescription");
		String acceptRequestDescription = request.getParameter("rejectRequestDescription");
		int requestLawyerId = Integer.parseInt(request.getParameter("requestLawyerId"));
		int registerId = Integer.parseInt(request.getParameter("registerId"));
		int loginId = Integer.parseInt(request.getParameter("loginId"));
		String requestDateAndTime = request.getParameter("requestDateAndTime");
		String requestStatus = request.getParameter("requestStatus");
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		
		RequestLawyerVO requestLawyerVO = new RequestLawyerVO();
		
		requestLawyerVO.setRequestLawyerId(requestLawyerId);
		
		LawyerRegisterVO lawyerRegisterVO = new LawyerRegisterVO();
		lawyerRegisterVO.setRegisterId(registerId);
		requestLawyerVO.setLawyerRegisterVO(lawyerRegisterVO);
		
		LoginVO loginVO = new LoginVO();
		loginVO.setLoginId(loginId);
		requestLawyerVO.setLoginVO(loginVO);
		
		requestLawyerVO.setMobileNumber(mobileNumber);
		requestLawyerVO.setRequestDateAndTime(requestDateAndTime);
		requestLawyerVO.setRequestDescription(requestDescription);
		requestLawyerVO.setRequestReplyDescription(acceptRequestDescription);
		requestLawyerVO.setRequestStatus("Rejected");
		
		CategoryVO categoryVO = new CategoryVO();
		categoryVO.setCategoryId(categoryId);
		
		requestLawyerVO.setCategoryVO(categoryVO);
		
		RequestLawyerDAO requestLawyerDAO = new RequestLawyerDAO();
		requestLawyerDAO.insertAcceptRequestDescription(requestLawyerVO);
		
		
		
		/* sending mail to client--------start*/
		
		
		
		HttpSession session1 = request.getSession();
		
		String email = (String)session1.getAttribute("clientEmailId");
		/*String lawyerName = (String)session1.getAttribute("lawyerName");
		String lawyerMobileNumber = (String)session1.getAttribute("lawyerMobileNumber");*/
		
		final String from = (String)session1.getAttribute("lawyerEmailId");
		final String username = "Lawyer";
		final String password = (String)session1.getAttribute("lawyerPassword");

		System.out.println("id up}}}}}}"+from);
		
		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(email));
			message.setSubject("Rejected ");
			/*
			 * int num = 0; String pass = ""; for (int i = 0; i < 4;
			 * i++) { num = (int) (Math.random() * 10); pass += num; }
			 * 
			 * System.out.println(pass);
			 * 
			 * s.setAttribute("password", pass);
			 */

			message.setText("Sorry, this is to inform you that i have rejected your request kindly see description in your account");

			Transport.send(message);

			System.out.println("Sent message successfully....");

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	private void InsertAcceptRequestDescription(HttpServletRequest request,
			HttpServletResponse response) 
	{
		String mobileNumber = request.getParameter("mobileNumber");
		String requestDescription = request.getParameter("requestDescription");
		String acceptRequestDescription = request.getParameter("acceptRequestDescription");
		int requestLawyerId = Integer.parseInt(request.getParameter("requestLawyerId"));
		int registerId = Integer.parseInt(request.getParameter("registerId"));
		int loginId = Integer.parseInt(request.getParameter("loginId"));
		String requestDateAndTime = request.getParameter("requestDateAndTime");
		String requestStatus = request.getParameter("requestStatus");
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		
		RequestLawyerVO requestLawyerVO = new RequestLawyerVO();
		
		requestLawyerVO.setRequestLawyerId(requestLawyerId);
		
		LawyerRegisterVO lawyerRegisterVO = new LawyerRegisterVO();
		lawyerRegisterVO.setRegisterId(registerId);
		requestLawyerVO.setLawyerRegisterVO(lawyerRegisterVO);
		
		LoginVO loginVO = new LoginVO();
		loginVO.setLoginId(loginId);
		requestLawyerVO.setLoginVO(loginVO);
		
		requestLawyerVO.setRequestDateAndTime(requestDateAndTime);
		requestLawyerVO.setMobileNumber(mobileNumber);
		requestLawyerVO.setRequestDescription(requestDescription);
		requestLawyerVO.setRequestReplyDescription(acceptRequestDescription);
		requestLawyerVO.setRequestStatus("Accepted");
		
		CategoryVO categoryVO = new CategoryVO();
		categoryVO.setCategoryId(categoryId);
		
		requestLawyerVO.setCategoryVO(categoryVO);
		
		RequestLawyerDAO requestLawyerDAO = new RequestLawyerDAO();
		requestLawyerDAO.insertAcceptRequestDescription(requestLawyerVO);
		
		
		/* sending mail to client--------start*/
		
		
		
		HttpSession session1 = request.getSession();
		
		String email = (String)session1.getAttribute("clientEmailId");
		String lawyerName = (String)session1.getAttribute("lawyerName");
		String lawyerMobileNumber = (String)session1.getAttribute("lawyerMobileNumber");
		
		final String from = (String)session1.getAttribute("lawyerEmailId");
		final String username = "Lawyer";
		final String password = (String)session1.getAttribute("lawyerPassword");

		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(email));
			message.setSubject("Approved ");
			/*
			 * int num = 0; String pass = ""; for (int i = 0; i < 4;
			 * i++) { num = (int) (Math.random() * 10); pass += num; }
			 * 
			 * System.out.println(pass);
			 * 
			 * s.setAttribute("password", pass);
			 */

			message.setText("Hello this is to inform you that i have accepted your request so for further details plz contact me----> Contact Number : "+lawyerMobileNumber+" "+lawyerName);

			Transport.send(message);

			System.out.println("Sent message successfully....");

		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}

	private void InsertRequestDescription(HttpServletRequest request,
			HttpServletResponse response)
	{
		String mobileNumber = request.getParameter("mobileNumber");
		String requestDescription = request.getParameter("requestDescription");
		
		
		HttpSession session = request.getSession();
		
		long loginId1 = (Long)session.getAttribute("userID");
		int loginId = (int)loginId1;
		
		int lawyerId = (Integer)session.getAttribute("lawyerId");
		int categoryId = (Integer)session.getAttribute("categoryId");
		
		RequestLawyerVO requestLawyerVO = new RequestLawyerVO();
		
		LawyerRegisterVO lawyerRegisterVO = new LawyerRegisterVO();
		lawyerRegisterVO.setRegisterId(lawyerId);
		requestLawyerVO.setLawyerRegisterVO(lawyerRegisterVO);
		
		
		CategoryVO categoryVO = new CategoryVO();
		categoryVO.setCategoryId(categoryId);
		requestLawyerVO.setCategoryVO(categoryVO);
		
		LoginVO loginVO = new LoginVO();
		loginVO.setLoginId(loginId);
		requestLawyerVO.setLoginVO(loginVO);
		
		requestLawyerVO.setRequestDescription(requestDescription);
		requestLawyerVO.setMobileNumber(mobileNumber);
		
		Date d = new Date();
		String date = d.toString();
		
		requestLawyerVO.setRequestDateAndTime(date);
		
		requestLawyerVO.setRequestStatus("Pending");
		
		RequestLawyerDAO requestLawyerDAO = new RequestLawyerDAO();
		requestLawyerDAO.insertRequestLawyer(requestLawyerVO);
		
		
		/*email notification to lawyer*/
		
		
		
		LawyerRegisterVO lawyerRegisterVO1 = new LawyerRegisterVO();
		lawyerRegisterVO1.setRegisterId(lawyerId);
		List loginLsList = requestLawyerDAO.getLawyerLoginId(lawyerRegisterVO);
		LawyerRegisterVO loginLsListObj =(LawyerRegisterVO)loginLsList.get(0);
		String lawyerLoginEmail = loginLsListObj.getLoginVO().getEmail();
		System.out.println("lawyer email ==== "+lawyerLoginEmail);
		final String from = "lawyercloud10298@gmail.com";
		final String username = "Admin";
		final String password = "lawyercloud@10298";

		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		Session session1 = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

		try {
			Message message = new MimeMessage(session1);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(lawyerLoginEmail));
			message.setSubject("Received Request ");
			/*
			 * int num = 0; String pass = ""; for (int i = 0; i < 4;
			 * i++) { num = (int) (Math.random() * 10); pass += num; }
			 * 
			 * System.out.println(pass);
			 * 
			 * s.setAttribute("password", pass);
			 */

			message.setText("hello you have got an new request please check your account ----> from Admin : LawyerCloud");

			Transport.send(message);

			System.out.println("Sent message successfully....");

		} catch (Exception e) {

			e.printStackTrace();
		}
		
		
		/*email notification to lawyer*/
		
		
	}
}
