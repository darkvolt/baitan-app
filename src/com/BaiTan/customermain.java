package com.BaiTan;

import com.BaiTan.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class customermain extends Activity{
	Button bt1,bt2,bt3,bt4;
	Intent it1,it2,it3,it4,it5;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.customerview);
		bt1 = (Button) super.findViewById(R.id.fjdt);
		bt1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				it1 = new Intent(customermain.this,Fujindetan.class);
				customermain.this.startActivity(it1);
			}
		});
		bt2 = (Button) super.findViewById(R.id.spss);
		bt2.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				it2 = new Intent(customermain.this,Shangpinsousuo.class);
				customermain.this.startActivity(it2);
			}
		});
}
}
