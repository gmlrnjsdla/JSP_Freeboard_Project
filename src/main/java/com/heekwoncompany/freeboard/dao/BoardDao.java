package com.heekwoncompany.freeboard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.heekwoncompany.freeboard.dto.BoardDto;

public class BoardDao {

	static String driverName = "com.mysql.jdbc.Driver";
	static String url ="jdbc:mysql://localhost:3306/serverdb";
	static String user = "root";
	static String pass = "1234";
	
	public void write(String bname, String btitle, String bcontent) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO freeboard(bname,btitle,bcontent,bhit) "
				+ "VALUES ('"+bname+"','"+btitle+"','"+bcontent+"',0)";
		
		try {
			Class.forName(driverName);	// jdbc 드라이버 로딩
			conn = DriverManager.getConnection(url, user, pass); // DB연동 커넥션 생성
			pstmt = conn.prepareStatement(sql); //sql객체 생성
			
			pstmt.executeUpdate(); //sql 실행
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<BoardDto> list() {
		
		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; //select문이 반환하는 데이터를 담는 객체
		
		String sql = "SELECT * FROM freeboard ORDER BY bid DESC";
		
		try {
			Class.forName(driverName);	// jdbc 드라이버 로딩
			conn = DriverManager.getConnection(url, user, pass); // DB연동 커넥션 생성
			pstmt = conn.prepareStatement(sql); //sql객체 생성
			
			rs = pstmt.executeQuery(); //sql 실행
			
			while(rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				String bdate = rs.getString("bdate");
				int bhit = rs.getInt("bhit");
				
				BoardDto dto = new BoardDto(bid,bname,btitle,bcontent,bdate,bhit);
				// 생성자 활용
				
//				dto.setBid(bid);
//				dto.setBname(bname);
//				dto.setBtitle(btitle);
//				dto.setBcontent(bcontent);
//				dto.setBdate(bdate);
//				dto.setBhit(bhit);
				// getter , setter 활용
				
				dtos.add(dto);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return dtos;
	}
	
	public BoardDto content_view(String boardNum) {
		
		String sql = "SELECT * FROM freeboard WHERE bid=?";
		
		BoardDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; //select문이 반환하는 데이터를 담는 객체
		
		try {
			Class.forName(driverName);	// jdbc 드라이버 로딩
			conn = DriverManager.getConnection(url, user, pass); // DB연동 커넥션 생성
			pstmt = conn.prepareStatement(sql); //sql객체 생성
			pstmt.setString(1, "boardNum");
			
			rs = pstmt.executeQuery(); //sql 실행
			
			while(rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				String bdate = rs.getString("bdate");
				int bhit = rs.getInt("bhit");
				
				dto = new BoardDto(bid,bname,btitle,bcontent,bdate,bhit);
				// 생성자 활용
		
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return dto;
	}
	
	public void modify(String bid,String bname, String btitle, String bcontent) {
		
	}
	
}
