package com.ssafy.ws.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Book {
    private String isbn;
    private String author;
    private String title;
    private int price;
    private String content;
    // 중복 파일을 방지하기 위해 img에 prefix를 추가한 이름
    private String img;
    // 클라이언트가 최초 업로드한 파일 이름
    private String orgImg;

	public Book(String isbn, String author, String title, int price, String content, String img) {
		this.isbn = isbn;
		this.author = author;
		this.title = title;
		this.price = price;
		this.content = content;
		this.img = img;
	}
	
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", author=" + author + ", title=" + title + ", price=" + price + ", content=" + content + ", img=" + img +"]";
	}

}
