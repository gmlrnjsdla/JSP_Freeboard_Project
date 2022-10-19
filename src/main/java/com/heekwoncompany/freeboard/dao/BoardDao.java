package com.heekwoncompany.freeboard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	
}
