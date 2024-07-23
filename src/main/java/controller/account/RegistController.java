package controller.account;

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

@WebServlet("/HS/regist.do")
public class RegistController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
											throws ServletException, IOException {

		 HttpSession session = req.getSession();
		 
		 // 로그인 안되어있을 때만 회원가입 페이지로
		 if (session.getAttribute("userId") == null) {
			 req.getRequestDispatcher("/Project_HS/Account/Regist.jsp").forward(req, resp);			 
		 }
		 else {
			 JSFunction.alertBack(resp, "로그아웃 후 이용해주세요.");
		 }
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
											throws ServletException, IOException {
		
		HSmemberDAO dao = new HSmemberDAO();

		String userId = req.getParameter("user_id");
		String userPwd = req.getParameter("user_pwd");
		String userName = req.getParameter("user_name");
		String userEmail = req.getParameter("user_email");
		String userPhone = req.getParameter("user_phone");
		
		HSmemberDTO dto = new HSmemberDTO();
		dto.setId(userId);
		dto.setPass(userPwd);
		dto.setName(userName);
		dto.setEmail(userEmail);
		dto.setPhone(userPhone);
		
		
		boolean isRegist = dao.registMember(dto);
		
		if (isRegist) {
			resp.sendRedirect(req.getContextPath() + "/HS/login.do");
			System.out.println("회원 등록 성공: " + userId);
		}
		else {
			req.getRequestDispatcher("/HS/regist.do").forward(req, resp);
			
		}
	}

}