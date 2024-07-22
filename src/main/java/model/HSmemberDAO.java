package model;

import common.DBConnPool;

public class HSmemberDAO extends DBConnPool {
	
	public HSmemberDAO() {
		super();
	}
	
	// 로그인
	public HSmemberDTO loginMember(String id, String pass) {
		HSmemberDTO dto = new HSmemberDTO();
		
		String query = "SELECT * FROM member WHERE id=? AND pass=?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, id);
			psmt.setString(2, pass);
			rs = psmt.executeQuery();
			if (rs.next()) {
				dto.setId(rs.getString(1));
				dto.setPass(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setEmail(rs.getString(4));
				dto.setPhone(rs.getString(5));
			}
		}
		catch (Exception e) {
			System.out.println("로그인 중 에러 발생");
			e.printStackTrace();
		}
		return dto;
	}
	
	// 회원가입
	public boolean registMember(HSmemberDTO dto) {
		boolean isRegist = false;

		try {
			String query = "INSERT INTO member (id, pass, name, email, phone) "
						+ " values (?, ?, ?, ?, ?)";
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPass());
			psmt.setString(3, dto.getName());
			psmt.setString(4, dto.getEmail());
			psmt.setString(5, dto.getPhone());
			
			int result = psmt.executeUpdate();
			if (result > 0) {
				isRegist = true;
			}
		}
		catch (Exception e) {
			System.out.println("회원 등록 중 예외 발생");
			e.printStackTrace();
		}
		return isRegist;
	}
	
	// 회원정보 수정
	public boolean modifyMember(HSmemberDTO dto) {
		boolean isModify = false;
		
		try {
			String query = "UPDATE member SET "
						+ " pass=?, name=?, email=?, phone=? "
						+ " WHERE id=?";
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getPass());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getEmail());
			psmt.setString(4, dto.getPhone());
			psmt.setString(5, dto.getId());
			
			int result = psmt.executeUpdate();
			if (result > 0) {
				isModify = true;
			}
		}
		catch (Exception e) {
			System.out.println("회원정보 수정 중 예외 발생");
			e.printStackTrace();
		}
		return isModify;
	}


}
