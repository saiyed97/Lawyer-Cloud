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

import DAO.TestimonialDAO;
import VO.ClientRegisterVO;
import VO.LawyerRegisterVO;
import VO.LoginVO;
import VO.TestimonialVO;

/**
 * Servlet implementation class TestimonialController
 */
@WebServlet("/TestimonialController")
public class TestimonialController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestimonialController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String flag = request.getParameter("flag");
		
		if(flag.equals("testimonial"))
		{
			response.sendRedirect("client/testimonial.jsp");
		}
		
		if(flag.equals("testimonialLawyer"))
		{
			response.sendRedirect("lawyer/testimonial.jsp");
		}
		
		if(flag.equals("searchTestimonial"))
		{
			searchTestimonialDetails(request,response);
			response.sendRedirect("admin/viewTestimonial.jsp");
		}
	}

	private void searchTestimonialDetails(HttpServletRequest request,
			HttpServletResponse response)
	{
		TestimonialDAO testimonialDAO = new TestimonialDAO();
		List testimonialList = testimonialDAO.searchTestimonialDetails();
		
		HttpSession session = request.getSession();
		session.setAttribute("testimonialList", testimonialList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String flag = request.getParameter("flag");
		
		if(flag.equals("insertTestimonial"))
		{
			insertTestimonial(request,response);
		}
	}

	private void insertTestimonial(HttpServletRequest request,
			HttpServletResponse response) 
	{
		HttpSession session = request.getSession();
		
		long loginId1 = (Long)session.getAttribute("userID");
		int loginId = (int)loginId1;
		LoginVO   loginVO = new  LoginVO();
		loginVO.setLoginId(loginId);
		
		TestimonialDAO testimonialDAO = new TestimonialDAO();
		List roleList = testimonialDAO.searchRole(loginVO);
		LoginVO roleListObj = (LoginVO)roleList.get(0);
		String role = roleListObj.getRole();
		
		String name = "";
		
		System.out.println("Role = "+role);
		
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
			
			System.out.println("FName = "+firstName);
			System.out.println("LName = "+lastName);
			System.out.println("Name = "+name);
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
			
		TestimonialVO testimonialVO = new TestimonialVO();
		testimonialVO.setName(name);
		
		String testimonialDescription = request.getParameter("testimonialDescription");

		testimonialVO.setTestimonialDescription(testimonialDescription);
		testimonialVO.setTestimonialStatus("Pending");
		
		Date d = new Date();
		String date = d.toString();
		
		testimonialVO.setDateAndTime(date);
		testimonialVO.setLoginVO(loginVO);
		
		testimonialDAO.insertTestimonialDetails(testimonialVO);
		
		try
		{
			if(role.equals("Client"))
			{
				response.sendRedirect("client/index.jsp");
			}
			else if(role.equals("Lawyer"))
			{
				response.sendRedirect("lawyer/index.jsp");
			}
		
		}
		catch(Exception e)
		{
			
		}
	}

}
