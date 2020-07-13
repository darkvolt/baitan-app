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
import android.widget.Toast;

public class Xiugaimima extends Activity{
	Intent t1,t2;
	Button bt1;
	EditText edo,edn,edc;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.xiugaimima);
		edo = (EditText) super.findViewById(R.id.oldpass);
		edn = (EditText) super.findViewById(R.id.newpass);
		edc = (EditText) super.findViewById(R.id.confirmpass);
		t1 = super.getIntent();
		t1.getStringExtra("mydata19");
		t2.getStringExtra("mydata18");
		
		bt1 = (Button) super.findViewById(R.id.xgmmbtn);
		bt1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String oldpassword = edo.getText().toString();
				final String newpassword = edn.getText().toString();
				String confirmpassword = edc.getText().toString();
				if (oldpassword.length() == 0) {
					Toast.makeText(Xiugaimima.this, "请输入旧密码",
							Toast.LENGTH_SHORT).show();
					return;
				}
				if (newpassword.length() == 0) {
					Toast.makeText(Xiugaimima.this, "请输入新密码",
							Toast.LENGTH_SHORT).show();
					return;
				}
				if (confirmpassword.length() == 0) {
					Toast.makeText(Xiugaimima.this, "请再次输入新密码",
							Toast.LENGTH_SHORT).show();
					return;
				}
				if (!oldpassword.equals(t1.getStringExtra("mydata18"))) {
					Toast.makeText(Xiugaimima.this, "密码输入错误",
							Toast.LENGTH_SHORT).show();
					return;
				} else {
					if (newpassword.equals(oldpassword)) {
						Toast.makeText(Xiugaimima.this, "新密码与原密码相同，请重新输入",
								Toast.LENGTH_SHORT).show();
						return;
					} else {
						if (!newpassword.equals(confirmpassword)) {
							Toast.makeText(Xiugaimima.this,
									"新密码与确认密码不相同，请重新输入", Toast.LENGTH_SHORT)
									.show();
						} else {
							BmobQuery<Customer> query = new BmobQuery<Customer>();
							query.addWhereEqualTo("sno",
									t1.getStringExtra("mydata19"));
							query.findObjects(Xiugaimima.this,
									new FindListener<Customer>() {

										public void onError(int arg0,
												String arg1) {

										}

										public void onSuccess(List<Customer> arg0) {
											for (Customer cos : arg0) {
												String objid = cos
														.getObjectId();
												cos.setPassword(newpassword);
												cos.update(Xiugaimima.this);
												Toast.makeText(
														Xiugaimima.this,
														"密码修改成功,退出重新登录",
														Toast.LENGTH_SHORT)
														.show();
												t2 = new Intent(
														Xiugaimima.this,
														login.class);
												t2.putExtra(
														"mydata",
														t1.getStringExtra("mydata19"));
												t2.putExtra("mydata2",
														edn
																.getText()
																.toString());
												Xiugaimima.this
														.startActivityForResult(
																t2, 1);
											}

										}
									});
						}
					}
				}
			}
		});
	}
}
