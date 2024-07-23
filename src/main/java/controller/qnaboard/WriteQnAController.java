package controller.qnaboard;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.QnABoardDAO;
import model.QnABoardDTO;
import utils.JSFunction;

@WebServlet("/HS/write-qna.do")
@MultipartConfig(
		maxFileSize = 102400 * 102400 * 1,
		maxRequestSize = 102400 * 102400 * 10
)
public class WriteQnAController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
											throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		if (session.getAttribute("userId") == null) {
			JSFunction.alertLocation(resp, "로그인이 필요한 서비스입니다.", "../HS/login.do");
			return;
		}
		
		if (session.getAttribute("userId") != null) {
			req.getRequestDispatcher("/Project_HS/QnA/WriteQnA.jsp").forward(req, resp);			
		}
		else {
			JSFunction.alertLocation(resp, "로그인 후 이용해주세요.", "../HS/list-qna.do");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
											throws ServletException, IOException {
	
		HttpSession session = req.getSession();
		
		// 제목이랑 내용 저장
		QnABoardDTO qnadto = new QnABoardDTO();
		// 세션에 저장되어있는 아이디 저장
		qnadto.setId((String) session.getAttribute("userId"));
		// 게시글 제목, 내용 저장
		qnadto.setTitle(req.getParameter("title"));
		qnadto.setContent(req.getParameter("content"));
		
		String write = req.getParameter("write");
		// 쓰기 요청이 있으면
		if (write != null && write.equals("true")) {
			QnABoardDAO qnadao = new QnABoardDAO();
			int result = qnadao.qnaWrite(qnadto);
			qnadao.close();
			
			if (result == 1) {
				resp.sendRedirect("../HS/list-qna.do");
			}
			else {
				JSFunction.alertLocation(resp, "글쓰기에 실패했습니다.", "../HS/write-qna.do");
			}
		}
	}
}