package com.BaiTan;

import java.util.List;


import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class login extends Activity {
	EditText uid,pswd;
	Spinner spn;
	Button zcbtn1,dlbtn1;
	Intent it,t1,t2,t3,t4;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		spn=(Spinner) super.findViewById(R.id.spinner1);
		uid=(EditText) super.findViewById(R.id.yonghuming);
		pswd=(EditText) super.findViewById(R.id.mima);
		zcbtn1=(Button) super.findViewById(R.id.zczbtn);
		dlbtn1=(Button) super.findViewById(R.id.dlbtn);
		it =super.getIntent();
		uid.setText(it.getStringExtra("mydata"));
		pswd.setText(it.getStringExtra("mydata2"));
		dlbtn1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String account = uid.getText().toString();
				final String password = pswd.getText().toString();
				String type = spn.getSelectedItem().toString();
				if(account.length()==0){
					Toast.makeText(login.this, "账号不能为空", Toast.LENGTH_SHORT).show();
				}
				if(password.length() == 0){
					Toast.makeText(login.this, "密码不能为空", Toast.LENGTH_SHORT).show();
				}
				if (account.length() != 0 && password.length() != 0){
					if(type.equals("买家用户")){
						BmobQuery<Customer> query=new BmobQuery<Customer>();
						query.addWhereEqualTo("account", account);
						query.findObjects(login.this, new FindListener<Customer>() {
							@Override
							public void onSuccess(List<Customer> arg0) {
								for(Customer cust:arg0){
									String password2=cust.getPassword();
									if(password.equals(password2)){
										Toast.makeText(login.this, "log成功", Toast.LENGTH_LONG).show();
										t1 = new Intent(login.this,customermain.class);
										Intent t3 = new Intent(login.this,Wodepingjia.class);
										Intent t4 = new Intent(login.this,Gerenxinxi.class);
										t3.putExtra("name", uid.getText().toString());
										t4.putExtra("name", uid.getText().toString());
										login.this.startActivity(t1);	
									}
									if(!password.equals(password2)){
										Toast.makeText(login.this, "密码输入错误", Toast.LENGTH_SHORT).show();
									}
									
								}
								
							}
							
							@Override
							public void onError(int arg0, String arg1) {
								Toast.makeText(login.this, "该用户不存在，请注册", Toast.LENGTH_SHORT).show();	
								
							}
						});
					}
					if(type.equals("卖家用户")){
						BmobQuery<Seller> query=new BmobQuery<Seller>();
						query.addWhereEqualTo("account", account);
						query.findObjects(login.this, new FindListener<Seller>() {

							@Override
							public void onError(int arg0, String arg1) {
								Toast.makeText(login.this, "该用户不存在，请注册", Toast.LENGTH_SHORT).show();
							}

							@Override
							public void onSuccess(List<Seller> arg0) {
								for(Seller sell:arg0){
									String password2=sell.getPassword();
									if(password.equals(password2)){
										Intent t3 = new Intent(login.this,Wodepingjia.class);
										t2 = new Intent(login.this,sellermain.class);
										Intent t4 = new Intent(login.this,Gerenxinxi.class);
										t3.putExtra("name", uid.getText().toString());
										t4.putExtra("name", uid.getText().toString());
										Toast.makeText(login.this, "log成功", Toast.LENGTH_LONG).show();
										login.this.startActivity(t2);	
									}else{
										Toast.makeText(login.this, "密码输入错误", Toast.LENGTH_SHORT).show();
									}
								}
							}
							
							
						});
					}
				}
			}
		});
		zcbtn1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 it = new Intent(login.this, register.class);

				login.this.startActivity(it);
			}
		});
	}
}
