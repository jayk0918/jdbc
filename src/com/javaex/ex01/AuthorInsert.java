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
	    
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("JDBC 드라이버 로딩 성공");
		}catch(ClassNotFoundException e) {
			System.out.println("error : 드라이버 로딩 실패 - " + e);
		}
       
		try {
			System.out.println("DB 연결 준비......");
			Connection conn = DriverManager.getConnection(url, userid, pwd);
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			if(conn!=null) {
				System.out.println("DB 연결 성공...");
			}
	        
	        try {
	        	 // SQL문 준비
		        String query = "";
		        query += " select author_id ";
		        query += "     ,author_name ";
		        query += "     ,author_desc ";
		        query += " from author ";
		        
		        System.out.println(query);
		        
		        // 바인딩
		        pstmt = conn.prepareStatement(query);
		       
		        // 실행
		        // int count = pstmt.executeUpdate(); -> int값만 return 해줌 / insert, update, delete
		        rs = pstmt.executeQuery();
		        
		        // 결과처리
		        // rs.next(); // 가상 cursor를 옮기는 작업 (author_id를 1번부터 인식할 수 있도록)
		        // 언제 끝날지 모르므로 while문으로 결과 return
		        while(rs.next()) {
		        	int authorId = rs.getInt(1); // "author_id" 와 같음
			        String authorName = rs.getString(2); // "author_name"
			        String authorDesc = rs.getString(3); // "author_desc"
			        System.out.println(authorId + ", " + authorName + ", " + authorDesc);
		        }
		        
	        }catch(SQLException e) {
	        	System.out.println("error:" + e);
	        }finally {
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
				}catch (SQLException e) {
					System.out.println("error:" + e);
				}
	        }
		}catch(SQLException e) {
	    	   System.out.println("error" + e);
		}
	}		
}			
// commit 이슈 발생 : delete랑 insert 진행중에 sql exception : 마지막 행 다음의 결과 집합 오류가 뜸
// 예제 맞추려고 drop table 했다가 재구성했는데, 테이블 상태가 값이 없음을 인식하지 못했음
// sql developer로 다시 가서 table 값을 다시 세팅하고 commit을 진행하고 eclipse에서 문구를 실행하니 결과값이 출력되었음
	        	
	        	
	        	