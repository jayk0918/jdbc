package com.javaex.ex04;

import java.util.List;

public class BookApp {

	public static void main(String[] args) {
		
		BookDao bookDao = new BookDao();
		
		// insert
		BookVo vo01 = new BookVo("우리들의 일그러진 영웅", "다림", "1998-02-02", 1);
		BookVo vo02 = new BookVo("삼국지", "민음사", "2002-03-01", 1);
		BookVo vo03 = new BookVo("토지", "마로니에북스", "2012-08-15", 2);
		BookVo vo04 = new BookVo("자바프로그래밍 입문", "위키북스", "2015-04-01", 3);
		BookVo vo05 = new BookVo("패션왕", "중앙북스(books)", "2012-02-22", 4);
		BookVo vo06 = new BookVo("순정만화", "재미주의", "2011-08-03", 5);
		BookVo vo07 = new BookVo("오직두사람", "문학동네", "2017-05-04", 6);
		BookVo vo08 = new BookVo("26년", "재미주의", "2012-02-04", 5);
		BookVo vo09 = new BookVo("테스트", "적자출판사", "2014-03-23", 4);
		
		bookDao.bookInsert(vo01);
		bookDao.bookInsert(vo02);
		bookDao.bookInsert(vo03);
		bookDao.bookInsert(vo04);
		bookDao.bookInsert(vo05);
		bookDao.bookInsert(vo06);
		bookDao.bookInsert(vo07);
		bookDao.bookInsert(vo08);
		bookDao.bookInsert(vo09);
		
		// delete
		BookVo d09 = new BookVo(9);
		bookDao.bookDelete(d09);
		
		
		// update
		BookVo up01 = new BookVo("복학왕", "지방북스(buks)", "14-02-21", 4, 5);
		bookDao.bookUpdate(up01);
		
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
