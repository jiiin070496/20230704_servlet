package kh.lclass.test1.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("login get 진입");
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("login post 진입");
		
		//DB 확인하고 오기.
int result = 1; // 0이면 저잗실패, 1이면 저장성공
		
		if(result > 0) {
			//DB에 잘 저장했다면
			//로그인 화면으로 이동
			//메인 화면으로 이동
			response.sendRedirect(request.getContextPath()+"/index"); //ContextPath 꼭 있어야함!
		}else {
		//DB에 저장하지 못했다면
			//경고창 띄우고 main 화면으로 이동
		}
	}

	}


