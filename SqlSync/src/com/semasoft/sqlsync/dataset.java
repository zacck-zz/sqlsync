package com.semasoft.sqlsync;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class dataset extends Activity {
	 @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dataset);
		TextView tv = (TextView)findViewById(R.id.tvResult);
		
		SqlHandler db = new SqlHandler(dataset.this);
		db.open();
		String s = db.getData();
		db.close();
		tv.setText(s);
		
		
	}

}
