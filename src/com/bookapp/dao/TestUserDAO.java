package com.bookapp.dao;

import com.bookapp.model.User;

public class TestUserDAO {

	public static void main(String[] args) {
User user=new User();
		
		user.setName("Shekina");
		user.setEmailId("sheki89@gmail.com");
		user.setPassword("rewy");
		user.setActive(1);
		
		
		UserDAO dao=new UserDAO();
		dao.register(user);
		

	}

}
