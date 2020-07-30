package Controller;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;

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

import DAO.CategoryDAO;
import DAO.ContactUsDAO;
import VO.CategoryVO;
import VO.ContactUsVO;
import VO.LoginVO;

/**
 * Servlet implementation class ContactUsController
 */
@WebServlet("/ContactUsController")
public class ContactUsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactUsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String flag = request.getParameter("flag");
		
		if(flag.equals("loadServices"))
		{
			searchCategory(request,response);
			response.sendRedirect("user/contactUs.jsp");
		}
		
		if(flag.equals("searchContactUsDetails"))
		{
			searchContactsUsDetails(request,response);
			response.sendRedirect("admin/viewContactUsDetails.jsp");
		}
		
		if(flag.equals("logout"))
		{
			HttpSession session = request.getSession(false);
			if(session != null)
			{
				session.removeAttribute("userID");
				session.invalidate();
				session=null;
			}
			response.sendRedirect(request.getContextPath() + "/user/newIndex.jsp");
		}
		
		if(flag.equals("forgotPassword"))
		{
			response.sendRedirect("admin/step1.jsp");
		}
	}

	private void searchContactsUsDetails(HttpServletRequest request,
			HttpServletResponse response)
	{
		ContactUsDAO contactUsDAO = new ContactUsDAO();
		List contactUsDetailsList = contactUsDAO.searchContactsUsDetails();
		
		HttpSession session = request.getSession();
		session.setAttribute("contactUsDetailsList", contactUsDetailsList);
	}

	private void searchCategory(HttpServletRequest request,
			HttpServletResponse response)
	{
		CategoryDAO categoryDAO = new CategoryDAO();
		List categoryList = categoryDAO.searchCategory();
		HttpSession session = request.getSession();
		session.setAttribute("categoryList", categoryList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String flag = request.getParameter("flag");
		
		if(flag.equals("insertContactUsDetails"))
		{
			insertContactUsDetails(request,response);
			response.sendRedirect("user/newIndex.jsp");
		}
		
		if(flag.equals("step1"))
		{
			verifyEmailId(request,response);
		}
		
		if(flag.equals("step2"))
		{
			verifyOTP(request,response);
		}
	}

	private void verifyOTP(HttpServletRequest request,
			HttpServletResponse response) throws IOException 
	{
		HttpSession session = request.getSession();
		int otp1 =  (int) session.getAttribute("otp");
		int otp2 =Integer.parseInt(request.getParameter("otp"));
		
		String newPassword = request.getParameter("newPassword");
		String confirmPassword = request.getParameter("confirmPassword");
		
		String email = (String) session.getAttribute("verifiedEmailId");
		int loginId = (int)session.getAttribute("loginId");
		String role = (String) session.getAttribute("role");
		
		LoginVO loginVO = new LoginVO();
		
		
		ContactUsDAO contactUsDAO = new ContactUsDAO();
		if(otp1==otp2 && newPassword.equals(confirmPassword))
		{
			loginVO.setEmail(email);
			loginVO.setPassword(newPassword);
			loginVO.setRole(role);
			loginVO.setLoginId(loginId);
			contactUsDAO.updatePassword(loginVO);
			response.sendRedirect("admin/login.jsp");
		}
		else
		{
			response.sendRedirect("admin/step2.jsp");
		}
	}

	private void verifyEmailId(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		String emailId = request.getParameter("emailId");
		System.out.println(emailId);
		LoginVO loginVO = new LoginVO();
		loginVO.setEmail(emailId);
		
		ContactUsDAO contactUsDAO = new ContactUsDAO();
		List ls = contactUsDAO.verifyEmailId(loginVO);
		LoginVO lsObj = (LoginVO)ls.get(0);
		int loginId = (int)lsObj.getLoginId();
		String role = (String)lsObj.getRole();

		if(ls.size()!=0)
		{
			HttpSession session = request.getSession();
			session.setAttribute("verifiedEmailId", emailId);
			session.setAttribute("loginId", loginId);
			session.setAttribute("role", role);
			
			
			/*otp*/
			
				int otp = generateOTP(6);
				session.setAttribute("otp", otp);
			
			/*otp*/
			
			/*mail*/
			
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
						InternetAddress.parse(emailId));
				message.setSubject("Respond - Admin ");
				/*
				 * int num = 0; String pass = ""; for (int i = 0; i < 4;
				 * i++) { num = (int) (Math.random() * 10); pass += num; }
				 * 
				 * System.out.println(pass);
				 * 
				 * s.setAttribute("password", pass);
				 */

				message.setText("Your OTP for new password is "+otp);

				Transport.send(message);

				System.out.println("Sent message successfully....");

			} catch (Exception e) {

				e.printStackTrace();
			}
			/*mail*/
			
			response.sendRedirect("admin/step2.jsp");
			
		}
		
		else
		{
			response.sendRedirect("admin/login.jsp");
		}
		
	}
	
	int generateOTP(int limit) 
	{
	    int otp = 0;

	    if (limit > 5 || limit < 1)
	        limit = 3;

	    for (int i = 0; i < limit; i++) 
	    {
	        int x = new Random().nextInt(9);

	        if (x == 0 && i == 0)
	            i--;
	        else
	            otp = (otp * 10) + x;
	    }
	 //   OTP=otp;
	    return otp;
	}

	private void insertContactUsDetails(HttpServletRequest request,
			HttpServletResponse response) 
	{
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobileNumber = request.getParameter("mobileNumber");
		int service = Integer.parseInt(request.getParameter("service"));
		String description = request.getParameter("description");
		
		ContactUsVO contactUsVO = new ContactUsVO();
		
		contactUsVO.setName(name);
		contactUsVO.setEmail(email);
		contactUsVO.setMobileNumber(mobileNumber);
		
		CategoryVO categoryVO = new CategoryVO();
		categoryVO.setCategoryId(service);
		contactUsVO.setCategoryVO(categoryVO);
		contactUsVO.setDescription(description);
		
		ContactUsDAO contactUsDAO = new ContactUsDAO();
		contactUsDAO.insertContactUsDetails(contactUsVO);
		

		final String from = "lawyercloud10298@gmail.com";
		final String username = "Admin";
		final String password = "lawyercloud@10298";

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
			message.setSubject("Respond - Admin ");
			/*
			 * int num = 0; String pass = ""; for (int i = 0; i < 4;
			 * i++) { num = (int) (Math.random() * 10); pass += num; }
			 * 
			 * System.out.println(pass);
			 * 
			 * s.setAttribute("password", pass);
			 */

			message.setText("hello your contact request has successfully been placed kindly will process services");

			Transport.send(message);

			System.out.println("Sent message successfully....");

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
