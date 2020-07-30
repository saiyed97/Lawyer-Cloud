package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;




import javax.servlet.http.Part;




import DAO.AreaDAO;
import DAO.CategoryDAO;
import DAO.CityDAO;
import DAO.LawyerRegisterDAO;
import DAO.LoginDAO;
import DAO.StateDAO;
import DAO.SubCategoryDAO;
import VO.AreaVO;
import VO.CategoryVO;
import VO.CityVO;
import VO.LawyerRegisterVO;
import VO.LoginVO;
import VO.StateVO;
import VO.SubCategoryVO;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/LawyerRegisterController")
@MultipartConfig
public class LawyerRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LawyerRegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String flag=request.getParameter("flag");
		
		if(flag.equals("loadFieldsForLawyer"))
		{
			searchFieldsForLawyer(request,response);
			response.sendRedirect("user/lawyerRegister.jsp"); 
		}
		
		if(flag.equals("searchLawyer"))
		{
			searchLawyer(request,response);
			response.sendRedirect("admin/viewLawyer.jsp"); 
		}
		
		if(flag.equals("lawyerProfile"))
		{
			searchLawyerProfile(request,response);
			response.sendRedirect("lawyer/lawyerProfile.jsp"); 
		}
		
		if(flag.equals("editProfile"))
		{
			searchLawyerProfile(request,response);
			searchFieldsForLawyer(request,response);
			response.sendRedirect("lawyer/editProfile.jsp"); 
		}
		
		if(flag.equals("changePassword"))
		{
			response.sendRedirect("lawyer/changePassword.jsp"); 
		}
		
		if(flag.equals("changeImage"))
		{
			response.sendRedirect("lawyer/changeImage.jsp");
		}
	}


	private void searchLawyerProfile(HttpServletRequest request,
			HttpServletResponse response) 
	{
		HttpSession session = request.getSession();
		long loginId1 = (Long)session.getAttribute("userID");
		int loginId = (int)loginId1;
		
		LoginVO   loginVO = new  LoginVO();
		loginVO.setLoginId(loginId);
		
		LawyerRegisterDAO lawyerRegisterDAO = new LawyerRegisterDAO();
		List lawyerProfileLs = lawyerRegisterDAO.searchLawyerProfile(loginVO);
	
		session.setAttribute("lawyerProfileLs",lawyerProfileLs );
	}

	private void searchLawyer(HttpServletRequest request,
			HttpServletResponse response) 
	{
		LawyerRegisterDAO lawyerRegisterDAO = new LawyerRegisterDAO();
		List lawyerList = lawyerRegisterDAO.searchLawyer();
		
		HttpSession session = request.getSession();
		session.setAttribute("lawyerList", lawyerList);
		
	}

	private void searchFieldsForLawyer(HttpServletRequest request,HttpServletResponse response) 
	{
		StateDAO stateDAO = new StateDAO();
		List stateList = stateDAO.searchState();
		HttpSession session = request.getSession();
		session.setAttribute("stateList", stateList);
		
		CityDAO cityDAO = new CityDAO();
		List cityList = cityDAO.search();
		session.setAttribute("cityList", cityList);
		
		AreaDAO areaDAO = new AreaDAO();
		List areaList = areaDAO.searchArea();
		session.setAttribute("areaList", areaList);
		
		CategoryDAO categoryDAO = new CategoryDAO();
		List categoryList = categoryDAO.searchCategory();
		session.setAttribute("categoryList", categoryList);
		
		SubCategoryDAO subCategoryDAO = new SubCategoryDAO();
		List subCategoryList = subCategoryDAO.searchSubCategory();
		session.setAttribute("subCategoryList", subCategoryList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	String userType;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String flag=request.getParameter("flag");
		
		if(flag.equals("register"))
		{
			try 
			{
				insertFieldsForLawyer(request,response);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();			
			}
			
			response.sendRedirect("user/newIndex.jsp");
		}
		
		if(flag.equals("editProfile"))
		{
			editProfile(request,response);
			searchLawyerProfile(request, response);
			response.sendRedirect("lawyer/lawyerProfile.jsp"); 
		}
		
		if(flag.equals("changePassword"))
		{
			changePassword(request, response);
		}
		
		if(flag.equals("changeImage"))
		{
			changeImage(request, response);
			searchLawyerProfile(request, response);
			response.sendRedirect("lawyer/lawyerProfile.jsp");
		}
	}

	
	private void changeImage(HttpServletRequest request,
			HttpServletResponse response) throws FileNotFoundException, IOException, ServletException
	{
		HttpSession session = request.getSession();
		long loginId1 = (Long)session.getAttribute("userID");
		int loginId = (int)loginId1;
		
		LoginVO loginVO = new LoginVO();
		loginVO.setLoginId(loginId);
		
		LawyerRegisterDAO lawyerRegisterDAO = new LawyerRegisterDAO();
		List ls = lawyerRegisterDAO.searchLawyerProfile(loginVO);
		LawyerRegisterVO lsObj = (LawyerRegisterVO)ls.get(0);
		
		int registerId = lsObj.getRegisterId();
		String firstName = lsObj.getFirstName();
		String lastName = lsObj.getLastName();
		String mobileNumber = lsObj.getMobileNumber();
		int stateId = lsObj.getStateVO().getStateId();
		int cityId = lsObj.getCityVO().getCityId();
		int areaId = lsObj.getAreaVO().getAreaId();
		String address = lsObj.getAddress();
		int categoryId = lsObj.getCategoryVO().getCategoryId();
		int subCategoryId = lsObj.getSubCategoryVO().getSubCategoryId();
		String experience = lsObj.getExperience();
		String qualification = lsObj.getQualification();
		
		LawyerRegisterVO registerVO = new LawyerRegisterVO();
	
		registerVO.setRegisterId(registerId);
		registerVO.setFirstName(firstName);
		registerVO.setLastName(lastName);
		registerVO.setMobileNumber(mobileNumber);
		
		StateVO stateVO = new  StateVO();
		stateVO.setStateId(stateId);
		registerVO.setStateVO(stateVO);
		
		CityVO cityVO = new  CityVO();
		cityVO.setCityId(cityId);
		registerVO.setCityVO(cityVO);
		
		AreaVO areaVO = new AreaVO();
		areaVO.setAreaId(areaId);
		registerVO.setAreaVO(areaVO);
		
		registerVO.setAddress(address);
	
		CategoryVO categoryVO = new CategoryVO();
		categoryVO.setCategoryId(categoryId);
		registerVO.setCategoryVO(categoryVO);
		
		
		SubCategoryVO subCategoryVO = new SubCategoryVO();
		subCategoryVO.setSubCategoryId(subCategoryId);
		registerVO.setSubCategoryVO(subCategoryVO);
		
		registerVO.setExperience(experience);
		registerVO.setQualification(qualification);
		
		registerVO.setLoginVO(loginVO);
		
		for(Part filepart:request.getParts())
		{
			if(filepart.getSubmittedFileName() != null && !filepart.getSubmittedFileName().equals(""))
				{
					String filename = filepart.getSubmittedFileName();
	
					InputStream fileContent = filepart.getInputStream();
	
					byte[] buffer = new byte[fileContent.available()];
					
					fileContent.read(buffer);
	
					String filePath = getServletContext().getRealPath(request.getServletPath());

					int path = filePath.lastIndexOf('\\');
					
					String path1 = filePath.substring(0, path) + "\\doc\\";
	
					 File targetFile = new File(path1+filename); 
					 
					 OutputStream outStream = new FileOutputStream(targetFile);
					 
					 outStream.write(buffer);
					
					 registerVO.setFileName(filename);
					 registerVO.setFilePath(path1);
					    
					 outStream.close();
		        }
		} 
		
		lawyerRegisterDAO.updateProfileImage(registerVO);
		
	}

	private void changePassword(HttpServletRequest request,
			HttpServletResponse response) throws IOException 
	{
		String newPassword = request.getParameter("newPassword");
		String confirmPassword = request.getParameter("confirmPassword");
		
		if(newPassword.equals(confirmPassword))
		{
			HttpSession session = request.getSession();
			long loginId1 = (Long)session.getAttribute("userID");
			int loginId = (int)loginId1;
			
			LoginVO   loginVO = new  LoginVO();
			loginVO.setLoginId(loginId);
			
			
			LoginDAO loginDAO = new LoginDAO();
			List ls = loginDAO.getLogin(loginVO);
			LoginVO lsObj = (LoginVO)ls.get(0);
			String email = lsObj.getEmail();
			String role = lsObj.getRole();
			
			loginVO.setEmail(email);
			loginVO.setRole(role);
			
			loginVO.setPassword(newPassword);
			
	
			loginDAO.updatePassword(loginVO);
			response.sendRedirect("lawyer/index.jsp");
		}
		else
		{
			response.sendRedirect("lawyer/changePassword.jsp");
		}
	}

	

	private void editProfile(HttpServletRequest request,
			HttpServletResponse response) 
	{
		int registerId = Integer.parseInt(request.getParameter("registerId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String mobileNumber = request.getParameter("mobileNumber");
		int stateId = Integer.parseInt(request.getParameter("stateId"));
		int cityId = Integer.parseInt(request.getParameter("cityId"));
		int areaId = Integer.parseInt(request.getParameter("areaId"));
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		int subCategoryId = Integer.parseInt(request.getParameter("subCategoryId"));
		String experience = request.getParameter("experience");
		String qualification = request.getParameter("qualification");
		String address = request.getParameter("address");
		String fileName = request.getParameter("fileName");
		String filePath = request.getParameter("filePath");
		int loginId = Integer.parseInt(request.getParameter("loginId"));
		
		LawyerRegisterVO registerVO = new LawyerRegisterVO();
		
		registerVO.setRegisterId(registerId);
		registerVO.setFirstName(firstName);
		registerVO.setLastName(lastName);
		registerVO.setMobileNumber(mobileNumber);
		
		StateVO stateVO = new  StateVO();
		stateVO.setStateId(stateId);
		registerVO.setStateVO(stateVO);
		
		CityVO cityVO = new  CityVO();
		cityVO.setCityId(cityId);
		registerVO.setCityVO(cityVO);
		
		AreaVO areaVO = new AreaVO();
		areaVO.setAreaId(areaId);
		registerVO.setAreaVO(areaVO);
		
		CategoryVO categoryVO = new CategoryVO();
		categoryVO.setCategoryId(categoryId);
		registerVO.setCategoryVO(categoryVO);
		
		
		SubCategoryVO subCategoryVO = new SubCategoryVO();
		subCategoryVO.setSubCategoryId(subCategoryId);
		registerVO.setSubCategoryVO(subCategoryVO);
		
		registerVO.setAddress(address);
		registerVO.setExperience(experience);
		registerVO.setQualification(qualification);
		registerVO.setFileName(fileName);
		registerVO.setFilePath(filePath);
		
		LoginVO loginVO = new LoginVO();
		loginVO.setLoginId(loginId);
		registerVO.setLoginVO(loginVO);
		
		LawyerRegisterDAO lawyerRegisterDAO = new LawyerRegisterDAO();
		lawyerRegisterDAO.editProfile(registerVO);
	}

	private void insertFieldsForLawyer(HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String mobileNumber = request.getParameter("mobileNumber");
		int stateId = Integer.parseInt(request.getParameter("stateName"));
		int cityId = Integer.parseInt(request.getParameter("cityName"));
		int areaId = Integer.parseInt(request.getParameter("areaName"));
		String address = request.getParameter("address");
		int categoryId = Integer.parseInt(request.getParameter("categoryName"));
		int subCategoryId = Integer.parseInt(request.getParameter("subCategoryName"));
		String experience = request.getParameter("experience");
		String qualification = request.getParameter("qualification");
		String password = request.getParameter("password");
		
		LawyerRegisterVO registerVO = new LawyerRegisterVO();
		
		registerVO.setFirstName(firstName);
		registerVO.setLastName(lastName);
		
		LoginVO loginVO = new LoginVO();
		LoginDAO loginDAO = new LoginDAO();
		
		loginVO.setEmail(email);
		loginVO.setRole("Lawyer");
		
		registerVO.setMobileNumber(mobileNumber);
		
		StateVO stateVO = new  StateVO();
		stateVO.setStateId(stateId);
		registerVO.setStateVO(stateVO);
		
		CityVO cityVO = new  CityVO();
		cityVO.setCityId(cityId);
		registerVO.setCityVO(cityVO);
		
		AreaVO areaVO = new AreaVO();
		areaVO.setAreaId(areaId);
		registerVO.setAreaVO(areaVO);
		
		registerVO.setAddress(address);
	
		CategoryVO categoryVO = new CategoryVO();
		categoryVO.setCategoryId(categoryId);
		registerVO.setCategoryVO(categoryVO);
		
		
		SubCategoryVO subCategoryVO = new SubCategoryVO();
		subCategoryVO.setSubCategoryId(subCategoryId);
		registerVO.setSubCategoryVO(subCategoryVO);
		
		registerVO.setExperience(experience);
		registerVO.setQualification(qualification);
		
		loginVO.setPassword(password);		
		
		LawyerRegisterDAO registerDAO = new LawyerRegisterDAO();
		loginDAO.insertFields(loginVO);
		registerVO.setLoginVO(loginVO);
		
		
		for(Part filepart:request.getParts())
		{
			if(filepart.getSubmittedFileName() != null && !filepart.getSubmittedFileName().equals(""))
				{
					String filename = filepart.getSubmittedFileName();
	
					InputStream fileContent = filepart.getInputStream();
	
					byte[] buffer = new byte[fileContent.available()];
					
					fileContent.read(buffer);
	
					String filePath = getServletContext().getRealPath(request.getServletPath());

					int path = filePath.lastIndexOf('\\');
					
					String path1 = filePath.substring(0, path) + "\\doc\\";
	
					 File targetFile = new File(path1+filename); 
					 
					 OutputStream outStream = new FileOutputStream(targetFile);
					 
					 outStream.write(buffer);
					
					 registerVO.setFileName(filename);
					 registerVO.setFilePath(path1);
					    
					 outStream.close();
		        }
		}
		
		
		registerDAO.insertFieldsForLawyer(registerVO);	
	}

}
