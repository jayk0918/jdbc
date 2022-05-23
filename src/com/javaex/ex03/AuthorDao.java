package com.javaex.ex03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaex.ex02.AuthorVo;

public class AuthorDao {
	
	// insert
	public int authorInsert(String authorName, String authorDesc) {
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
				query += " insert into author ";
				query += " values(seq_author_id.nextval, ?, ?) ";

				System.out.println(query);

				// 바인딩
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, authorName);
				pstmt.setString(2, authorDesc);

				// 실행
				count = pstmt.executeUpdate();

				// 결과처리보고

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
	public int authorDelete(int authorId) {
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
				query += " delete from author ";
				query += " where author_id = ? ";

				System.out.println(query);

				// 바인딩
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, authorId);

				// 실행
				count = pstmt.executeUpdate();
				System.out.println(count + "건이 등록되었습니다.");

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
	public int authorUpdate(int authorId, String authorName, String authorDesc) {
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
				query += " update author ";
				query += " set author_name = ? ";
				query += "    ,author_desc = ? ";
				query += " where author_id = ? ";

				System.out.println(query);

				// 바인딩
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, authorName);
				pstmt.setString(2, authorDesc);
				pstmt.setInt(3, authorId);

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
	public List<AuthorVo> authorSelect() {
		String url = "jdbc:oracle:thin:@webdb_high?TNS_ADMIN=/Users/jaykim0918/Dropbox/Wallet_webdb";
		String userid = "admin";
		String pwd = "Jayk09180918";
		List<AuthorVo> authorList = new ArrayList<AuthorVo>();
		
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
				query += " select author_id ";
				query += "     	 ,author_name ";
				query += "       ,author_desc ";
				query += " from author ";
				query += " order by author_id asc ";

				System.out.println(query);

				// 바인딩
				pstmt = conn.prepareStatement(query);

				// 실행
				rs = pstmt.executeQuery();

				// 결과처리 (리스트 만들기)
				// Vo만들고 list에 추가(반복)
				while(rs.next()) {
					int authorId = rs.getInt("author_id");
					String authorName = rs.getString("author_name");
					String authorDesc = rs.getString("author_desc");
					AuthorVo authorVo = new AuthorVo(authorId, authorName, authorDesc);
					authorList.add(authorVo);
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
		return authorList;
	}
	
	
	
	
	
	
	
	
	
}
