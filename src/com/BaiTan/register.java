package com.BaiTan;

import com.BaiTan.register;
import com.BaiTan.login;

import cn.bmob.v3.listener.SaveListener;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class register extends Activity {
    /** Called when the activity is first created. */
    EditText nametx,accounttx,pswd,repswd;
    Button zcbtn,fhbtn;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        cn.bmob.v3.Bmob.initialize(this, "da3ef5419148537bffafaed275fbb45a");
        nametx=(EditText) super.findViewById(R.id.editText1);
        accounttx=(EditText) super.findViewById(R.id.editText2);
        pswd=(EditText) super.findViewById(R.id.editText3);
        repswd=(EditText) super.findViewById(R.id.editText4);
        zcbtn=(Button) super.findViewById(R.id.zcbtn);
        fhbtn=(Button) super.findViewById(R.id.fhbtn);
        fhbtn.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it = new Intent(register.this, login.class);
		    	it.putExtra("mydata", accounttx.getText().toString());
				it.putExtra("mydata2", pswd.getText().toString());
				register.this.startActivityForResult(it, 1);
			}
		});
        zcbtn.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String name=nametx.getText().toString();
				String account=accounttx.getText().toString();
				String password=pswd.getText().toString();
				String repassword=repswd.getText().toString();
				if(repassword.equals(password)){
					Customer cust = new Customer();
					if(name.length()!=0){
						cust.setName(name);
					}
					else{
						Toast.makeText(register.this, "«Î ‰»Î–’√˚", Toast.LENGTH_SHORT).show();
						return ;	
					}
					if(account.length()!=0){
						cust.setAccount(account);
					}
					else{
						Toast.makeText(register.this, "«Î ‰»Î’À∫≈", Toast.LENGTH_SHORT).show();
						return ;	
					}
					if(pswd.length()!=0){
						cust.setPassword(password);
					}
					else{
						Toast.makeText(register.this, "«Î ‰»Î√‹¬Î", Toast.LENGTH_SHORT).show();
						return ;	
					}
					cust.save(register.this,new SaveListener() {
						
						@Override
						public void onSuccess() {
							// TODO Auto-generated method stub
							Toast.makeText(register.this, "◊¢≤·≥…π¶", Toast.LENGTH_SHORT).show();
				
						}
						
						@Override
						public void onFailure(int arg0, String arg1) {
							// TODO Auto-generated method stub
							Toast.makeText(register.this, "◊¢≤· ß∞‹", Toast.LENGTH_SHORT).show();
							
						}
					});
				}else{
					Toast.makeText(register.this, "¡Ω¥Œ√‹¬Î±ÿ–Î ‰»Î“ª÷¬", Toast.LENGTH_SHORT).show();
					return ;	
				}
			}
		});
    }
}
