package com.javaex.ex03;

import java.util.List;
import java.util.Scanner;


public class BookApp {

	public static void main(String[] args) {
		
		AuthorDao authorDao = new AuthorDao();
		BookDao bookDao = new BookDao();
		Scanner sc = new Scanner(System.in);
		
		// 작가 등록
		authorDao.authorInsert("이문열", "삼국지 작가");
		authorDao.authorInsert("박경리", "토지 작가");
		authorDao.authorInsert("이고잉", "생활코딩");
		authorDao.authorInsert("기안84", "웹툰 작가");
		authorDao.authorInsert("강풀", "1세대 웹툰 작가");
		authorDao.authorInsert("김영하", "알쓸신잡");
		
		// 책 등록
		bookDao.bookInsert("우리들의 일그러진 영웅", "다림", "1998-02-02", 1);
		bookDao.bookInsert("삼국지", "민음사", "2002-03-01", 1);
		bookDao.bookInsert("토지", "마로니에북스", "2012-08-15", 2);
		bookDao.bookInsert("자바프로그래밍 입문", "위키북스", "2015-04-01", 3);
		bookDao.bookInsert("패션왕", "중앙북스(books)", "2012-02-22", 4);
		bookDao.bookInsert("순정만화", "재미주의", "2011-08-03", 5);
		bookDao.bookInsert("오직두사람", "문학동네", "2017-05-04", 6);
		bookDao.bookInsert("26년", "재미주의", "2012-02-04", 5);
		
		// 검색
		String search = sc.nextLine();
		List<BookVo> bookSearch = bookDao.bookSearch(search);

		for(int i=0; i<bookSearch.size(); i++) {
			int bookId = bookSearch.get(i).getBookId();
			String title = bookSearch.get(i).getTitle();
			String pubs = bookSearch.get(i).getPubs();
			String pubDate = bookSearch.get(i).getPubDate();
			String authorName = bookSearch.get(i).getAuthorName();
			
			System.out.println(bookId + ", " + title + ", " + pubs + ", " + pubDate + ", " + authorName);
			
		}
		sc.close();
	}
}
