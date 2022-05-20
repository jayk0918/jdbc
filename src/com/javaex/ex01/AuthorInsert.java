package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorInsert {

	public static void main(String[] args) {

		String url = "jdbc:oracle:thin:@webdb_high?TNS_ADMIN=/Users/jaykim0918/Dropbox/Wallet_webdb";
		String userid = "admin";
		String pwd = "Jayk09180918";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("JDBC 드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("error : 드라이버 로딩 실패 - " + e);
		}

		try {
			System.out.println("DB 연결 준비......");
			conn = DriverManager.getConnection(url, userid, pwd);

			if (conn != null) {
				System.out.println("DB 연결 성공...");
			}

			try {
				// SQL문 준비
				String query = "";
				query += " insert into author ";
				query += " values(seq_author_id.nextval, ?, ?) ";

				System.out.println(query);

				// 바인딩
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, "김영하");
				pstmt.setString(2, "알쓸신잡");

				// 실행
				int count = pstmt.executeUpdate();

				// 결과처리보고
				System.out.println(count + "건이 등록되었습니다.");
				// update 실행 시 자동 commit, 수정 이전으로 rollback이 불가능함

			} catch (SQLException e) {
				System.out.println("error:" + e);
			} finally {
				// 자원 정리
				try {
					if (rs != null) {
						rs.close();
					}
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
