package kh.test.jdbckh.department.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.jdbckh.department.model.vo.DepartmentDto;
import kh.test.jdbckh.student.model.service.StudentService;
import kh.test.jdbckh.department.model.service.DepartmentService;

/**
 * Servlet implementation class DepartmentListServlet
 */
@WebServlet("/dept/list")
public class DepartmentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
//	private final int PAGE_SIZE = 10;
//	private final int PAGE_BLOCK = 5;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchWord = request.getParameter("searchWord");
		String pageNoStr = request.getParameter("pageNo");
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(pageNoStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		DepartmentService service = new DepartmentService();
		List<DepartmentDto> deptList = service.selectList(currentPage, pageSize, searchWord);
		request.setAttribute("deptList", deptList);

		
//		DepartmentService service = new DepartmentService();
//		List<DepartmentDto> deptList = service.selectList();
//		request.setAttribute("deptList", deptList);
//		request.getRequestDispatcher("/WEB-INF/view/dept/list.jsp").forward(request, response);
	}


//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}

}
