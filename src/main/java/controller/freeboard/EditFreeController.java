package controller.freeboard;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.FreeBoardDAO;
import model.FreeBoardDTO;
import utils.FileUtil;
import utils.JSFunction;

@WebServlet("/HS/edit-free.do")
@MultipartConfig(
		maxFileSize = 102400 * 102400 * 1,
		maxRequestSize = 102400 * 102400 * 10
)
public class EditFreeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
											throws ServletException, IOException {

		
		String num = req.getParameter("num");
		FreeBoardDAO freedao = new FreeBoardDAO();
		FreeBoardDTO freedto = freedao.freeView(num);

		HttpSession session = req.getSession();
		
		if (session.getAttribute("userId") == null) {
			JSFunction.alertLocation(resp, "로그인이 필요한 서비스입니다.", "../HS/login.do");
			return;
		}
		
		if (session.getAttribute("userId") != null && !(freedto.getId().equals((String) session.getAttribute("userId")))) {
			JSFunction.alertLocation(resp, "수정 권한이 없습니다.", "../HS/view-free.do?num=" + num);
			return;
		}
		req.setAttribute("freedto", freedto);
		req.getRequestDispatcher("/Project_HS/Free/EditFree.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
											throws ServletException, IOException {
	
		String saveDirectory = req.getServletContext().getRealPath("/Project_HS/UploadsFree");
		
		String origianlFileName = "";
		try {
			origianlFileName = FileUtil.uploadFile(req, saveDirectory);
		}
		catch (Exception e) {
			e.printStackTrace();
			JSFunction.alertBack(resp, "파일 업로드 오류입니다.");
			return;
		}
		
		
		String num = req.getParameter("num");
		String prevOfile = req.getParameter("prevOfile");
		String prevSfile = req.getParameter("prevSfile");
		
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("userId");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		FreeBoardDTO freedto = new FreeBoardDTO();
		freedto.setNum(num);
		freedto.setId(id);
		freedto.setTitle(title);
		freedto.setContent(content);
		
		if (origianlFileName != "") {
			// 새로운 파일명
			String savedFileName = FileUtil.renameFile(saveDirectory, origianlFileName);
			
			// 새로운 파일 저장
			freedto.setOfile(origianlFileName);
			freedto.setSfile(savedFileName);
			
			// 기존에 업로드되어있던 파일 삭제
			FileUtil.deleteFile(req, "/Project_HS/UploadsFree", prevSfile);
		}
		else {
			// 새로운 파일 없으면 기존 파일명 유지
			freedto.setOfile(prevOfile);
			freedto.setSfile(prevSfile);
		}
		
		FreeBoardDAO freedao = new FreeBoardDAO();
		int result = freedao.updatePost(freedto);
		
		if (result == 1) {
			resp.sendRedirect("../HS/view-free.do?num=" + num);
		}
		// 수정하기 실패했을 때
		else {
			// 수정에 실패하면 경고창을 띄우고 이동한다.
			JSFunction.alertLocation(resp, "수정을 실패했습니다.", "../HS/view-free.do?num=" + num);
		}
	}
}
