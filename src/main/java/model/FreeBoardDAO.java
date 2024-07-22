package model;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import common.DBConnPool;

public class FreeBoardDAO extends DBConnPool {
	
	// 전체 게시물 번호 + 검색했을 때 게시물 번호
	public int freeCount(Map<String, Object> map) {
			
		int totalCount = 0;
		
		String query = "SELECT COUNT(*) FROM free_board";
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
	public List<FreeBoardDTO> freePage(Map<String, Object> map) {
		
		List<FreeBoardDTO> freeboard = new Vector<FreeBoardDTO>();
		
		// 페이징 처리
		String query = "SELECT * FROM ( "
						+ " SELECT freeboard.*, ROWNUM rNum FROM ( "
							+ "	SELECT * FROM free_board ";
		if (map.get("searchWord") != null) {
			query += " WHERE " + map.get("searchField")
						+ " LIKE '%" + map.get("searchWord") + "%' ";
		}
		query += " ORDER BY num DESC) freeboard) "
				+ " WHERE rNum BETWEEN ? AND ?";
				
		try {
			// 인파라미터가 있는 동적 쿼리문
			psmt = con.prepareStatement(query);
			psmt.setString(1, map.get("start").toString());
			psmt.setString(2, map.get("end").toString());
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				FreeBoardDTO freedto = new FreeBoardDTO();
				
				freedto.setNum(rs.getString(1));
				freedto.setId(rs.getString(2));
				freedto.setTitle(rs.getString(3));
				freedto.setContent(rs.getString(4));
				freedto.setPostdate(rs.getDate(5));
				freedto.setOfile(rs.getString(6));
				freedto.setSfile(rs.getString(7));
				freedto.setDownCount(rs.getInt(8));
				freedto.setVisitCount(rs.getInt(9));
				
				freeboard.add(freedto);
			}
		}
		catch (Exception e) {
			System.out.println("게시물 조회 중 에외 발생");
			e.printStackTrace();
		}
		return freeboard;
	}
	
	// 게시물 작성
	public int freeWrite(FreeBoardDTO freedto) {
		int result = 0;
		
		try {
			String query = "INSERT INTO free_board (num, id, title, content, ofile, sfile) "
							+ " VALUES (freeboard_num.NEXTVAL, ?, ?, ?, ?, ?)";
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, freedto.getId());
			psmt.setString(2, freedto.getTitle());
			psmt.setString(3, freedto.getContent());
			psmt.setString(4, freedto.getOfile());
			psmt.setString(5, freedto.getSfile());
			result = psmt.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("게시물 업로드 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
	
	// 게시물 상세보기
	public FreeBoardDTO freeView(String num) {
		FreeBoardDTO freedto = new FreeBoardDTO();
		
		String query = "SELECT * FROM free_board WHERE num=?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, num);
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				freedto.setNum(rs.getString(1));
				freedto.setId(rs.getString(2));
				freedto.setTitle(rs.getString(3));
				freedto.setContent(rs.getString(4));
				freedto.setPostdate(rs.getDate(5));
				freedto.setOfile(rs.getString(6));
				freedto.setSfile(rs.getString(7));
				freedto.setDownCount(rs.getInt(8));
				freedto.setVisitCount(rs.getInt(9));
			}
		}
		catch (Exception e) {
			System.out.println("게시물 상세보기 중 예외 발생");
			e.printStackTrace();
		}
		return freedto;
	}
	
	// 게시물 조회수 증가
	public void updateVisitCount(String num) {
		String query = "UPDATE free_board "
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
	
	// 파일 다운로드 수 증가
	public void updateDownloadCount(String num) {
		String sql = "UPDATE free_board "
					+ " SET downCount = downCount + 1 "
					+ " WHERE num=?";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, num);
			psmt.executeQuery();
		}
		catch (Exception e) {
			System.out.println("파일 다운로드 중 예외 발생");
			e.printStackTrace();
		}
	}
	
	// 게시물 수정
	public int updatePost(FreeBoardDTO freedto) {
		int result = 0;
		
		try {
			String query = "UPDATE free_board "
							+ " SET title=?, content=?, ofile=?, sfile=? "
							+ " WHERE num=? and id=?";
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, freedto.getTitle());
			psmt.setString(2, freedto.getContent());
			psmt.setString(3, freedto.getOfile());
			psmt.setString(4, freedto.getSfile());
			psmt.setString(5, freedto.getNum());
			psmt.setString(6, freedto.getId());
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
			String query = "DELETE FROM free_board WHERE num=?";
			
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
