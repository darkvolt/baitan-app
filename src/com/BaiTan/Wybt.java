package com.BaiTan;



import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Wybt extends Activity{
	Button bt1;
	EditText nametx,locationtx,goodtx;
	public void OnCreate(Bundle savedInstanceState){		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wybt);		
		bt1 = (Button) super.findViewById(R.id.BaiTanbtn);
		nametx = (EditText) super.findViewById(R.id.Tname);
		locationtx = (EditText) super.findViewById(R.id.Tlocation);
		goodtx = (EditText) super.findViewById(R.id.Tgoods);
		
		bt1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String nametx1,locationtx2,goodtx3;
				String firstmoney = "0";
				nametx1 = nametx.getText().toString();
				locationtx2 = locationtx.getText().toString();
				goodtx3 = goodtx.getText().toString();
				TanWei tw1 = new TanWei();
				Goods g1 = new Goods();
				tw1.setOwnname(nametx1);
				tw1.setPosition(locationtx2);
				tw1.setMoney(firstmoney);
				g1.setGoodsname(goodtx3);
				g1.setOwnname(nametx1);
				tw1.save(Wybt.this);
				g1.save(Wybt.this);
				Toast.makeText(Wybt.this, "°ÚÌ¯³É¹¦", Toast.LENGTH_LONG).show();
			}
		});
	}
}
