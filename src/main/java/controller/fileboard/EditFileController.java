package controller.fileboard;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.FileBoardDAO;
import model.FileBoardDTO;
import utils.FileUtil;
import utils.JSFunction;

@WebServlet("/HS/edit-file.do")
@MultipartConfig(
		maxFileSize = 1024 * 1024 * 1,
		maxRequestSize = 1024 * 1024 * 10
)
public class EditFileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
											throws ServletException, IOException {

		
		String num = req.getParameter("num");
		FileBoardDAO filedao = new FileBoardDAO();
		FileBoardDTO filedto = filedao.fileView(num);

		HttpSession session = req.getSession(false);
		if (session.getAttribute("userId") != null || !(filedto.getId().equals((String) session.getAttribute("userId")))) {
			JSFunction.alertLocation(resp, "수정 권한이 없습니다.", "../HS/view-file.do?num=" + num);
		}
		req.setAttribute("filedto", filedto);
		req.getRequestDispatcher("/Project_HS/File/EditFile.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
											throws ServletException, IOException {
	
		String saveDirectory = req.getServletContext().getRealPath("/Project_HS/UploadsFile");
		
		String origianlFileName = "";
		try {
			origianlFileName = FileUtil.uploadFile(req, saveDirectory);
		}
		catch (Exception e) {
			JSFunction.alertBack(resp, "파일 업로드 오류입니다.");
			return;
		}
		
		
		String num = req.getParameter("num");
		String prevOfile = req.getParameter("prevOfile");
		String prevSfile = req.getParameter("prevSfile");
		
		HttpSession session = req.getSession(false);
		String id = (String) session.getAttribute("userId");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		FileBoardDTO filedto = new FileBoardDTO();
		filedto.setNum(num);
		filedto.setId(id);
		filedto.setTitle(title);
		filedto.setContent(content);
		
		if (origianlFileName != "") {
			// 새로운 파일명
			String savedFileName = FileUtil.renameFile(saveDirectory, origianlFileName);
			
			// 새로운 파일 저장
			filedto.setOfile(origianlFileName);
			filedto.setSfile(savedFileName);
			
			// 기존에 업로드되어있던 파일 삭제
			FileUtil.deleteFile(req, "/Project_HS/UploadsFile", prevSfile);
		}
		else {
			// 새로운 파일 없으면 기존 파일명 유지
			filedto.setOfile(prevOfile);
			filedto.setSfile(prevSfile);
		}
		
		FileBoardDAO filedao = new FileBoardDAO();
		int result = filedao.updatePost(filedto);
		
		if (result == 1) {
			resp.sendRedirect("../HS/view-file.do?num=" + num);
		}
		// 수정하기 실패했을 때
		else {
			// 수정에 실패하면 경고창을 띄우고 이동한다.
			JSFunction.alertLocation(resp, "수정을 실패했습니다.", "../HS/view-file.do?num=" + num);
		}
	}
}
