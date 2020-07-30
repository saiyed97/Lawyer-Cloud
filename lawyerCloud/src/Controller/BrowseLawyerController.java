package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import VO.AreaVO;
import VO.CategoryVO;
import VO.CityVO;
import VO.LawyerRegisterVO;
import VO.StateVO;
import DAO.AreaDAO;
import DAO.CategoryDAO;
import DAO.CityDAO;
import DAO.LawyerRegisterDAO;
import DAO.StateDAO;
import DAO.SubCategoryDAO;

/**
 * Servlet implementation class BrowseLawyer
 */
@WebServlet("/BrowseLawyerController")
public class BrowseLawyerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BrowseLawyerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String flag=request.getParameter("flag");
		
		if(flag.equals("browseLawyerByDetails"))
		{
			searchLawyerByDetails(request,response);
			response.sendRedirect("client/browseLawyer.jsp"); 
		}
		
		if(flag.equals("loadLawyers"))
		{
			searchLawyersByGroup(request,response);
			response.sendRedirect("user/lawyers.jsp"); 
		}
	}

	private void searchLawyersByGroup(HttpServletRequest request,
			HttpServletResponse response) 
	{
		HttpSession session = request.getSession();
		
		LawyerRegisterVO lawyerRegisterVO = new LawyerRegisterVO();
		
		LawyerRegisterDAO lawyerRegisterDAO = new LawyerRegisterDAO();
		
		List lawyerList = lawyerRegisterDAO.searchLawyersByGroup(lawyerRegisterVO);
		
		session.setAttribute("lawyerList", lawyerList);
		
	}

	private void searchLawyerByDetails(HttpServletRequest request,
			HttpServletResponse response) 
	{
		HttpSession session = request.getSession();
		
		StateDAO stateDAO = new StateDAO();
		List stateList = stateDAO.searchState();
		
		CityDAO cityDAO = new CityDAO();
		List cityList = cityDAO.search();
		
		AreaDAO areaDAO = new AreaDAO();
		List areaList = areaDAO.searchArea();
		
		CategoryDAO categoryDAO = new CategoryDAO();
		List categoryList = categoryDAO.searchCategory();
		
		session.setAttribute("stateList", stateList);
		session.setAttribute("cityList", cityList);
		session.setAttribute("areaList", areaList);
		session.setAttribute("categoryList", categoryList);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String flag=request.getParameter("flag");
		
		if(flag.equals("searchLawyer"))
		{
			searchLawyerForClient(request,response);
			response.sendRedirect("client/browseLawyer.jsp"); 
		}
	}

	private void searchLawyerForClient(HttpServletRequest request,
			HttpServletResponse response) 
	{
		Integer stateId = Integer.parseInt(request.getParameter("stateName"));
		Integer cityId = Integer.parseInt(request.getParameter("cityName"));
		Integer areaId = Integer.parseInt(request.getParameter("areaName"));
		Integer categoryId = Integer.parseInt(request.getParameter("categoryName"));
		
		StateVO stateVO = new StateVO();
		CityVO cityVO = new CityVO();
		AreaVO areaVO = new AreaVO();
		CategoryVO categoryVO = new CategoryVO();
		
		stateVO.setStateId(stateId);
		cityVO.setCityId(cityId);
		areaVO.setAreaId(areaId);
		categoryVO.setCategoryId(categoryId);
		
		LawyerRegisterVO lawyerRegisterVO = new LawyerRegisterVO();
		
		lawyerRegisterVO.setStateVO(stateVO);
		lawyerRegisterVO.setCityVO(cityVO);
		lawyerRegisterVO.setAreaVO(areaVO);
		lawyerRegisterVO.setCategoryVO(categoryVO);
		
		LawyerRegisterDAO lawyerRegisterDAO = new LawyerRegisterDAO();
		List lawyerList = lawyerRegisterDAO.searchLawyerForClient(lawyerRegisterVO);
		
		HttpSession session = request.getSession();
		session.setAttribute("lawyerList", lawyerList);
	}

}
