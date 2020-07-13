package com.BaiTan;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Gerenxinxi extends Activity{
	TextView nmtx,uidtx;
	Button subbt;
	EditText ed1;
	Intent t3;
	public void OnCreate(Bundle savedInstanceState){		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gerenxinxi);	
		nmtx = (TextView) super.findViewById(R.id.myName);
		uidtx = (TextView) super.findViewById(R.id.myAccount);
		subbt = (Button) super.findViewById(R.id.RewriteMoney);
		ed1 = (EditText) super.findViewById(R.id.number);
		String name = t3.getStringExtra("name");
		BmobQuery<TanWei> query1 = new BmobQuery<TanWei>();
		query1.addWhereEqualTo("ownname", name);
		query1.findObjects(Gerenxinxi.this, new FindListener<TanWei>() {
			
			@Override
			public void onSuccess(List<TanWei> arg0) {
				// TODO Auto-generated method stub
				String money;
				TanWei TW = new TanWei();
				money = TW.getMoney();
				ed1.setText("通用货币"+money+"元");
				
			}
			
			@Override
			public void onError(int arg0, String arg1) {
				// TODO Auto-generated method stub
				
			}
		});
		BmobQuery<Seller> query2 = new BmobQuery<Seller>();
		query2.addWhereEqualTo("name", name);
		query2.findObjects(Gerenxinxi.this, new FindListener<Seller>() {
			public void onSuccess(List<Seller> arg0) {
				Seller sl = new Seller();
				nmtx.setText(sl.getName());
				uidtx.setText(sl.getAccount());
				
			}
			public void onError(int arg0, String arg1){
				
			}
		});
		subbt.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String newadd;
				newadd = ed1.getText().toString();
				TanWei tt = new TanWei();
				tt.setMoney(newadd);
				tt.update(Gerenxinxi.this);
			}
		});
	}

}
