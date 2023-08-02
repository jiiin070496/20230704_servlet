package kh.test.jdbckh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.jdbckh.member.model.dto.Member;
import kh.test.jdbckh.member.model.service.MemberService;

/**
 * Servlet implementation class LoginDoServlet
 */
@WebServlet("/login.login")
public class LoginDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[냄쿵]login.login post");
		String mid = request.getParameter("mid");
		String mpwd = request.getParameter("mpwd");
		Member vo = new Member(mid, mpwd);
		String result =  new MemberService().login(mid);
		String sendUrl =  request.getContextPath();
		// TODO session
		
		if(mpwd == null) {
			//아이디가 존재하지 않습니다
		} else if(mpwd.equals(result)) {
			System.out.println("로그인 성공");
			request.setAttribute("SsLoginId", mid);
			request.getSession().setAttribute("successMsg", "로그인성공");
			request.getSession().setAttribute("SsLoginId", mid);
			sendUrl += "/board/list"; 
		} else {
			System.out.println("로그인 실패");
			request.getSession().setAttribute("failMsg", "로그인 실패하였습니다.");
			sendUrl += "/error";
		}
		response.sendRedirect(sendUrl);
	}

}
