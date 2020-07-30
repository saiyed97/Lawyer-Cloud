package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.StateDAO;
import VO.StateVO;

/**
 * Servlet implementation class StateController
 */
@WebServlet("/StateController")
public class StateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String flag = request.getParameter("flag");
		
		if(flag.equals("loadState"))
		{
			searchState(request,response);
			response.sendRedirect("admin/addCity.jsp");
		}
		
		if(flag.equals("searchState"))
		{
			searchState(request,response);
			response.sendRedirect("admin/viewState.jsp");
		}
		
		if(flag.equals("deleteState"))
		{
			deleteState(request,response);
			searchState(request,response);
			response.sendRedirect("admin/viewState.jsp");
		}
		
		if(flag.equals("editState"))
		{
			editState(request,response);
			response.sendRedirect("admin/editState.jsp");
		}
	}

	private void searchState(HttpServletRequest request, HttpServletResponse response)
	{
		StateDAO stateDAO = new StateDAO();
		List stateList = stateDAO.searchState();
		
		HttpSession session = request.getSession();
		session.setAttribute("stateList", stateList);
	}
	
	private void deleteState(HttpServletRequest request, HttpServletResponse response)
	{
		int stateId = Integer.parseInt(request.getParameter("stateId"));
		
		StateVO stateVO = new StateVO();
		stateVO.setStateId(stateId);
		
		StateDAO stateDAO = new StateDAO();
		stateDAO.deleteState(stateVO);
	}
	
	private void editState(HttpServletRequest request, HttpServletResponse response)
	{
		int stateId = Integer.parseInt(request.getParameter("stateId"));

		StateVO stateVO = new StateVO();
		stateVO.setStateId(stateId);
		
		StateDAO stateDAO = new StateDAO(); 
		List editStateList = stateDAO.editState(stateVO);
		
		HttpSession session = request.getSession();
		session.setAttribute("editStateList", editStateList); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		
		String flag = request.getParameter("flag");
		
		if(flag.equals("addState"))
		{
			insertState(request,response);
			response.sendRedirect("admin/addState.jsp");
		}
		
		if(flag.equals("updateState"))
		{
			updateState(request,response);
			searchState(request, response);
			response.sendRedirect("admin/viewState.jsp");
		}
	}
	
	private void updateState(HttpServletRequest request,
			HttpServletResponse response) 
	{
		int stateId = Integer.parseInt(request.getParameter("stateId"));
		String stateName = request.getParameter("stateName");
		
		StateVO stateVO = new StateVO();
		stateVO.setStateId(stateId);
		stateVO.setStateName(stateName);
		
		StateDAO stateDAO  = new StateDAO();
		stateDAO.updateState(stateVO);
	}

	protected void insertState(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String stateName = request.getParameter("stateName");
		
		StateVO stateVO = new StateVO();
		
		stateVO.setStateName(stateName);
		
		StateDAO stateDAO = new StateDAO();
		stateDAO.insertState(stateVO);
	}
}
