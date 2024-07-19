package controller;

import java.io.IOException;

import common.JSFunction;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.HSmemberDAO;
import model.HSmemberDTO;

@WebServlet("/HS/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/* 로그인 페이지 진입 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
											throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		if (session.getAttribute("userId") != null) {
			resp.sendRedirect("../HS/islogin.do");
		}
		else {
			req.getRequestDispatcher("/Project_HS/Login.jsp").forward(req, resp);	
		}		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
											throws ServletException, IOException {
		
		// 로그인 폼에서 전송한 폼 값 받기
		String userId = req.getParameter("user_id");
		String userPwd = req.getParameter("user_pwd");
		// DB 연결
		HSmemberDAO dao = new HSmemberDAO();

		HSmemberDTO dto = dao.loginMember(userId, userPwd);
		dao.close();
		
		if (dto.getId() != null ) {
			HttpSession session = req.getSession();
			session.setAttribute("userId", dto.getId());
			session.setAttribute("userPwd", dto.getPass());
			session.setAttribute("userName", dto.getName());
			session.setAttribute("userEmail", dto.getEmail());
			session.setAttribute("userPhone", dto.getPhone());
			
			System.out.println("Session userId: " + session.getAttribute("userId"));
	        System.out.println("Session userPwd: " + session.getAttribute("userPwd"));
	        System.out.println("Session userName: " + session.getAttribute("userName"));
			
			resp.sendRedirect("../HS/islogin.do");
		}
		else {
			JSFunction.alertBack(resp, "아이디와 비밀번호를 다시 입력해주세요.");
		}
		
	}
	

}
