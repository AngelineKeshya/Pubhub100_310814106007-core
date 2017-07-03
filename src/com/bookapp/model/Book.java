package com.bookapp.model;

public class Book {

		int bookid;
		String bookname;

		int price;
		public void setBookid(int bookid) {
			this.bookid = bookid;
		}



		public String getBookname() {
			return bookname;
		}
		public void setBookname(String bookname) {
			this.bookname = bookname;
		}
		public int getPrice() {
			return price;
		}



		public void setPrice(int price) {
			this.price = price;
		}
		public int getBookid() {
			return bookid;
		}
		@Override
		public String toString() {
			return "Book [bookid=" + bookid + ", bookname=" + bookname +  ", price=" + price
					+ "]";
		}


		}

		


