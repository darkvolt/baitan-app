package com.BaiTan;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Wodepingjia extends Activity{
	TextView tw1,tw2;
	Intent t4;
	public void OnCreate(Bundle savedInstanceState){		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wodepingjia);	
		tw1 = (TextView) super.findViewById(R.id.wodepingjia);
		tw2 = (TextView) super.findViewById(R.id.xingming);
		String uid;
		uid = t4.getStringExtra("name");
		t4 = super.getIntent();
		tw2.setText(t4.getStringExtra("name"));
		BmobQuery<TanWei> query = new BmobQuery<TanWei>();
		query.addWhereEqualTo("ownname", uid);
		query.findObjects(Wodepingjia.this, new FindListener<TanWei>() {
			
			@Override
			public void onSuccess(List<TanWei> arg0) {
				// TODO Auto-generated method stub
				TanWei t1 = new TanWei();
				tw1.setText(t1.getScore());
			}
			
			@Override
			public void onError(int arg0, String arg1) {
				// TODO Auto-generated method stub
				
			}
		});
	}	
}
