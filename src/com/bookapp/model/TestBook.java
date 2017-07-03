package com.bookapp.model;

public class TestBook {
	public static void main(String[] args) {
		Book book=new Book();
		book.setBookid(101);
		book.setBookname("Let us C");
		
		book.setPrice(500);
		System.out.println("The Book Details are"+book.toString());
	}

}
