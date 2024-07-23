package controller.qnaboard;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.QnABoardDAO;
import model.QnABoardDTO;
import utils.CookieManager;

@WebServlet("/HS/view-qna.do")
public class ViewQnAController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
											throws ServletException, IOException {
		
		QnABoardDAO qnadao = new QnABoardDAO();
		// 게시물 번호 가져오기
		String num = req.getParameter("num");
		
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("userId");
		// 로그인 되어있으면
		if (session.getAttribute("userId") != null) {
			// 쿠키 생성
			String ckValue = CookieManager.readCookie(req, "qnaboard_"+num+"_"+id);
			if (!ckValue.equals("read")) {
				CookieManager.makeCookie(resp, "qnaboard_"+num+"_"+id, "read", 86400);
				// 조회수 증가
				qnadao.updateVisitCount(num);
			}
		}
		else {
			// 쿠키 생성
			String ckValue = CookieManager.readCookie(req, "qnaboard_"+num+"_guest");
			if (!ckValue.equals("read")) {
				CookieManager.makeCookie(resp, "qnaboard_"+num+"_guest", "read", 86400);
				// 조회수 증가
				qnadao.updateVisitCount(num);
			}
		}

		// 게시물 인출
		QnABoardDTO qnadto = qnadao.qnaView(num);
		qnadao.close();
		// 줄바꿈 처리
		qnadto.setContent(qnadto.getContent().replaceAll("\r\n", "<br />"));
		
		req.setAttribute("qnadto", qnadto);
		req.getRequestDispatcher("/Project_HS/QnA/ViewQnA.jsp").forward(req, resp);
	}
}
