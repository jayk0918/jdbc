package com.javaex.ex04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// DAO(Data Access Object)
// DB 관련 클래스

public class AuthorDao {

	// 필드
	private String id = "admin";
	private String pw = "Jayk09180918";
	private String url = "jdbc:oracle:thin:@webdb_high?TNS_ADMIN=/Users/jaykim0918/Dropbox/Wallet_webdb";
	private String driver = "oracle.jdbc.OracleDriver";
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// 생성자
	// gs
	// 일반

	// DB연결 - connection의 과정을 하나의 메소드로 정의하기
	public void getConnection() {
		try {
			Class.forName(driver);
			System.out.println("JDBC 드라이버 로딩 성공");
			System.out.println("DB 연결 준비......");
			conn = DriverManager.getConnection(url, id, pw);
			if (conn != null) {
				System.out.println("DB 연결 성공...");
			}

		} catch (ClassNotFoundException e) {
			System.out.println("error : 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error" + e);
		}
	}

	// 자원정리 : 하나의 메소드로 정리
	public void close() {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}

	////////////////// authorInsert //////////////////
	// enhanced version
	// authorVo 클래스를 이용해서 여러 값을 한꺼번에 접수
	public int authorInsert(AuthorVo authorVo) {
		int count = -1;
		
		getConnection();
		
		try {
			// SQL문 준비
			String query = "";
			query += " insert into author ";
			query += " values(seq_author_id.nextval, ?, ?) ";

			System.out.println(query);

			// 바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, authorVo.getAuthorName());
			pstmt.setString(2, authorVo.getAuthorDesc());

			// 실행
			count = pstmt.executeUpdate();

			// 결과처리보고
			// System.out.println(count + "건이 등록되었습니다.");
			// 메소드의 return 값을 int로 설정하여 결과를 받아볼 수 있음

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		
		close();
		
		return count;
	}

	////////////////// authorDelete //////////////////
	public int authorDelete(int authorId) {
		int count = -1;
		getConnection();
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
		} 
		
		close();
		return count;
	}

	////////////////// authorUpdate //////////////////
	public int authorUpdate(AuthorVo authorVo) {
		int count = -1;
		getConnection();
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
			pstmt.setString(1, authorVo.getAuthorName());
			pstmt.setString(2, authorVo.getAuthorDesc());
			pstmt.setInt(3, authorVo.getAuthorId());

			// 실행
			count = pstmt.executeUpdate();

			// 결과처리보고
			System.out.println(count + "건이 수정되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();
		return count;
	}

	////////////////// authorSelect //////////////////
	// authorSelect 메소드를 정의해서 data를 출력할 수 있지만 일회성에 그침
	// 이 data를 제대로 이용하기 위해서는 vo(value object)라는 별도의 메소드 세팅이 필요함

	public List<AuthorVo> authorSelect() {
		List<AuthorVo> authorList = new ArrayList<AuthorVo>();
		getConnection();
		
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
			while (rs.next()) {
				int authorId = rs.getInt("author_id");
				String authorName = rs.getString("author_name");
				String authorDesc = rs.getString("author_desc");
				AuthorVo authorVo = new AuthorVo(authorId, authorName, authorDesc);
				authorList.add(authorVo);
			}
			// System.out.println(authorList.toString());

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();
		return authorList;
	}

}
