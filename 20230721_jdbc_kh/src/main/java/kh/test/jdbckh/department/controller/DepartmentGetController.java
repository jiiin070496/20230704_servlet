package kh.test.jdbckh.department.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.jdbckh.department.model.dao.DepartmentDao;
import kh.test.jdbckh.department.model.vo.DepartmentVo;

/**
 * Servlet implementation class DepartmentGetController
 */
@WebServlet("/department/dget")
public class DepartmentGetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentGetController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String DepartmentNo = request.getParameter("dno");
		DepartmentDao dao = new DepartmentDao();
		DepartmentVo vo = dao.selectOneDepartment(DepartmentNo);
	
		request.setAttribute("dvo", vo);		
		request.getRequestDispatcher("/WEB-INF/view/department/dget.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
