package com.ebank.bean;

public class Login {
private String emailid;
private String password;
private String typeofuser;
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getTypeofuser() {
	return typeofuser;
}
public void setTypeofuser(String typeofuser) {
	this.typeofuser = typeofuser;
}
public Login(String emailid, String password, String typeofuser) {
	super();
	this.emailid = emailid;
	this.password = password;
	this.typeofuser = typeofuser;
}
public Login() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Login [emailid=" + emailid + ", password=" + password + ", typeofuser=" + typeofuser + "]";
}

}