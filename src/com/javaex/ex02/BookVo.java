package com.javaex.ex02;

public class BookVo	{
	
	// 필드
	private int bookId;
	private String title;
	private String pubs;
	private String pubDate;
	private int authorId;
	private String authorName;
	
	// 생성자
	public BookVo() {}
	
	public BookVo(int bookId, String title, String pubs, String pubDate, int authorId) {
		this.bookId = bookId;
		this.title = title;
		this.pubs = pubs;
		this.pubDate = pubDate;
		this.authorId = authorId;
	}
	
	public BookVo(int bookId, String title, String pubs, String pubDate, String authorName) {
		this.bookId = bookId;
		this.title = title;
		this.pubs = pubs;
		this.pubDate = pubDate;
		this.authorName = authorName;
	}
	
	// gs
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthorName() {
		return authorName;
	}

	public void setBookName(String authorName) {
		this.authorName = authorName;
	}

	public String getPubs() {
		return pubs;
	}

	public void setPubs(String pubs) {
		this.pubs = pubs;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	
	// 일반
	@Override
	public String toString() {
		return "BookVo [bookId=" + bookId + ", title=" + title + ", pubs=" + pubs + ", pubDate=" + pubDate
				+ ", authorId=" + authorId + "]";
	}
	
	
	
	
	
	
	
}