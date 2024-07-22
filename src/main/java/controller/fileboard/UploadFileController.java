package controller.fileboard;

import java.io.IOException;

import common.JSFunction;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.FileUtil;

@WebServlet("/HS/upload-file.do")
@MultipartConfig(
		maxFileSize = 1024 * 1024 * 1,
		maxRequestSize = 1024 * 1024 * 10
)
public class UploadFileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
											throws ServletException, IOException {

		try {
			// 파일이 저장될 물리적 경로
			String saveDirectory = getServletContext().getRealPath("/Project_HS/UploadsFile");
			// 파일 업로드 처리
			String originalFileName = FileUtil.uploadFile(req, saveDirectory);
			// 서버에 저장된 파일명을 변경
			String savedFileName = FileUtil.renameFile(saveDirectory, originalFileName);
			
			resp.sendRedirect("/Project_HS/File/ListFile.jsp");
		}
		catch (Exception e) {
			JSFunction.alertBack(resp, "파일 업로드 실패");
			e.printStackTrace();
		}
	}
	
}
