package controller.qnaboard;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.QnABoardDAO;
import model.QnABoardDTO;
import utils.BoardPage;

@WebServlet("/HS/list-qna.do")
public class ListQnAController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
											throws ServletException, IOException {

		
		// DB 연결
		QnABoardDAO qnadao = new QnABoardDAO();
		
		// 게시물의 구간 및 검색어 관련 파라미터 저장을 위한 Map 생성
		Map<String, Object> map = new HashMap<String, Object>();
		
		// 검색어 파라미터 Map에 저장
		String searchField = req.getParameter("searchField");
		String searchWord = req.getParameter("searchWord");
		if (searchWord != null) {
			map.put("searchField", searchField);
			map.put("searchWord", searchWord);
		}
		
		// 게시물의 총 갯수
		int totalCount = qnadao.qnaCount(map);

		// 페이징 처리
		ServletContext application = getServletContext();
		
		// 한 페이지에 출력할 게시물의 갯수
		int pageList = Integer.parseInt(application.getInitParameter("POSTS_PER_PAGE"));
		// 한 블럭 당 출력할 페이지 번호의 갯수
		int pageBlock = Integer.parseInt(application.getInitParameter("PAGES_PER_BLOCK"));

		// 페이지 번호 설정
		int pageNum = 1;
		String pageNow = req.getParameter("pageNum");
		if (pageNow != null && !pageNow.equals("")) {
			pageNum = Integer.parseInt(pageNow);
		}

		// 목록에 출력할 게시물의 범위를 계산하여 Map에 저장한다.
		int start = (pageNum - 1) * pageList + 1;
		int end = pageNum * pageList;
		map.put("start", start);
		map.put("end", end);
		
		// 해당 페이지에 출력할 게시물을 List로 얻어온다.
		List<QnABoardDTO> qnaboard = qnadao.qnaPage(map);
		qnadao.close();
		
		// 페이지 번호를 String으로 반환
		String paging = BoardPage.pagingStr(totalCount, pageList,
										pageBlock, pageNum, "../HS/qna-list.do");
		
		// 페이지 번호
		map.put("paging", paging);
		// 전체 게시물의 갯수
		map.put("totalCount", totalCount);
		// 한 페이지에 출력할 게시물의 갯수
		map.put("pageList", pageList);
		// 현재 페이지 번호
		map.put("pageNum", pageNum);
		
		// View(JSP 페이지)로 전달할 데이터를 request 영역에 저장
		req.setAttribute("qnaboard", qnaboard);
		req.setAttribute("map", map);
		
		req.getRequestDispatcher("/Project_HS/QnA/ListQnA.jsp").forward(req, resp);
	}

}