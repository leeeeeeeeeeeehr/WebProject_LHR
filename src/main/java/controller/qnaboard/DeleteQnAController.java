package controller.qnaboard;

import java.io.IOException;

import common.JSFunction;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.QnABoardDAO;
import model.QnABoardDTO;

@WebServlet("/HS/delete-qna.do")
public class DeleteQnAController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
											throws ServletException, IOException {
		
		String num = req.getParameter("num");
		QnABoardDAO qnadao = new QnABoardDAO();
		
		QnABoardDTO qnadto = qnadao.qnaView(num);
		
		HttpSession session = req.getSession();
		
		if (session.getAttribute("userId") == null) {
			JSFunction.alertLocation(resp, "로그인이 필요한 서비스입니다.", "../HS/login.do");
			return;
		}
		
		// 사용자 확인
		if (session.getAttribute("userId") != null && !(qnadto.getId().equals((String) session.getAttribute("userId")))) {
			JSFunction.alertLocation(resp, "삭제 권한이 없습니다.", "../HS/view-qna.do?num=" + num);
			return;
		}
		// 게시물 삭제
		int result = qnadao.deletePost(num);
		
		if (result == 1) {
			JSFunction.alertLocation(resp, "게시물이 삭제되었습니다.", "../HS/list-qna.do");
		}
	}
}
