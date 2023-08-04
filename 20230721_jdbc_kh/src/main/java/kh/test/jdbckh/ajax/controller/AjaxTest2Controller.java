package kh.test.jdbckh.ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kh.test.jdbckh.department.model.service.DepartmentService;
import kh.test.jdbckh.department.model.vo.DepartmentDto;


@WebServlet("/ajax2")
public class AjaxTest2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ajax2 doGet!!!!");
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ajax2 doPost!!!!");
		PrintWriter out = response.getWriter();
		List<DepartmentDto> deptList = new DepartmentService().selectList();
		Gson gson = new Gson();
//		String gsonDeptList = gson.toJson(deptList);
//		System.out.println(gsonDeptList);
		
		PrintWriter out1 = response.getWriter();
//		out.print("[냄궁 ajax2 성공!!]");
//		out.print("{\"k1\":\"zzz\", \"k2\":\"7761\"}");
		out1.print(gson.toJson(deptList));
		out1.flush();
		out1.close();
	}

}
