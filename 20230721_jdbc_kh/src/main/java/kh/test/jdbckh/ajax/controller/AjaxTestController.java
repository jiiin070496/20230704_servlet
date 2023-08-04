package kh.test.jdbckh.ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ajax1")
public class AjaxTestController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ajax1 doGet");
		String n1 = request.getParameter("n1");
		String n2 = request.getParameter("n2");
		System.out.println("n1: "+n1);
		System.out.println("n2: "+n2);
		//jsp로 데이터 전달
		//out은 브라우저화면 디스플레이 용도였으나 지금은 ajax 데이터 전달용으로 사용됨.
		//js는 setAtt 사용불가. js가 인지할 수 있는 자료형으로 전달해야함.
		PrintWriter out = response.getWriter();
//		out.print("jsp로 전달");
		out.print("[냄쿵 ajax 성공]");
		out.flush();
		out.close();
//		request.getRequestDispatcher("/WEB-INF/view/").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ajax1 doPost");
		String n1 = request.getParameter("n1");
		String n2 = request.getParameter("n2");
		System.out.println("n1: "+n1);
		System.out.println("n2: "+n2);
	}

}
