package com.BaiTan;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobObject;

public class Seller extends BmobObject{
	String name;
	String account;
	String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
