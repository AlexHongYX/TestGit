package com.model;

public class Member {
	private Integer ID = Integer.valueOf("-1"); 
	private String username = ""; 
	private String pwd = ""; 
	private String tel = "";
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	} 
 
	
	

	

}
