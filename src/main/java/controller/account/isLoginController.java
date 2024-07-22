package controller.account;

import java.io.IOException;

import common.JSFunction;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/HS/islogin.do")
public class isLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
	                                      throws ServletException, IOException {
		 
	        HttpSession session = req.getSession(false);

	        // 로그인 되어있으면
	        if (session.getAttribute("userId") != null) {

	            // 로그아웃 요청이 있었는지 확인
	            String logout = req.getParameter("logout");
	            if (logout != null && logout.equals("true")) {
	            	// 세션 무효화 (세션에 저장된 정보 모두 삭제)
	                session.invalidate();
	                // 로그아웃되면 다시 로그인 페이지로
	                resp.sendRedirect(req.getContextPath() + "/HS/login.do");
	                return;
	            }
	            req.getRequestDispatcher("/Project_HS/Account/IsLogin.jsp").forward(req, resp);
	        }
	        // 로그인 안되어있으면
	        else {
	            // 로그인 페이지로
	            JSFunction.alertBack(resp, "/HS/login.do");
	        }
	    }

	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
	                                      		throws ServletException, IOException {
	    	
	    	// POST 요청도 GET 요청으로 처리
	        doGet(req, resp);
	    }
}
