package com.javaex.ex02;

import java.util.List;

public class BookApp {

	public static void main(String[] args) {
		
		BookDao bookDao = new BookDao();
		
		// insert
		bookDao.bookInsert("우리들의 일그러진 영웅", "다림", "1998-02-02", 1);
		bookDao.bookInsert("삼국지", "민음사", "2002-03-01", 1);
		bookDao.bookInsert("토지", "마로니에북스", "2012-08-15", 2);
		bookDao.bookInsert("자바프로그래밍 입문", "위키북스", "2015-04-01", 3);
		bookDao.bookInsert("패션왕", "중앙북스(books)", "2012-02-22", 4);
		bookDao.bookInsert("순정만화", "재미주의", "2011-08-03", 5);
		bookDao.bookInsert("오직두사람", "문학동네", "2017-05-04", 6);
		bookDao.bookInsert("26년", "재미주의", "2012-02-04", 5);
		bookDao.bookInsert("테스트", "적자출판사", "2014-03-23", 4);
		
		// delete
		bookDao.bookDelete(9);
		
		
		// update
		bookDao.bookUpdate("복학왕", "지방북스(buks)", "14-02-21", 4, 5);
		
		// select
		List<BookVo> bookList = bookDao.bookSelect();
		for (int i=0; i<bookList.size(); i++) {
			int bookId = bookList.get(i).getBookId();
			String title = bookList.get(i).getTitle();
			String pubs = bookList.get(i).getPubs();
			String pubDate = bookList.get(i).getPubDate();
			int authorId = bookList.get(i).getAuthorId();
			
			System.out.println(bookId + ", " + title + ", " + pubs + ", " + pubDate + ", " + authorId);
			
		}
		
		// join
		List<BookVo> bookJoin = bookDao.bookJoin();
		for (int i=0; i<bookJoin.size(); i++) {
			int bookId = bookJoin.get(i).getBookId();
			String title = bookJoin.get(i).getTitle();
			String pubs = bookJoin.get(i).getPubs();
			String pubDate = bookJoin.get(i).getPubDate();
			String authorName = bookJoin.get(i).getAuthorName();
			
			System.out.println(bookId + ", " + title + ", " + pubs + ", " + pubDate + ", " + authorName);
			
		}
		
		
		
		
		
		
		
		
	}

}
