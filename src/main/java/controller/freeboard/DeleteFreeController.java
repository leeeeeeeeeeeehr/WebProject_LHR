package controller.freeboard;

import java.io.IOException;

import common.JSFunction;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.FreeBoardDAO;
import model.FreeBoardDTO;

@WebServlet("/HS/delete-free.do")
public class DeleteFreeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
											throws ServletException, IOException {
		
		String num = req.getParameter("num");
		FreeBoardDAO freedao = new FreeBoardDAO();
		
		FreeBoardDTO freedto = freedao.freeView(num);
		
		HttpSession session = req.getSession(false);
		
		// 사용자 확인
		if (session.getAttribute("userId") != null || !(freedto.getId().equals((String) session.getAttribute("userId")))) {
			JSFunction.alertLocation(resp, "삭제 권한이 없습니다.", "../HS/view-free.do?num=" + num);
			return;
		}
		// 게시물 삭제
		int result = freedao.deletePost(num);
		
		if (result == 1) {
			JSFunction.alertLocation(resp, "게시물이 삭제되었습니다.", "../HS/list-free.do");
		}
		else {
			JSFunction.alertBack(resp, "게시물 삭제 중 예외 발생");
		}
	}
}
