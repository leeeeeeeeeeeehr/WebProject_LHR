package controller;

import java.io.IOException;

import org.apache.catalina.connector.Response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.HSmemberDAO;

@WebServlet("/HS/main.do")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
											throws ServletException, IOException {
	
		// 커넥션 풀을 이용한 DB 연결
		HSmemberDAO dao = new HSmemberDAO();
		
		dao.close();
		
			
		req.getRequestDispatcher("/Project_HS/Index.jsp").forward(req, resp);
		
	}
	
	
}
