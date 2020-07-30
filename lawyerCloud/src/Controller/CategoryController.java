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
import DAO.StateDAO;
import VO.CategoryVO;
import VO.StateVO;

/**
 * Servlet implementation class CategoryController
 */
@WebServlet("/CategoryController")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String flag = request.getParameter("flag");
		
		if(flag.equals("searchCategory"))
		{
			searchCategory(request,response);
			response.sendRedirect("admin/viewCategory.jsp");
		}
		
		if(flag.equals("deleteCategory"))
		{
			deleteCategory(request,response);
			searchCategory(request,response);
			response.sendRedirect("admin/viewCategory.jsp");
		}
		
		if(flag.equals("editCategory"))
		{
			editCategory(request,response);
			response.sendRedirect("admin/editCategory.jsp");
		}
		
		if(flag.equals("loadCategory"))
		{
			searchCategory(request,response);
			response.sendRedirect("admin/addSubCategory.jsp");
		}
	}
	
	private void searchCategory(HttpServletRequest request, HttpServletResponse response)
	{
		CategoryDAO categoryDAO = new CategoryDAO();
		List categoryList = categoryDAO.searchCategory();
		HttpSession session = request.getSession();
		session.setAttribute("categoryList", categoryList);
	}
	
	private void deleteCategory(HttpServletRequest request, HttpServletResponse response)
	{
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		
		CategoryVO categoryVO = new CategoryVO();
		
		categoryVO.setCategoryId(categoryId);
		
		CategoryDAO categoryDAO = new CategoryDAO();
		
		categoryDAO.deleteCategory(categoryVO);
	}
	
	private void editCategory(HttpServletRequest request, HttpServletResponse response)
	{
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));

		CategoryVO categoryVO = new CategoryVO();
		categoryVO.setCategoryId(categoryId);
		
		CategoryDAO categoryDAO = new CategoryDAO(); 
		List editCategoryList = categoryDAO.editCategory(categoryVO);
		
		HttpSession session = request.getSession();
		session.setAttribute("editCategoryList", editCategoryList); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String flag = request.getParameter("flag");
		
		if(flag.equals("addCategory"))
		{
			insertCategory(request,response);
			response.sendRedirect("admin/addCategory.jsp");
		}
		
		if(flag.equals("updateCategory"))
		{
			updateCategory(request,response);
			searchCategory(request, response);
			response.sendRedirect("admin/viewCategory.jsp");
		}
	}
	
	private void updateCategory(HttpServletRequest request,
			HttpServletResponse response) 
	{
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		String categoryName = request.getParameter("categoryName");
		
		CategoryVO categoryVO = new CategoryVO();
		categoryVO.setCategoryId(categoryId);
		categoryVO.setCategoryName(categoryName);
		
		CategoryDAO categoryDAO  = new CategoryDAO();
		categoryDAO.updateCategory(categoryVO);
	}

	protected void insertCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String categoryName = request.getParameter("categoryName");
		
		CategoryVO categoryVO = new CategoryVO();
		
		categoryVO.setCategoryName(categoryName);
		
		CategoryDAO categoryDAO = new CategoryDAO();
		categoryDAO.insertCategory(categoryVO);
	}
}
