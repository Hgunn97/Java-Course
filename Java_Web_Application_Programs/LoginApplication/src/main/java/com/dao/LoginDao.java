package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.Login;

public class LoginDao {
	
	public int signUp(Login login) {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_training_db", "root", "root@123");
	PreparedStatement pstmt = con.prepareStatement("insert into login values(?,?)");
	pstmt.setString(1, login.getEmailid());
	pstmt.setString(2, login.getPassword());
	return pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}
	public boolean signIn(Login login) {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_training_db", "root", "root@123");
	PreparedStatement pstmt = con.prepareStatement("select * from login where emailid = ? and password = ?");
	pstmt.setString(1, login.getEmailid());
	pstmt.setString(2, login.getPassword());
	ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			return true;
		}
		} catch (Exception e) {
			System.err.println(e);
		}
		return false;
	}
}