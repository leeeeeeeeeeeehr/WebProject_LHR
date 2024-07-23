package controller.fileboard;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.FileBoardDAO;
import model.FileBoardDTO;
import utils.CookieManager;

@WebServlet("/HS/view-file.do")
public class ViewFileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
											throws ServletException, IOException {
		
		FileBoardDAO filedao = new FileBoardDAO();
		// 게시물 번호 가져오기
		String num = req.getParameter("num");
		
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("userId");
		// 로그인 되어있으면
		if (session.getAttribute("userId") != null) {
			// 쿠키 생성
			String ckValue = CookieManager.readCookie(req, "fileboard_"+num+"_"+id);
			if (!ckValue.equals("read")) {
				CookieManager.makeCookie(resp, "fileboard_"+num+"_"+id, "read", 86400);
				// 조회수 증가
				filedao.updateVisitCount(num);
			}
		}
		else {
			// 쿠키 생성
			String ckValue = CookieManager.readCookie(req, "fileboard_"+num+"_guest");
			if (!ckValue.equals("read")) {
				CookieManager.makeCookie(resp, "fileboard_"+num+"_guest", "read", 86400);
				// 조회수 증가
				filedao.updateVisitCount(num);
			}
		}

		// 게시물 인출
		FileBoardDTO filedto = filedao.fileView(num);
		filedao.close();
		// 줄바꿈 처리
		filedto.setContent(filedto.getContent().replaceAll("\r\n", "<br />"));
		
		if (filedto.getOfile() != null || filedto.getSfile() != null) {
			// 확장자만 잘라서 저장
			String ext = filedto.getSfile().substring(filedto.getSfile().lastIndexOf("."));
			req.setAttribute("ext", ext);
		}
		
		req.setAttribute("filedto", filedto);
		req.getRequestDispatcher("/Project_HS/File/ViewFile.jsp").forward(req, resp);
	}
	

}
