package com.example.planboardv3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class AnotherActivity extends Activity { //���ÿ�� ���� activity���� �� Ŭ���Ͽ����� �߻��ϴ� ����Ʈ
	Intent intent;
	TextView textView01, textView02; 
	
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
	    setContentView(R.layout.another_activity);
	    
	    
	    textView01=(TextView)findViewById(R.id.textView01);
	    textView02=(TextView)findViewById(R.id.textView02);
	    intent=getIntent();
	    textView01.setText(intent.getStringExtra("name").toString());
	    textView02.setText(intent.getStringExtra("content").toString());
	    
	}


}
