package model;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import common.DBConnPool;

public class FileBoardDAO extends DBConnPool {

	// 전체 게시물 번호 + 검색했을 때 게시물 번호
	public int fileCount(Map<String, Object> map) {

		int totalCount = 0;

		String query = "SELECT COUNT(*) FROM file_board";
		if (map.get("searchWord") != null) {
			query += " WHERE " + map.get("searchField") + " LIKE '%" + map.get("searchWord") + "%'";
		}

		try {
			// 인파라미터가 없는 쿼리문이므로 stmt 사용
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);

			rs.next();
			totalCount = rs.getInt(1);
		} catch (Exception e) {
			System.out.println("자유게시판 게시물 갯수 세는 중 예외 발생");
			e.printStackTrace();
		}

		return totalCount;
	}

	// 한 페이지에 게시글 10개만 출력
	public List<FileBoardDTO> filePage(Map<String, Object> map) {

		List<FileBoardDTO> fileboard = new Vector<FileBoardDTO>();

		// 페이징 처리
		String query = "SELECT * FROM ( " + " SELECT fileboard.*, ROWNUM rNum FROM ( " + "	SELECT * FROM file_board ";
		if (map.get("searchWord") != null) {
			query += " WHERE " + map.get("searchField") + " LIKE '%" + map.get("searchWord") + "%' ";
		}
		query += " ORDER BY num DESC) fileboard) " + " WHERE rNum BETWEEN ? AND ?";

		try {
			// 인파라미터가 있는 동적 쿼리문
			psmt = con.prepareStatement(query);
			psmt.setString(1, map.get("start").toString());
			psmt.setString(2, map.get("end").toString());
			rs = psmt.executeQuery();

			while (rs.next()) {
				FileBoardDTO filedto = new FileBoardDTO();

				filedto.setNum(rs.getString(1));
				filedto.setId(rs.getString(2));
				filedto.setTitle(rs.getString(3));
				filedto.setContent(rs.getString(4));
				filedto.setPostdate(rs.getDate(5));
				filedto.setOfile(rs.getString(6));
				filedto.setSfile(rs.getString(7));
				filedto.setDownCount(rs.getInt(8));
				filedto.setVisitCount(rs.getInt(9));

				fileboard.add(filedto);
			}
		} catch (Exception e) {
			System.out.println("게시물 조회 중 에외 발생");
			e.printStackTrace();
		}
		return fileboard;
	}

	// 게시물 작성
	public int fileWrite(FileBoardDTO filedto) {
		int result = 0;

		try {
			String query = "INSERT INTO file_board (num, id, title, content, ofile, sfile) "
					+ " VALUES (fileboard_num.NEXTVAL, ?, ?, ?, ?, ?)";

			psmt = con.prepareStatement(query);
			psmt.setString(1, filedto.getId());
			psmt.setString(2, filedto.getTitle());
			psmt.setString(3, filedto.getContent());
			psmt.setString(4, filedto.getOfile());
			psmt.setString(5, filedto.getSfile());
			result = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("게시물 업로드 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}

	// 게시물 상세보기
	public FileBoardDTO fileView(String num) {
		FileBoardDTO filedto = new FileBoardDTO();

		String query = "SELECT * FROM file_board WHERE num=?";

		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, num);
			rs = psmt.executeQuery();

			if (rs.next()) {
				filedto.setNum(rs.getString(1));
				filedto.setId(rs.getString(2));
				filedto.setTitle(rs.getString(3));
				filedto.setContent(rs.getString(4));
				filedto.setPostdate(rs.getDate(5));
				filedto.setOfile(rs.getString(6));
				filedto.setSfile(rs.getString(7));
				filedto.setDownCount(rs.getInt(8));
				filedto.setVisitCount(rs.getInt(9));
			}
		} catch (Exception e) {
			System.out.println("게시물 상세보기 중 예외 발생");
			e.printStackTrace();
		}
		return filedto;
	}

	// 게시물 조회수 증가
	public void updateVisitCount(String num) {
		String query = "UPDATE file_board " + " SET visitCount = visitCount + 1 " + " WHERE num=?";

		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, num);
			psmt.executeQuery();
		} catch (Exception e) {
			System.out.println("게시물 조회수 증가 중 예외 발생");
			e.printStackTrace();
		}
	}

	// 파일 다운로드 수 증가
	public void updateDownloadCount(String num) {
		String sql = "UPDATE file_board " + " SET downCount = downCount + 1 " + " WHERE num=?";

		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, num);
			psmt.executeQuery();
		} catch (Exception e) {
			System.out.println("파일 다운로드 중 예외 발생");
			e.printStackTrace();
		}
	}

	// 게시물 수정
	public int updatePost(FileBoardDTO filedto) {
		int result = 0;

		try {
			String query = "UPDATE file_board " + " SET title=?, content=?, ofile=?, sfile=? "
					+ " WHERE num=? and id=?";

			psmt = con.prepareStatement(query);
			psmt.setString(1, filedto.getTitle());
			psmt.setString(2, filedto.getContent());
			psmt.setString(3, filedto.getOfile());
			psmt.setString(4, filedto.getSfile());
			psmt.setString(5, filedto.getNum());
			psmt.setString(6, filedto.getId());
			result = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("게시물 수정 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}

	// 게시물 삭제
	public int deletePost(String num) {
		int result = 0;

		try {
			String query = "DELETE FROM file_board WHERE num=?";

			psmt = con.prepareStatement(query);
			psmt.setString(1, num);
			result = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("게시물 삭제 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}

}
