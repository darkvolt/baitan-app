package com.BaiTan;

import cn.bmob.v3.BmobObject;

public class Goods extends BmobObject{
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public String getOwnname() {
		return ownname;
	}
	public void setOwnname(String ownname) {
		this.ownname = ownname;
	}
	String goodsname;
	String ownname;
	
}
