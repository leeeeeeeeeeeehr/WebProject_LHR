package model;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import common.DBConnPool;

public class QnABoardDAO extends DBConnPool {
	
	// 전체 게시물 번호 + 검색했을 때 게시물 번호
	public int qnaCount(Map<String, Object> map) {
			
		int totalCount = 0;
		
		String query = "SELECT COUNT(*) FROM qna_board";
		if (map.get("searchWord") != null) {
			query += " WHERE " + map.get("searchField") 
						+ " LIKE '%" + map.get("searchWord") + "%'";
		}
		
		try {
			// 인파라미터가 없는 쿼리문이므로 stmt 사용
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
			rs.next();
			totalCount = rs.getInt(1);
		}
		catch (Exception e) {
			System.out.println("자유게시판 게시물 갯수 세는 중 예외 발생");
			e.printStackTrace();
		}
			
		return totalCount;
	}

	// 한 페이지에 게시글 10개만 출력
	public List<QnABoardDTO> qnaPage(Map<String, Object> map) {
		
		List<QnABoardDTO> qnaboard = new Vector<QnABoardDTO>();
		
		// 페이징 처리
		String query = "SELECT * FROM ( "
						+ " SELECT qnaboard.*, ROWNUM rNum FROM ( "
							+ "	SELECT * FROM qna_board ";
		if (map.get("searchWord") != null) {
			query += " WHERE " + map.get("searchField")
						+ " LIKE '%" + map.get("searchWord") + "%' ";
		}
		query += " ORDER BY num DESC) qnaboard) "
				+ " WHERE rNum BETWEEN ? AND ?";
				
		try {
			// 인파라미터가 있는 동적 쿼리문
			psmt = con.prepareStatement(query);
			psmt.setString(1, map.get("start").toString());
			psmt.setString(2, map.get("end").toString());
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				QnABoardDTO qnadto = new QnABoardDTO();
				
				qnadto.setNum(rs.getString(1));
				qnadto.setId(rs.getString(2));
				qnadto.setTitle(rs.getString(3));
				qnadto.setContent(rs.getString(4));
				qnadto.setPostdate(rs.getDate(5));
				qnadto.setVisitCount(rs.getInt(6));
				
				qnaboard.add(qnadto);
			}
		}
		catch (Exception e) {
			System.out.println("게시물 조회 중 에외 발생");
			e.printStackTrace();
		}
		return qnaboard;
	}
	
	// 게시물 작성
	public int qnaWrite(QnABoardDTO qnadto) {
		int result = 0;
		
		try {
			String query = "INSERT INTO qna_board (num, id, title, content) "
							+ " VALUES (qnaboard_num.NEXTVAL, ?, ?, ?)";
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, qnadto.getId());
			psmt.setString(2, qnadto.getTitle());
			psmt.setString(3, qnadto.getContent());
			result = psmt.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("게시물 업로드 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
	
	// 게시물 상세보기
	public QnABoardDTO qnaView(String num) {
		QnABoardDTO qnadto = new QnABoardDTO();
		
		String query = "SELECT * FROM qna_board WHERE num=?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, num);
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				qnadto.setNum(rs.getString(1));
				qnadto.setId(rs.getString(2));
				qnadto.setTitle(rs.getString(3));
				qnadto.setContent(rs.getString(4));
				qnadto.setPostdate(rs.getDate(5));
				qnadto.setVisitCount(rs.getInt(6));
			}
		}
		catch (Exception e) {
			System.out.println("게시물 상세보기 중 예외 발생");
			e.printStackTrace();
		}
		return qnadto;
	}
	
	// 게시물 조회수 증가
	public void updateVisitCount(String num) {
		String query = "UPDATE qna_board "
						+ " SET visitCount = visitCount + 1 "
						+ " WHERE num=?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, num);
			psmt.executeQuery();
		}
		catch (Exception e) {
			System.out.println("게시물 조회수 증가 중 예외 발생");
			e.printStackTrace();
		}
	}
	
	// 게시물 수정
	public int updatePost(QnABoardDTO qnadto) {
		int result = 0;
		
		try {
			String query = "UPDATE qna_board "
							+ " SET title=?, content=? "
							+ " WHERE num=? and id=?";
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, qnadto.getTitle());
			psmt.setString(2, qnadto.getContent());
			psmt.setString(3, qnadto.getNum());
			psmt.setString(4, qnadto.getId());
			result = psmt.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("게시물 수정 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
	
	
	// 게시물 삭제
	public int deletePost(String num) {
		int result = 0;
	
		try {
			String query = "DELETE FROM qna_board WHERE num=?";
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, num);
			result = psmt.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("게시물 삭제 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
	
}
