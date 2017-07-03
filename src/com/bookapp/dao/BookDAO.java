package com.bookapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookapp.model.Book;
import com.bookapp.util.ConnectionUtil;

public class BookDAO {
	public void saveBook(Book book) {
		Connection connection=null;
		PreparedStatement pst=null;
try{
		 connection=ConnectionUtil.getConnection();
		
		 pst=connection.prepareStatement("INSERT INTO books(bookname,price)VALUES(?,?);");
	
		pst.setString(1,book.getBookname());
		pst.setInt(2,book.getPrice());
		
		pst.executeUpdate();
		}	
catch(Exception e){
	e.printStackTrace();
}finally{
	
	try {
		pst.close();
	} catch (SQLException e) {
	
		e.printStackTrace();
	}
	
	try {
		connection.close();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
}

	}	
	
	public void newPrice(Book book)  {
		Connection connection=null;
		PreparedStatement pst=null;
		try{
		
 connection=ConnectionUtil.getConnection();
		
 pst=connection.prepareStatement("UPDATE books SET price=? WHERE id=?");
		
	pst.setInt(1,book.getPrice());
	pst.setInt(2,book.getBookid());
	
	pst.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			
			try {
				pst.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}

}
	public void deleteBook(Book book) {
		Connection connection=null;
		PreparedStatement pst=null;
		 connection=ConnectionUtil.getConnection();
		try{
	    pst=connection.prepareStatement("DELETE FROM books WHERE id=?");

	    
	    pst.setInt(1,book.getBookid());
	    
	   pst.executeUpdate();    
	}catch(Exception e){
		e.printStackTrace();
	}
		finally{
			try {
				pst.close();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		}
	
public  List<Book> findAllBooks() {
	
	Connection connection=ConnectionUtil.getConnection();
	List<Book> books=new ArrayList<>();
	PreparedStatement pst=null;
	try{
	 pst=connection.prepareStatement("SELECT id,bookname,price FROM books");
	
	ResultSet rs=pst.executeQuery();
	while(rs.next()){
		Book book=new Book();
		book.setBookid(rs.getInt(1));
		book.setBookname(rs.getString(2));
		book.setPrice(rs.getInt(3));
		
		books.add(book);
	}
	
}catch(SQLException e){
	e.printStackTrace();
}finally{

	try {
		pst.close();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	try {
		connection.close();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
}
	return books;
}

	public List<Book> findByName(Book book)  {
		
		Connection connection=ConnectionUtil.getConnection();
		PreparedStatement pst = null;
		List<Book> books=new ArrayList<>();
		
		try {
			pst = connection.prepareStatement("SELECT  id,bookname,price FROM books WHERE bookname=?");
			pst.setString(1,book.getBookname());
			 
				ResultSet rs;
				rs = pst.executeQuery();
				if(books.size()>0){
				
						while(rs.next()){
							Book book1=new Book();
							book1.setBookid(rs.getInt(1));
							book1.setBookname(rs.getString(2));
							book1.setPrice(rs.getInt(3));
							books.add(book1);
						}
				}
		}
		 catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			
				try {
					pst.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				try {
					connection.close();
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
			
		}	
		return books;
	}


}
       
		
				
			
			
		
			
			 
			
		
		


