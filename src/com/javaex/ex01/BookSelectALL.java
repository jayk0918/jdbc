package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookSelectALL {

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
		        query += " select b.book_id   book_id ";
		        query += "     	 ,b.title  title ";
		        query += "       ,b.pubs pubs ";
		        query += " 		 ,to_char(b.pub_date, 'YYYY-MM-DD') pub_date ";
		        query += " 		 ,a.author_id author_id ";
		        query += " 		 ,a.author_name author_name ";
		        query += " 		 ,a.author_desc author_desc ";
		        query += " from author a, book b ";
		        query += " where a.author_id = b.author_id ";
		        
		        System.out.println(query);
		        
		        // 바인딩
		        pstmt = conn.prepareStatement(query);
		       
		        // 실행
		        rs = pstmt.executeQuery();
		        
		        // 결과처리
		        
		        System.out.println("book_id \t     title \t\tpubs \t\t pub_date   author_id \t author_name \t author_desc");
		        while(rs.next()) {
		        	int bookId = rs.getInt(1); 
			        String title = rs.getString(2);
			        String pubs = rs.getString(3);
			        String pubDate = rs.getString(4);
			        int authorId = rs.getInt(5);
			        String authorName = rs.getString(6);
			        String authorDesc = rs.getString(7);
			        
			        if(bookId == 1 || bookId == 4) {
			        	System.out.println("   " + bookId + "\t\t" + title + "  \t" + pubs + "  \t\t" + pubDate + "   \t" + authorId + "   \t     " + authorName + "  \t  " + authorDesc);
			        }else if(bookId == 3 || bookId == 5) {
			        	System.out.println("   " + bookId + "\t\t" + title + "  \t\t\t" + pubs + "  \t" + pubDate + "   \t" + authorId + "   \t     " + authorName + "  \t  " + authorDesc);
			        }else if(bookId == 7) {
			        	System.out.println("   " + bookId + "\t\t" + title + "  \t\t" + pubs + "  \t\t" + pubDate + "   \t" + authorId + "   \t     " + authorName + "  \t  " + authorDesc);
			        }else if(bookId == 6 || bookId == 8) {
			        	System.out.println("   " + bookId + "\t\t" + title + "  \t\t\t" + pubs + "  \t\t" + pubDate + "   \t" + authorId + "   \t     " + authorName + "  \t  " + authorDesc);
			        }else {
			        	System.out.println("   " + bookId + "\t\t" + title + "  \t\t\t" + pubs + "  \t\t" + pubDate + "   \t" + authorId + "   \t     " + authorName + "  \t  " + authorDesc);
			        }
		        }
	        }catch(SQLException e) {
	        	System.out.println("error:" + e);
	        }finally {
	        	// 자원 정리
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
	        	}catch (SQLException e){
	        		System.out.println("error:" + e);
	        	}
	        }
		}catch (SQLException e){
			System.out.println("error:" + e);
		}
	}// main
}// class
