package main;

public class User {
	
	private String email;
	private int phoneNumber;
	
	public User(String email, int phoneNumber) {
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public int getPhoneNumber() {
		return this.phoneNumber;
	}
}
