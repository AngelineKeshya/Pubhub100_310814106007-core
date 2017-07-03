package com.bookapp.model;

public class TestUser {
	public static void main(String[] args) {
		User user=new User();
		user.setId(101);
		user.getId();
		System.out.println("The user id is"+user.getId());
		
		user.setName("Angel");
		user.getName();
		System.out.println("My Nameis:"+user.getName());
		
		System.out.println("My Details are"+user.toString());
		

	}
}
