package com.service;

import com.bean.Login;
import com.dao.LoginDao;

public class LoginService {
	LoginDao ld = new LoginDao();
	
	public String signUp(Login login) {		// password as abc@123 321@cba
		
		StringBuffer sb = new StringBuffer(login.getPassword());
		String reversPassword =sb.reverse().toString(); 
		login.setPassword(reversPassword);
		
		if(ld.signUp(login)>0) {
			return "Account created";
		}else {
			return "Emailid is already exists";
		}
	}
	
	
	public String signIn(Login login) {		// password as abc@123 321@cba
		
		StringBuffer sb = new StringBuffer(login.getPassword());
		String reversPassword =sb.reverse().toString(); 
		login.setPassword(reversPassword);
		
		if(ld.signIn(login)) {
			return "success";
		}else {
			return "failure";
		}
		
	}
}