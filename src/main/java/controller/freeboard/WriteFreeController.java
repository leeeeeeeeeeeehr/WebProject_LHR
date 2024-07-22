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

@WebServlet("/HS/write-free.do")
@MultipartConfig
public class WriteFreeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
											throws ServletException, IOException {
		
		req.getRequestDispatcher("/Project_HS/Free/WriteFree.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
											throws ServletException, IOException {
	
		String saveDirectory = req.getServletContext().getRealPath("/Uploads");
		
		// 파일 업로드
		String originalFileName = "";
		try {
			// 업로드 성공하면 원본 파일명 반환
			originalFileName = FileUtil.uploadFile(req, saveDirectory);
		}
		catch (Exception e) {
			e.printStackTrace();
			JSFunction.alertLocation(resp, "파일 업로드 오류입니다.", "../HS/write-free.do");
			return;
		}
		
		HttpSession session = req.getSession(false);
		
		// 제목이랑 내용 저장
		FreeBoardDTO freedto = new FreeBoardDTO();
		// 세션에 저장되어있는 아이디 저장
		freedto.setId((String) session.getAttribute("userId"));
		// 게시글 제목, 내용 저장
		freedto.setTitle(req.getParameter("title"));
		freedto.setContent(req.getParameter("content"));
		
		// 원본 파일명이 있으면
		if (originalFileName != "") {
			// 새로운 파일명으로 변경
			String savedFileName = FileUtil.renameFile(saveDirectory, originalFileName);
			// 원본 파일명과 새로운 파일명 저장
			freedto.setOfile(originalFileName);
			freedto.setSfile(savedFileName);
		}
		
		String write = req.getParameter("write");
		if (write != null && write.equals("true")) {
			// DAO를 통해 DB에 게시 내용 저장
			FreeBoardDAO freedao = new FreeBoardDAO();
			int result = freedao.freeWrite(freedto);
			freedao.close();
			
			// 글쓰기 성공
			// insert에 성공한 경우에는 목록으로 이동하고
			if (result == 1) {
				System.out.println("게시물 업로드 성공");
				System.out.println("제목=" + freedto.getTitle());
				resp.sendRedirect("../HS/list-free.do");
			}
			// 글쓰기 실패
			// insert에 실패한 경우에는 쓰기 페이지로 이동한다.
			else {
				JSFunction.alertLocation(resp, "글쓰기에 실패했습니다.", "../HS/write-free.do");
			}
		}
	}
}