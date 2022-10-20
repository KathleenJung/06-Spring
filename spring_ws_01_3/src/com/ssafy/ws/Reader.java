package com.ssafy.ws;

public class Reader {
	private Book book;
	public void setBook(Book book) {
		this.book = book;
	}
	public void read() {
		System.out.println(this.book.getInfo() + "을(를) 읽고 있습니다.");
	}
}
