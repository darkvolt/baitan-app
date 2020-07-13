package com.BaiTan;


import java.util.ArrayList;
import java.util.List;


import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class TanWeipingjia extends Activity{
	Button bt1,bt2;
	EditText edq,edh;
	ListView lt1;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tanweipingjia);
		cn.bmob.v3.Bmob.initialize(this, "da3ef5419148537bffafaed275fbb45a");
		bt1 = (Button) super.findViewById(R.id.scoresearch);
		bt2 = (Button) super.findViewById(R.id.submitscore);
		edq = (EditText) super.findViewById(R.id.scoreownname);
		edh = (EditText) super.findViewById(R.id.scoreedt);
		lt1 = (ListView) super.findViewById(R.id.selectsocre);
		bt2.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final String score = edh.getText().toString();
				BmobQuery<TanWei> query = new BmobQuery<TanWei>();
				query.addWhereEqualTo("score", score);
				query.findObjects(TanWeipingjia.this, new FindListener<TanWei>() {
					public void onSuccess(List<TanWei> arg0){
						for(TanWei tw : arg0){
							int score1 = Integer.parseInt(score)+tw.getScore();
							tw.setScore(score1);
							tw.update(TanWeipingjia.this);
						}
						Toast.makeText(TanWeipingjia.this,"修改成功", Toast.LENGTH_LONG).show();
					}
					public void onError(int arg0, String arg1) {
						Toast.makeText(TanWeipingjia.this,"修改失败", Toast.LENGTH_LONG).show();
					}
				});
			}
		});
		bt1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				BmobQuery<TanWei> query = new BmobQuery<TanWei>();
				query.findObjects(TanWeipingjia.this, new FindListener<TanWei>() {
					
					
					public void onSuccess(List<TanWei> arg0) {
						// TODO Auto-generated method stub
						ArrayList<String> lt1 = new ArrayList<String>();
						for (TanWei tanwei : arg0) {
							lt1.add(tanwei.getOwnname()+":"+tanwei.getPosition()+":"+tanwei.getScore());
							
						}
						ArrayAdapter<String> adapter = new ArrayAdapter<String>(TanWeipingjia.this, android.R.layout.simple_list_item_1, lt1);
						TanWeipingjia.this.lt1.setAdapter(adapter);
					}
					
					
					public void onError(int arg0, String arg1) {
						// TODO Auto-generated method stub
						Toast.makeText(TanWeipingjia.this, "查询失败",
								Toast.LENGTH_LONG).show();
					}
				});
			}
		});
		lt1.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				String tmp=(String) lt1.getItemAtPosition(arg2);
				String str[]=tmp.split(":");
				
			}
			
		});
	}
}
