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

@WebServlet("/HS/modify.do")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
											throws ServletException, IOException {

		
		HttpSession session = req.getSession(false);
		
		// 로그인 되어있으면
		if (session.getAttribute("userId") != null) {
			// 회원정보 수정 페이지로
			req.getRequestDispatcher("/Project_HS/Account/Modify.jsp").forward(req, resp);
		}
		// 로그인 안되어있으면
		else {
			JSFunction.alertBack(resp, "로그인이 필요한 서비스입니다.");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
											throws ServletException, IOException {
	
		HttpSession session = req.getSession(false);
		
		// 로그인 되어있으면
		if (session.getAttribute("userId") != null) {
			
			String newId = (String) session.getAttribute("userId");
			String newPwd = req.getParameter("user_pwd");
			String newName = req.getParameter("user_name");
			String newEmail = req.getParameter("user_email");
			String newPhone = req.getParameter("user_phone");

			// 수정 요청이 있으면
			String modify = req.getParameter("modify");
			if (modify != null && modify.equals("true")) {
				
				HSmemberDTO dto = new HSmemberDTO();
				dto.setId(newId);
				dto.setPass(newPwd);
				dto.setName(newName);
				dto.setEmail(newEmail);
				dto.setPhone(newPhone);
				
				session.setAttribute("userId", newId);
				session.setAttribute("userPwd", newPwd);
				session.setAttribute("userName", newName);
				session.setAttribute("userEmail", newEmail);
				session.setAttribute("userPhone", newPhone);
				
				HSmemberDAO dao = new HSmemberDAO();
				boolean isModify = dao.modifyMember(dto);
				
				if (isModify) {
					resp.sendRedirect("../Project_HS/Account/IsLogin.jsp");
					System.out.println("회원정보 수정 성공: " + newId);
				}
				else {
					req.getRequestDispatcher("../Project_HS/Account/Modify.jsp").forward(req, resp);
					System.out.println("회원정보 수정 중 예외 발생");
				}
			}
		}
	}
}