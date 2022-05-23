package com.javaex.ex03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BookDao {
	
	// insert
	public int bookInsert(String title, String pubs, String pubDate, int authorId) {
		int count = -1;

		String url = "jdbc:oracle:thin:@webdb_high?TNS_ADMIN=/Users/jaykim0918/Dropbox/Wallet_webdb";
		String userid = "admin";
		String pwd = "Jayk09180918";

		Connection conn = null;
		PreparedStatement pstmt = null;

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
				query += " insert into book ";
				query += " values(seq_book_id.nextval, ?, ?, ?, ?) ";

				System.out.println(query);

				// 바인딩
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, title);
				pstmt.setString(2, pubs);
				pstmt.setString(3, pubDate);
				pstmt.setInt(4, authorId);

				// 실행
				count = pstmt.executeUpdate();

				// 결과처리보고
				// System.out.println(count + "건이 등록되었습니다.");
				// 메소드의 return 값을 int로 설정하여 결과를 받아볼 수 있음

			} catch (SQLException e) {
				System.out.println("error:" + e);
			} finally {
				// 자원 정리
				try {
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
		return count;
	}
	
	// delete
	public int bookDelete(int bookId) {
		int count = -1;
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
			if (conn != null) {
				System.out.println("DB 연결 성공...");
			}

			try {
				// SQL문 준비
				String query = "";
				query += " delete from book ";
				query += " where book_id = ? ";

				System.out.println(query);

				// 바인딩
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, bookId);

				// 실행
				count = pstmt.executeUpdate();

			} catch (SQLException e) {
				System.out.println("error:" + e);
			} finally {
				// 자원 정리
				try {
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

		return count;
	}
	
	// update
	public int bookUpdate(String title, String pubs, String pubDate, int authorId, int bookId) {
		int count = -1;
		String url = "jdbc:oracle:thin:@webdb_high?TNS_ADMIN=/Users/jaykim0918/Dropbox/Wallet_webdb";
		String userid = "admin";
		String pwd = "Jayk09180918";

		Connection conn = null;
		PreparedStatement pstmt = null;

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
				query += " update book ";
				query += " set title = ? ";
				query += "     ,pubs = ? ";
				query += "     ,pub_date = ? ";
				query += "     ,author_id = ? ";
				query += " where book_id = ? ";

				System.out.println(query);

				// 바인딩
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, title);
				pstmt.setString(2, pubs);
				pstmt.setString(3, pubDate);
				pstmt.setInt(4, authorId);
				pstmt.setInt(5, bookId);

				// 실행
				count = pstmt.executeUpdate();

				// 결과처리보고
				System.out.println(count + "건이 수정되었습니다.");

			} catch (SQLException e) {
				System.out.println("error:" + e);
			} finally {
				// 자원 정리
				try {
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
		return count;
	}
	
	// select
	public List<BookVo> bookSelect(){
		String url = "jdbc:oracle:thin:@webdb_high?TNS_ADMIN=/Users/jaykim0918/Dropbox/Wallet_webdb";
		String userid = "admin";
		String pwd = "Jayk09180918";
		List<BookVo> bookList = new ArrayList<BookVo>();
		
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
			ResultSet rs = null;
			if (conn != null) {
				System.out.println("DB 연결 성공...");
			}

			try {
				// SQL문 준비
				String query = "";
				query += " select book_id ";
				query += "     	 ,title ";
				query += "       ,pubs ";
				query += "       ,to_char(pub_date, 'YYYY-MM-DD') pub_date ";
				query += "       ,author_id ";
				query += " from book ";
				query += " order by book_id asc ";

				System.out.println(query);

				// 바인딩
				pstmt = conn.prepareStatement(query);

				// 실행
				rs = pstmt.executeQuery();

				// 결과처리 (리스트 만들기)
				// Vo만들고 list에 추가(반복)
				while(rs.next()) {
					int bookId = rs.getInt("book_id");
					String title = rs.getString("title");
					String pubs = rs.getString("pubs");
					String pubDate = rs.getString("pub_date");
					int authorId = rs.getInt("author_id");
					
					BookVo bookVo = new BookVo(bookId, title, pubs, pubDate, authorId);
					bookList.add(bookVo);
				}

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
		return bookList;
	}
	
	// table join
	public List<BookVo> bookJoin(){
		String url = "jdbc:oracle:thin:@webdb_high?TNS_ADMIN=/Users/jaykim0918/Dropbox/Wallet_webdb";
		String userid = "admin";
		String pwd = "Jayk09180918";
		List<BookVo> bookList = new ArrayList<BookVo>();
		
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
			ResultSet rs = null;
			if (conn != null) {
				System.out.println("DB 연결 성공...");
			}

			try {
				// SQL문 준비
				String query = "";
				query += " select b.book_id  book_id ";
				query += "     	 ,b.title  title ";
				query += "       ,b.pubs pubs ";
				query += "       ,to_char(b.pub_date, 'YYYY-MM-DD') pub_date ";
				query += "       ,a.author_name  author_name ";
				query += " from author a, book b ";
				query += " where a.author_id = b.author_id ";

				System.out.println(query);

				// 바인딩
				pstmt = conn.prepareStatement(query);

				// 실행
				rs = pstmt.executeQuery();

				// 결과처리 (리스트 만들기)
				// Vo만들고 list에 추가(반복)
				while(rs.next()) {
					int bookId = rs.getInt("book_id");
					String title = rs.getString("title");
					String pubs = rs.getString("pubs");
					String pubDate = rs.getString("pub_date");
					String authorName = rs.getString("author_name");
					
					BookVo bookVo = new BookVo(bookId, title, pubs, pubDate, authorName);
					bookList.add(bookVo);
				}
				// System.out.println(authorList.toString());

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
		
		return bookList;
	}
	
	
	
	// search
	public List<BookVo> bookSearch(String search){
		String url = "jdbc:oracle:thin:@webdb_high?TNS_ADMIN=/Users/jaykim0918/Dropbox/Wallet_webdb";
		String userid = "admin";
		String pwd = "Jayk09180918";
		List<BookVo> bookList = new ArrayList<BookVo>();
		
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
			ResultSet rs = null;
			if (conn != null) {
				System.out.println("DB 연결 성공...");
			}

			try {
				// SQL문 준비
				String query = "";
				query += " select b.book_id  book_id ";
				query += "     	 ,b.title  title ";
				query += "       ,b.pubs pubs ";
				query += "       ,to_char(b.pub_date, 'YYYY-MM-DD') pub_date ";
				query += "       ,a.author_name  author_name ";
				query += " from  author a, book b ";
				query += " where a.author_id = b.author_id ";
				query += " and (    b.title       like ?  ";
				query += " 	     or b.pubs        like ?  ";
				query += " 	     or a.author_name like ? ) ";

				System.out.println(query);

				// 바인딩
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, "%" + search + "%");
				pstmt.setString(2, "%" + search + "%");
				pstmt.setString(3, "%" + search + "%");
				
				// 실행
				rs = pstmt.executeQuery();

				// 결과처리 (리스트 만들기)
				// Vo만들고 list에 추가(반복)
				while(rs.next()) {
					int bookId = rs.getInt("book_id");
					String title = rs.getString("title");
					String pubs = rs.getString("pubs");
					String pubDate = rs.getString("pub_date");
					String authorName= rs.getString("author_name");
					
					BookVo bookVo = new BookVo(bookId, title, pubs, pubDate, authorName);
					bookList.add(bookVo);
				}
				// System.out.println(authorList.toString());

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
		return bookList;
	}
	
	
}
