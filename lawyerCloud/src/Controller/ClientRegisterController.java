package Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import VO.AreaVO;
import VO.CategoryVO;
import VO.CityVO;
import VO.ClientRegisterVO;
import VO.LawyerRegisterVO;
import VO.LoginVO;
import VO.StateVO;
import VO.SubCategoryVO;
import DAO.AreaDAO;
import DAO.CategoryDAO;
import DAO.CityDAO;
import DAO.ClientRegisterDAO;
import DAO.ComplainDAO;
import DAO.LawyerRegisterDAO;
import DAO.LoginDAO;
import DAO.StateDAO;
import DAO.SubCategoryDAO;

/**
 * Servlet implementation class ClientRegisterController
 */
@WebServlet("/ClientRegisterController")
@MultipartConfig
public class ClientRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientRegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String flag=request.getParameter("flag");
		
		if(flag.equals("loadFieldsForClient"))
		{
			searchFieldsForClient(request,response);
			response.sendRedirect("user/clientRegister.jsp"); 
		}
		
		if(flag.equals("searchClient"))
		{
			searchClient(request,response);
			response.sendRedirect("admin/viewClient.jsp"); 
		}
		
		if(flag.equals("clientProfile"))
		{
			searchClientProfile(request,response);
			response.sendRedirect("client/clientProfile.jsp"); 
		}
		
		if(flag.equals("editProfile"))
		{
			searchClientProfile(request,response);
			searchFieldsForClient(request,response);
			response.sendRedirect("client/editProfile.jsp"); 
		}
		
		if(flag.equals("changePassword"))
		{
			response.sendRedirect("client/changePassword.jsp"); 
		}
		
		if(flag.equals("changeImage"))
		{
			response.sendRedirect("client/changeImage.jsp");
		}
		
	}

	private void searchClientProfile(HttpServletRequest request,
			HttpServletResponse response) 
	{
		HttpSession session = request.getSession();
		long loginId1 = (Long)session.getAttribute("userID");
		int loginId = (int)loginId1;
		
		LoginVO   loginVO = new  LoginVO();
		loginVO.setLoginId(loginId);
		
		ClientRegisterDAO clientRegisterDAO = new ClientRegisterDAO();
		List clientProfileLs = clientRegisterDAO.searchClientProfile(loginVO);
	
		session.setAttribute("clientProfileLs",clientProfileLs );
		
	}

	private void searchClient(HttpServletRequest request,
			HttpServletResponse response) 
	{
		ClientRegisterDAO clientRegisterDAO = new ClientRegisterDAO();
		List clientList = clientRegisterDAO.searchClient();
		
		HttpSession session = request.getSession();
		session.setAttribute("clientList", clientList);
		
	}

	private void searchFieldsForClient(HttpServletRequest request,
			HttpServletResponse response) 
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
				insertFieldsForClient(request,response);
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
			searchClientProfile(request, response);
			response.sendRedirect("client/clientProfile.jsp"); 
		}
		
		if(flag.equals("changePassword"))
		{
			changePassword(request, response);
		}
		
		if(flag.equals("changeImage"))
		{
			changeImage(request, response);
			searchClientProfile(request, response);
			response.sendRedirect("client/clientProfile.jsp");
		}
	}

	private void changeImage(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException 
	{
		HttpSession session = request.getSession();
		long loginId1 = (Long)session.getAttribute("userID");
		int loginId = (int)loginId1;
		
		LoginVO loginVO = new LoginVO();
		loginVO.setLoginId(loginId);
		
		ClientRegisterDAO clientRegisterDAO = new ClientRegisterDAO();
		List ls = clientRegisterDAO.searchClientProfile(loginVO);
		ClientRegisterVO lsObj = (ClientRegisterVO)ls.get(0);
		
		int registerId = lsObj.getRegisterId();
		String firstName = lsObj.getFirstName();
		String lastName = lsObj.getLastName();
		String mobileNumber = lsObj.getMobileNumber();
		int stateId = lsObj.getStateVO().getStateId();
		int cityId = lsObj.getCityVO().getCityId();
		int areaId = lsObj.getAreaVO().getAreaId();
		String address = lsObj.getAddress();
		
		ClientRegisterVO registerVO = new ClientRegisterVO();
	
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
		
		clientRegisterDAO.updateProfileImage(registerVO);
		
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
			response.sendRedirect("client/index.jsp");
		}
		else
		{
			response.sendRedirect("client/changePassword.jsp");
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
		String address = request.getParameter("address");
		String fileName = request.getParameter("fileName");
		String filePath = request.getParameter("filePath");
		int loginId = Integer.parseInt(request.getParameter("loginId"));
		
		ClientRegisterVO registerVO = new ClientRegisterVO();
		
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
		registerVO.setFileName(fileName);
		registerVO.setFilePath(filePath);
		
		LoginVO loginVO = new LoginVO();
		loginVO.setLoginId(loginId);
		registerVO.setLoginVO(loginVO);
		
		ClientRegisterDAO clientRegisterDAO = new ClientRegisterDAO();
		clientRegisterDAO.editProfile(registerVO);
		
	}

	private void insertFieldsForClient(HttpServletRequest request,
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
		String password = request.getParameter("password");
		
		ClientRegisterVO registerVO = new ClientRegisterVO();
		
		registerVO.setFirstName(firstName);
		registerVO.setLastName(lastName);
		
		LoginVO loginVO = new LoginVO();
		LoginDAO loginDAO = new LoginDAO();
		
		loginVO.setEmail(email);
		
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
		
		loginVO.setPassword(password);
		
		loginVO.setRole("Client");
		
		ClientRegisterDAO registerDAO = new ClientRegisterDAO();
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
		
		registerDAO.insertFieldsForClient(registerVO);
		
	}

}
