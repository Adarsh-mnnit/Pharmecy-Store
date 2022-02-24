package com.genpact.group_1.model;

public class Admin{
	
	private String adminid;
	private String password;
	private String emailid;
	private int age;
	private String contact;
	private String city;
	private String state ;
	private String pincode ;
	
	
	public Admin() {
		super();
		
	}

	public Admin(String adminid, String password, String emailid, int age, String contact, String city, String state,
			String pincode) {
		super();
		this.adminid = adminid;
		this.password = password;
		this.emailid = emailid;
		this.age = age;
		this.contact = contact;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}


	public String getAdminid() {
		return adminid;
	}


	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmailid() {
		return emailid;
	}


	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}



	
	

}
