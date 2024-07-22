package controller.account;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.HSmemberDAO;
import model.HSmemberDTO;

@WebServlet("/HS/regist.do")
public class RegistController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
											throws ServletException, IOException {

		req.getRequestDispatcher("/Project_HS/Account/Regist.jsp").forward(req, resp);
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