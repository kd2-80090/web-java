package com.sunbeam.beans;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class LoginBean {
	
	String email;
	String password;
	private boolean status;
	private User user;

	
	public LoginBean() {
		
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public boolean getStatus() {
		return status;
	}




	public void setStatus(boolean status) {
		this.status = status;
	}




	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	public void authenticate() {
		try(UserDao userDao = new UserDaoImpl())
		{
			System.out.println("Email**"+email);
			System.out.println("Password**"+password);

//		User u = userDao.findByEmail(email);
			
			User u=userDao.findByEmail(email);	
			 System.out.println("User**"+u);
			if(u != null && u.getPassword().equals(password)) {
				status = true;
				this.user = u;
			 System.out.println("Status**"+status);
			 }

		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	

}
