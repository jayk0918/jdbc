package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Authorinsert {

	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@webdb_high?TNS_ADMIN=/Users/jaykim0918/Dropbox/Wallet_webdb";
		String userid = "admin";
		String pwd = "Jayk09180918";
	    
		try {
    	    Class.forName("oracle.jdbc.OracleDriver");//
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
	        	 // SQL문 준비 / 바인딩 / 실행
		        String query = "";
		        query += " insert into author ";
		        query += " values(seq_author_id.nextval, ?, ?) ";
		        
		        System.out.println(query);
		        // str을 붙이는 과정에서 띄어쓰기가 무시될 위험성이 높음
		        // sql문 시작과 끝에 띄어쓰기 값을 강제로 넣음으로써 오류 회피
		        // ? : ?에 해당하는 자리는 사용자가 제공해야하는 데이터임
		        // 숫자, 문자열 상관없이 ?로 표기하여야 함 (문법)
		        
		        // 문자열을 쿼리로 만들기
		        pstmt = conn.prepareStatement(query);
		        pstmt.setString(1, "이문열");
		        pstmt.setString(2, "경북 영양");
		        
		        // 실행
		        int count = pstmt.executeUpdate();
		        
		        System.out.println(count + "건이 등록되었습니다.");
		        
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
					System.out.println("error:" + e); }
	        }
		}catch(SQLException e) {
	    	   System.out.println("error" + e);
		}
	}		
}			
			
	        	
	        	
	        	
	        	
	        
	       
	        
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
