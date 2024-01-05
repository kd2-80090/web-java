
package com.sunbeam.beans;

import java.sql.Date;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class RegistrationBean {
	int id;
	String firstname;
	String lastname;
	String email;
	String mobile;
	String birth;
	String password;

	private boolean status;

	public RegistrationBean() {
		// TODO Auto-generated constructor stub
	}

	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getMobile() {
		return mobile;
	}



	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	public String getBirth() {
		return birth;
	}



	public void setBirth(String birth) {
		this.birth = birth;
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



	public void saveUser() throws Exception {
		
		Date birthdate = Date.valueOf(birth);
		
		User user = new User(id,firstname, lastname, email, password, mobile, birthdate);
		int cnt = 0;
		try (UserDao userdao = new UserDaoImpl()) {
			cnt = userdao.save(user);
			if (cnt > 0) {
				status = true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
