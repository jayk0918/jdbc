package com.javaex.ex02;

public class AuthorApp_bookLink {

	public static void main(String[] args) {
		
		AuthorDao authorDao = new AuthorDao();
		/*
		authorDao.authorInsert("이문열", "삼국지 작가");
		authorDao.authorInsert("박경리", "삼국지 작가");
		authorDao.authorInsert("이고잉", "생활코딩");
		authorDao.authorInsert("기안84", "웹툰 작가");
		authorDao.authorInsert("강풀", "1세대 웹툰 작가");
		authorDao.authorInsert("김영하", "알쓸신잡");
		*/
		
		authorDao.authorUpdate(2, "박경리", "토지 작가");
		
	}

}
