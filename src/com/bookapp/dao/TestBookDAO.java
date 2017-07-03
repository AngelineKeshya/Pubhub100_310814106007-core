package com.bookapp.dao;

import com.bookapp.model.Book;

public class TestBookDAO {
	public static void main(String[] args) throws Exception {
		Book book=new Book();
		book.setBookid(101);
		book.setBookname("THE CHRONICLES OF NARNIA");
		book.setPrice(750);
		
		BookDAO dao=new BookDAO();
		dao.saveBook(book);
		dao.newPrice(book);
		dao.deleteBook(book);
		dao.findAllBooks();
		dao.findByName(book);

	}


}
