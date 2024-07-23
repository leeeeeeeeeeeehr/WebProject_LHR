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

@WebServlet("/HS/edit-qna.do")
@MultipartConfig(
		maxFileSize = 102400 * 102400 * 1,
		maxRequestSize = 102400 * 102400 * 10
)
public class EditQnAController extends HttpServlet {
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
		
		if (session.getAttribute("userId") != null && !(qnadto.getId().equals((String) session.getAttribute("userId")))) {
			JSFunction.alertLocation(resp, "수정 권한이 없습니다.", "../HS/view-qna.do?num=" + num);
			return;
		}
		req.setAttribute("qnadto", qnadto);
		req.getRequestDispatcher("/Project_HS/QnA/EditQnA.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
											throws ServletException, IOException {
	
		String num = req.getParameter("num");
		
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("userId");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		QnABoardDTO qnadto = new QnABoardDTO();
		qnadto.setNum(num);
		qnadto.setId(id);
		qnadto.setTitle(title);
		qnadto.setContent(content);
		
		QnABoardDAO qnadao = new QnABoardDAO();
		int result = qnadao.updatePost(qnadto);
		
		if (result == 1) {
			resp.sendRedirect("../HS/view-qna.do?num=" + num);
		}
		// 수정하기 실패했을 때
		else {
			// 수정에 실패하면 경고창을 띄우고 이동한다.
			JSFunction.alertLocation(resp, "수정을 실패했습니다.", "../HS/view-qna.do?num=" + num);
		}
	}
}
