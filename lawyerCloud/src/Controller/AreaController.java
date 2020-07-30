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
import VO.CityVO;
import VO.StateVO;
import DAO.AreaDAO;
import DAO.CityDAO;
import DAO.StateDAO;

/**
 * Servlet implementation class AreaController
 */
@WebServlet("/AreaController")
public class AreaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AreaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String flag = request.getParameter("flag");
		
		if(flag.equals("loadStateAndCity"))
		{
			searchStateAndCity(request,response);
			response.sendRedirect("admin/addArea.jsp");
		}
		
		if(flag.equals("searchArea"))
		{
			searchArea(request,response);
			response.sendRedirect("admin/viewArea.jsp");
		}
		
		if(flag.equals("deleteArea"))
		{
			deleteArea(request,response);
			searchArea(request, response);
			response.sendRedirect("admin/viewArea.jsp");
		}
		
		if(flag.equals("editArea"))
		{
			editArea(request,response);
			response.sendRedirect("admin/editArea.jsp");
		}
	}

	private void editArea(HttpServletRequest request,
			HttpServletResponse response) 
	{
		int areaId = Integer.parseInt(request.getParameter("areaId"));

		AreaVO areaVO = new AreaVO();
		areaVO.setAreaId(areaId);
		
		AreaDAO areaDAO = new AreaDAO(); 
		List areaList = areaDAO.editArea(areaVO);
		
		CityDAO  cityDAO = new CityDAO();
		List cityList = cityDAO.search();
		
		StateDAO  stateDAO = new StateDAO();
		List stateList = stateDAO.searchState();
		
		HttpSession session = request.getSession();
		session.setAttribute("areaList", areaList);
		session.setAttribute("cityList", cityList);
		session.setAttribute("stateList", stateList);
	}

	private void deleteArea(HttpServletRequest request,
			HttpServletResponse response) 
	{
		int areaId = Integer.parseInt(request.getParameter("areaId"));
		
		AreaVO areaVO = new AreaVO();
		areaVO.setAreaId(areaId);
		
		AreaDAO areaDAO = new AreaDAO();
		areaDAO.deleteArea(areaVO);
		
	}

	private void searchArea(HttpServletRequest request,
			HttpServletResponse response) 
	{
		
		AreaDAO areaDAO = new AreaDAO();
		List areaList = areaDAO.searchArea();
		
		HttpSession session = request.getSession();
		session.setAttribute("areaList", areaList);
	}

	private void searchStateAndCity(HttpServletRequest request,
			HttpServletResponse response)
	{
		StateDAO stateDAO = new StateDAO();
		stateDAO.searchState();
		List stateList = stateDAO.searchState();
		HttpSession session = request.getSession();
		session.setAttribute("stateList", stateList);
		
		CityDAO cityDAO = new CityDAO();
		cityDAO.search();
		List cityList = cityDAO.search();
		session.setAttribute("cityList", cityList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String flag = request.getParameter("flag");
		
		if(flag.equals("insertArea"))
		{
			insertArea(request,response);
			response.sendRedirect("admin/addArea.jsp");
		}
		
		if(flag.equals("updateArea"))
		{
			updateArea(request,response);
			searchArea(request, response);
			response.sendRedirect("admin/viewArea.jsp");
		}
	}

	private void updateArea(HttpServletRequest request,
			HttpServletResponse response) 
	{
	
		int stateId = Integer.parseInt(request.getParameter("stateName"));
		
		int cityId = Integer.parseInt(request.getParameter("cityName"));
		
		int areaId = Integer.parseInt(request.getParameter("areaId"));
		
		String areaName = request.getParameter("areaName");
		AreaVO areaVO = new AreaVO();
		areaVO.setAreaId(areaId);
		areaVO.setAreaName(areaName);
		
		StateVO stateVO = new StateVO();
		stateVO.setStateId(stateId);
		
		CityVO cityVO = new CityVO();
		cityVO.setCityId(cityId);
		
		areaVO.setCityVO(cityVO);
		areaVO.setStateVO(stateVO);
		
		AreaDAO areaDAO  = new AreaDAO();
		areaDAO.updateArea(areaVO);
	}

	private void insertArea(HttpServletRequest request,
			HttpServletResponse response) 
	{
		
		String areaName = request.getParameter("areaName");
		
		int stateId = Integer.parseInt(request.getParameter("stateName"));
		
		int cityId = Integer.parseInt(request.getParameter("cityName"));
		
		AreaVO areaVO = new AreaVO();
		areaVO.setAreaName(areaName);
		
		StateVO stateVO = new StateVO();
		stateVO.setStateId(stateId);
		areaVO.setStateVO(stateVO);
		
		CityVO cityVO = new CityVO();
		cityVO.setCityId(cityId);
		areaVO.setCityVO(cityVO);
		
		AreaDAO areaDAO = new AreaDAO();
		areaDAO.insertArea(areaVO);
		
	}

}
