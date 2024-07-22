package controller.fileboard;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.FileBoardDAO;
import model.FileBoardDTO;

@WebServlet("/HS/view-file.do")
public class ViewFileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
											throws ServletException, IOException {
		
		FileBoardDAO filedao = new FileBoardDAO();
		// 게시물 번호 가져오기
		String num = req.getParameter("num");
		// 조회수 증가
		filedao.updateVisitCount(num);
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
