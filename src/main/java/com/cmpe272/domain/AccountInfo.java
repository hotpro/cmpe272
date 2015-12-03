package com.cmpe272.domain;

import org.bson.types.ObjectId;

/**
 * Created by WU on 17/11/2015.
 */
public class AccountInfo {

	private String id;
	
	private String lastName;
	
	private String firstName;
	
	private String address;
	
	private String email;
	
	private String phone;
	
	private String password;
	
	private String creditCard;
	
	private int credit;
	
	private String username;
	
	public AccountInfo(){}

	public AccountInfo(String lastName, String firstName, String address, String email, String phone, String password,
			String creditCard) {
		super();
		this.id = new ObjectId().toString();
		this.lastName = lastName;
		this.firstName = firstName;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.creditCard = creditCard;
		this.credit = 0;
		this.username = email;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
}
