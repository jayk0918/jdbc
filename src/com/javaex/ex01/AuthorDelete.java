package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorDelete {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@webdb_high?TNS_ADMIN=/Users/jaykim0918/Dropbox/Wallet_webdb";
		String userid = "admin";
		String pwd = "Jayk09180918";

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("JDBC 드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("error : 드라이버 로딩 실패 - " + e);
		}

		try {
			System.out.println("DB 연결 준비......");
			Connection conn = DriverManager.getConnection(url, userid, pwd);
			PreparedStatement pstmt = null;
			// ResultSet rs = null;
			if (conn != null) {
				System.out.println("DB 연결 성공...");
			}

			try {
				// SQL문 준비
				String query = "";
				query += " delete from author ";
				query += " where author_id = ? ";

				System.out.println(query);

				// 바인딩
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, 7);

				// 실행
				int count = pstmt.executeUpdate();
				System.out.println(count + "건이 등록되었습니다.");

			} catch (SQLException e) {
				System.out.println("error:" + e);
			} finally {
				// 자원 정리
				try {
					/*
					 * if (rs != null) { rs.close(); }
					 */
					if (pstmt != null) {
						pstmt.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					System.out.println("error:" + e);
				}
			}
		} catch (SQLException e) {
			System.out.println("error" + e);
		}

	}

}
