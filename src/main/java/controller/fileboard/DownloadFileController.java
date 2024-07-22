package controller.fileboard;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.FileBoardDAO;
import utils.FileUtil;

@WebServlet("/HS/download-file.do")
public class DownloadFileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
											throws ServletException, IOException {

		String ofile = req.getParameter("ofile");
		String sfile = req.getParameter("sfile");
		String num = req.getParameter("num");
		
		
		FileUtil.download(req, resp, "/Project_HS/UploadsFile", sfile, ofile);
		
		// 다운로드 카운트 증가
		FileBoardDAO filedao = new FileBoardDAO();
		filedao.updateDownloadCount(num);
		filedao.close();
	}

}
