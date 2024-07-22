package controller.freeboard;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.FreeBoardDAO;
import model.FreeBoardDTO;

@WebServlet("/HS/view-free.do")
public class ViewFreeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
											throws ServletException, IOException {
		
		FreeBoardDAO freedao = new FreeBoardDAO();
		// 게시물 번호 가져오기
		String num = req.getParameter("num");
		// 조회수 증가
		freedao.updateVisitCount(num);
		// 게시물 인출
		FreeBoardDTO freedto = freedao.freeView(num);
		freedao.close();
		// 줄바꿈 처리
		freedto.setContent(freedto.getContent().replaceAll("\r\n", "<br />"));
		
		if (freedto.getOfile() != null || freedto.getSfile() != null) {
			// 확장자만 잘라서 저장
			String ext = freedto.getSfile().substring(freedto.getSfile().lastIndexOf("."));
			req.setAttribute("ext", ext);
		}
		
		req.setAttribute("freedto", freedto);
		req.getRequestDispatcher("/Project_HS/Free/ViewFree.jsp").forward(req, resp);
	}
	

}
