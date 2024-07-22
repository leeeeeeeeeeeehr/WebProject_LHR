package controller.freeboard;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.FreeBoardDAO;
import utils.FileUtil;

@WebServlet("/HS/download-free.do")
public class DownloadFreeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
											throws ServletException, IOException {

		String ofile = req.getParameter("ofile");
		String sfile = req.getParameter("sfile");
		String num = req.getParameter("num");
		
		
		FileUtil.download(req, resp, "/Project_HS/UploadsFree", sfile, ofile);
		
		// 다운로드 카운트 증가
		FreeBoardDAO freedao = new FreeBoardDAO();
		freedao.updateDownloadCount(num);
		freedao.close();
	}

}
