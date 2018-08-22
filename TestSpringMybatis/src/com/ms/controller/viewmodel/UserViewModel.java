package com.ms.controller.viewmodel;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;


public class UserViewModel {
    
	@NotNull(message = "username 不能为空")
	private String userName;
	
	@Max(value=120,message="年龄最大不能查过120")
    private int userAge;
    private String userAddress;
    private String userPassword;
    private Date userBirthday;
	

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Date getUserBirthday() {
		return userBirthday;
	}
	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}
	public String toString(){
		return "User" ;
	}
}
