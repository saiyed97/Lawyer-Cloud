package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AreaDAO;
import DAO.CategoryDAO;
import DAO.CityDAO;
import DAO.StateDAO;
import DAO.SubCategoryDAO;
import VO.AreaVO;
import VO.CategoryVO;
import VO.CityVO;
import VO.StateVO;
import VO.SubCategoryVO;

/**
 * Servlet implementation class CityController
 */
@WebServlet("/CityController")
public class CityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CityController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		String flag = request.getParameter("flag");
		
		if(flag.equals("searchCity"))
		{
			searchCity(request,response);
			response.sendRedirect("admin/viewCity.jsp");
		}
		
		if(flag.equals("deleteCity"))
		{
			deleteCity(request,response);
			searchCity(request,response);
			response.sendRedirect("admin/viewCity.jsp");
		}
		if(flag.equals("editCity"))
		{
			editCity(request,response);
			response.sendRedirect("admin/editCity.jsp");
		}

		if (flag.equals("selCity") || flag.equals("selectCity"))
		{
			System.out.println("ENTERY SUCCESS : SEARCH CITY BY STATE ID : CONTROLLER");
			int stateId = Integer.parseInt(request.getParameter("stateId"));
			HttpSession s= request.getSession();
			
			
			CityDAO cityDAO = new CityDAO();
			StateDAO stateDAO=new StateDAO();
			
			StateVO stateVO = new StateVO();
			CityVO cityVO = new CityVO();
			
			stateVO.setStateId(stateId);
			cityVO.setStateVO(stateVO);
			List ls=cityDAO.searchCity(cityVO);
			
			s.setAttribute("data",ls );
			System.out.println("EXIT SUCCESS : SEARCH CITY BY STATE ID : CONTROLLER");
				response.sendRedirect("admin/jsoncity.jsp");
			
		}
		
		if (flag.equals("selCityClient"))
		{
			System.out.println("ENTERY SUCCESS : SEARCH CITY BY STATE ID : CONTROLLER");
			int stateId = Integer.parseInt(request.getParameter("stateId"));
			HttpSession s= request.getSession();
			System.out.println("stateId>>"+stateId);
			
			CityDAO cityDAO = new CityDAO();
			StateDAO stateDAO=new StateDAO();
			
			StateVO stateVO = new StateVO();
			CityVO cityVO = new CityVO();
			
			stateVO.setStateId(stateId);
			cityVO.setStateVO(stateVO);
			List ls=cityDAO.searchCity(cityVO);
			
			s.setAttribute("data",ls );
			System.out.println("EXIT SUCCESS : SEARCH CITY BY STATE ID : CONTROLLER");
				response.sendRedirect("client/jsoncity.jsp");
			
		}
		
		
		if (flag.equals("selArea"))
		{
			System.out.println("ENTERY SUCCESS : SEARCH AREA BY CITY ID : CONTROLLER");
			int cityId = Integer.parseInt(request.getParameter("cityId"));
			HttpSession s= request.getSession();
			System.out.println("cityId>>"+cityId);
			AreaDAO	areaDAO = new AreaDAO();
			CityDAO cityDAO = new CityDAO();
			
			AreaVO areaVO = new AreaVO();
			CityVO cityVO = new CityVO();
			
			cityVO.setCityId(cityId);
			areaVO.setCityVO(cityVO);
			List ls=areaDAO.searchAreaAjax(areaVO);
			
			s.setAttribute("data",ls );
			System.out.println("EXIT SUCCESS : SEARCH AREA BY CITY ID : CONTROLLER");
				response.sendRedirect("client/jsonArea.jsp");
				
		}
		
		if (flag.equals("selSubCategoryClient"))
		{
			System.out.println("ENTERY SUCCESS : SEARCH AREA BY CITY ID : CONTROLLER");
			int categoryId = Integer.parseInt(request.getParameter("categoryId"));
			HttpSession s= request.getSession();
			System.out.println("categoryId>>"+categoryId);
			SubCategoryDAO	subCategoryDAO = new SubCategoryDAO();
			CategoryDAO categoryDAO = new CategoryDAO();
			
			SubCategoryVO subCategoryVO = new SubCategoryVO();
			CategoryVO categoryVO = new CategoryVO();
			
			categoryVO.setCategoryId(categoryId);
			subCategoryVO.setCategoryVO(categoryVO);
			List ls=subCategoryDAO.searchSubCategoryAjax(subCategoryVO);
			
			s.setAttribute("data",ls );
			System.out.println("EXIT SUCCESS : SEARCH AREA BY CITY ID : CONTROLLER");
				response.sendRedirect("client/jsonSubCategory.jsp");
			
		}
		
		
		
	}
	private void editCity(HttpServletRequest request, HttpServletResponse response)
	{
		int cityId = Integer.parseInt(request.getParameter("cityId")); 
		
		CityVO cityVO = new CityVO();
		cityVO.setCityId(cityId);
		
		CityDAO cityDAO = new CityDAO(); 
		List editCityList = cityDAO.editCity(cityVO);
		
		StateDAO  stateDAO = new StateDAO();
		List editStateList = stateDAO.searchState();
		HttpSession session = request.getSession();
		session.setAttribute("editCityList", editCityList);
		session.setAttribute("editStateList", editStateList);
	}

	private void deleteCity(HttpServletRequest request,
			HttpServletResponse response) 
	{
		int cityId = Integer.parseInt(request.getParameter("cityId"));
		
		CityVO cityVO = new CityVO();
		cityVO.setCityId(cityId);
		
		CityDAO cityDAO = new CityDAO();
		cityDAO.deleteCity(cityVO);
		
	}

	private void searchCity(HttpServletRequest request,
			HttpServletResponse response) 
	{
		
		CityDAO cityDAO = new CityDAO();
		List cityList = cityDAO.search();
		
		HttpSession session = request.getSession();
		session.setAttribute("cityList", cityList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String flag = request.getParameter("flag");
		
		if(flag.equals("insertCity"))
		{
			insertCity(request,response);
			response.sendRedirect("admin/addCity.jsp");
		}
		
		if(flag.equals("updateCity"))
		{
			updateCity(request,response);
			searchCity(request, response);
			response.sendRedirect("admin/viewCity.jsp");
		}
	}
	
	private void updateCity(HttpServletRequest request,
			HttpServletResponse response) 
	{
		int stateId = Integer.parseInt(request.getParameter("stateName"));
		int cityId = Integer.parseInt(request.getParameter("cityId"));
		
		StateVO stateVO = new StateVO();
		stateVO.setStateId(stateId);
		
		String cityName = request.getParameter("cityName");
		
		CityVO cityVO = new CityVO();
		cityVO.setCityId(cityId);
		cityVO.setCityName(cityName);
		cityVO.setStateVO(stateVO);
		
		CityDAO cityDAO  = new CityDAO();
		cityDAO.updateCity(cityVO);
	}

	private void insertCity(HttpServletRequest request,
			HttpServletResponse response)
	{
		int stateId = Integer.parseInt(request.getParameter("stateName"));
		
		String cityName = request.getParameter("cityName");
		
		CityVO cityVO = new CityVO();
		cityVO.setCityName(cityName);
		
		StateVO stateVO = new StateVO();
		stateVO.setStateId(stateId);
		cityVO.setStateVO(stateVO);
		
		CityDAO cityDAO = new CityDAO();
		cityDAO.insertCity(cityVO);
	}
	
	

}
