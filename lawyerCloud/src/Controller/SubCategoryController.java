package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CategoryDAO;
import DAO.CityDAO;
import DAO.StateDAO;
import DAO.SubCategoryDAO;
import VO.CategoryVO;
import VO.CityVO;
import VO.StateVO;
import VO.SubCategoryVO;

/**
 * Servlet implementation class SubCategoryController
 */
@WebServlet("/SubCategoryController")
public class SubCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubCategoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String flag = request.getParameter("flag");
		
		if(flag.equals("searchSubCategory"))
		{
			searchSubCategory(request,response);
			response.sendRedirect("admin/viewSubCategory.jsp");
		}
		
		if(flag.equals("deleteSubCategory"))
		{
			deleteSubCategory(request,response);
			searchSubCategory(request,response);
			response.sendRedirect("admin/viewSubCategory.jsp");
		}
		
		if(flag.equals("editSubCategory"))
		{
			editSubCategory(request,response);
			response.sendRedirect("admin/editSubCategory.jsp");
		}
		
	}

	private void editSubCategory(HttpServletRequest request,
			HttpServletResponse response) 
	{
		int subCategoryId = Integer.parseInt(request.getParameter("subCategoryId")); 
		
		SubCategoryVO subCategoryVO = new SubCategoryVO();
		subCategoryVO.setSubCategoryId(subCategoryId);
		
		SubCategoryDAO subCategoryDAO = new SubCategoryDAO(); 
		List editSubCategoryList = subCategoryDAO.editSubCategory(subCategoryVO);
		
		CategoryDAO  categoryDAO = new CategoryDAO();
		List editCategoryList = categoryDAO.searchCategory();
		
		HttpSession session = request.getSession();
		session.setAttribute("editSubCategoryList", editSubCategoryList);
		session.setAttribute("editCategoryList", editCategoryList);
		
	}

	private void deleteSubCategory(HttpServletRequest request,
			HttpServletResponse response) 
	{
		int subCategoryId = Integer.parseInt(request.getParameter("subCategoryId"));
		
		SubCategoryVO subCategoryVO = new SubCategoryVO();
		subCategoryVO.setSubCategoryId(subCategoryId);
		
		SubCategoryDAO subCategoryDAO = new SubCategoryDAO();
		subCategoryDAO.deleteSubCategory(subCategoryVO);
		
	}

	private void searchSubCategory(HttpServletRequest request,
			HttpServletResponse response) 
	{
		
		SubCategoryDAO subCategoryDAO = new SubCategoryDAO();
		List subCategoryList = subCategoryDAO.searchSubCategory();
		
		HttpSession session = request.getSession();
		session.setAttribute("subCategoryList", subCategoryList);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String flag = request.getParameter("flag");
		
		if(flag.equals("insertSubCategory"))
		{
			insertSubCategory(request,response);
			response.sendRedirect("admin/addSubCategory.jsp");
		}
		
		if(flag.equals("updateSubCategory"))
		{
			updateSubCategory(request,response);
			searchSubCategory(request, response);
			response.sendRedirect("admin/viewSubCategory.jsp");
		}
	}

	private void updateSubCategory(HttpServletRequest request,
			HttpServletResponse response) 
	{
		
		int categoryId = Integer.parseInt(request.getParameter("categoryName"));
		int subCategoryId = Integer.parseInt(request.getParameter("subCategoryId"));
		
	    CategoryVO categoryVO = new CategoryVO();
		categoryVO.setCategoryId(categoryId);
		
		SubCategoryVO subCategoryVO = new SubCategoryVO();
		subCategoryVO.setSubCategoryId(subCategoryId);
		
		String subCategoryName = request.getParameter("subCategoryName");
		subCategoryVO.setSubCategoryName(subCategoryName);
		subCategoryVO.setCategoryVO(categoryVO);
		
		SubCategoryDAO subCategoryDAO  = new SubCategoryDAO();
		subCategoryDAO.updateSubCategory(subCategoryVO);
		
	}

	private void insertSubCategory(HttpServletRequest request,
			HttpServletResponse response) 
	{
		int categoryId = Integer.parseInt(request.getParameter("categoryName"));
		
		String subCategoryName = request.getParameter("subCategoryName");
		
		SubCategoryVO subCategoryVO = new SubCategoryVO();
		subCategoryVO.setSubCategoryName(subCategoryName);
		
		CategoryVO categoryVO = new CategoryVO();
		categoryVO.setCategoryId(categoryId);
		subCategoryVO.setCategoryVO(categoryVO);
		
		SubCategoryDAO subCategoryDAO = new SubCategoryDAO();
		subCategoryDAO.insertSubCategory(subCategoryVO);
	}

}
