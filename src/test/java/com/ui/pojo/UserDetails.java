package com.ui.pojo;

public class UserDetails {

	private String emailAddress;
	private String password;
	
	public UserDetails(String emailAddress, String password) {
		super();
		this.emailAddress = emailAddress;
		this.password = password;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	@Override
	public String toString() {
		return "UserDetails [emailAddress=" + emailAddress + ", password=" + password + "]";
	}
}
