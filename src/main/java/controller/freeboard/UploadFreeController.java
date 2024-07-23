package controller.freeboard;

import java.io.IOException;

import common.JSFunction;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.FileUtil;

@WebServlet("/HS/upload-free.do")
@MultipartConfig(
		maxFileSize = 102400 * 102400 * 1,
		maxRequestSize = 102400 * 102400 * 10
)
public class UploadFreeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
											throws ServletException, IOException {

		try {
			// 파일이 저장될 물리적 경로
			String saveDirectory = getServletContext().getRealPath("/Project_HS/UploadsFree");
			// 파일 업로드 처리
			String originalFileName = FileUtil.uploadFile(req, saveDirectory);
			// 서버에 저장된 파일명을 변경
			String savedFileName = FileUtil.renameFile(saveDirectory, originalFileName);
			
			resp.sendRedirect("/Project_HS/Free/ListFree.jsp");
		}
		catch (Exception e) {
			JSFunction.alertBack(resp, "파일 업로드 실패");
			e.printStackTrace();
		}
	}
	
}
