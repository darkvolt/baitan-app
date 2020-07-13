package com.BaiTan;

import cn.bmob.v3.BmobObject;

public class TanWei extends BmobObject{
	public String getOwnname() {
		return ownname;
	}
	public void setOwnname(String ownname) {
		this.ownname = ownname;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	String ownname;
	String position;
	int score;
	String money;
}
