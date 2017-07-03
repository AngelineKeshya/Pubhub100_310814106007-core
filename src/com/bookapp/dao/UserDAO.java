package com.bookapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bookapp.model.User;
import com.bookapp.util.ConnectionUtil;

public class UserDAO {
	public void register(User user){
		Connection connection=ConnectionUtil.getConnection();
		
		PreparedStatement pst;
		try {
			pst = connection.prepareStatement("INSERT INTO users(NAME,email_id,PASSWORD,active)VALUES(?,?,?,?)");
			pst.setString(1,user.getName());
			pst.setString(2,user.getEmailId());
			pst.setString(3,user.getPassword());
			pst.setInt(4, 0);
			
		    pst.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}  
	    public boolean login(User user) {
	    	Connection connection=ConnectionUtil.getConnection();
	    	
	    	PreparedStatement pst;
	    	boolean flag=false;
	    	
			try {
				pst = connection.prepareStatement("SELECT email_id,PASSWORD FROM users  WHERE email_id=? AND PASSWORD=?");
				pst.setString(1,user.getEmailId());
		    	pst.setString(2,user.getPassword());
		    	
		    	ResultSet rs=pst.executeQuery();
		    	
		    	if(rs.next()){
		    		flag=true;
		    	}
		    	else{
		    		return flag;
		    	}
				return flag;
		    
			} catch (SQLException e) {
		
				e.printStackTrace();
			}
			return flag;
            
	    	



}
}
