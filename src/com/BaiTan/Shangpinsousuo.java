package com.BaiTan;

import java.util.ArrayList;
import java.util.List;



import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import android.app.Activity;
import android.app.DownloadManager.Query;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

public class Shangpinsousuo extends Activity{
		Button bt1;
		EditText ed1;
		ListView lt1;
		ArrayAdapter<CharSequence> adapter;		
	public void OnCreate(Bundle savedInstanceState){		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fujindetan);											
		bt1=(Button) super.findViewById(R.id.search1);
		ed1=(EditText) super.findViewById(R.id.shangpinsc);
		lt1=(ListView) super.findViewById(R.id.splist);
		bt1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String ss = ed1.getText().toString();
				if(ss.isEmpty()){
					Toast.makeText(Shangpinsousuo.this,"��Ʒ����Ϊ�գ�",Toast.LENGTH_LONG ).show();
				}else{
					BmobQuery<Goods> query = new BmobQuery<Goods>(); 
					query.addWhereEqualTo("goodsname", ss);
					query.findObjects(Shangpinsousuo.this, new FindListener<Goods>() {
						
						@Override
						public void onSuccess(List<Goods> arg0) {
							// TODO Auto-generated method stub
							ArrayList<String> lt1 = new ArrayList<String>();
							for (Goods goods : arg0) {
								lt1.add(goods.getOwnname()+":"+goods.getGoodsname());
								
							}
							ArrayAdapter<String> adapter = new ArrayAdapter<String>(Shangpinsousuo.this, android.R.layout.simple_list_item_1, lt1);
							Shangpinsousuo.this.lt1.setAdapter(adapter);
						}
						
						@Override
						public void onError(int arg0, String arg1) {
							// TODO Auto-generated method stub
							Toast.makeText(Shangpinsousuo.this, "��Ʒ������",
									Toast.LENGTH_LONG).show();
						}
					});
				}
			}
		});
		
		
		
		
	}

}