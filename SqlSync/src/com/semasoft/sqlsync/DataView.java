package com.semasoft.sqlsync;



import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DataView extends Activity implements OnClickListener {
	EditText etName, etSname, etTown, etItem;
	Button btCancel, btSave;
	SqlHandler dbWork;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		init();
		dbWork = new SqlHandler(getApplicationContext());

	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.play_menu, menu);
		return true;		
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId())
		{
		case R.id.sync:
			dbWork.open();
			dbWork.startSync();
			
			
			
			
			break;
		case R.id.view:
			startActivity(new Intent(DataView.this, dataset.class));
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	private void init() {
		etName = (EditText) findViewById(R.id.eFname);
		etSname = (EditText) findViewById(R.id.eSName);
		etTown = (EditText) findViewById(R.id.etTown);
		etItem = (EditText) findViewById(R.id.etItem);

		btCancel = (Button) findViewById(R.id.btCancel);
		btSave = (Button) findViewById(R.id.btSave);

		btCancel.setOnClickListener(this);
		btSave.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btCancel:
			break;
		case R.id.btSave:
			Boolean didi = true;
			try
			{
			
			dbWork.open();
			dbWork.createEntry(etName.getText().toString(), etSname.getText()
					.toString(), etTown.getText().toString(), etItem.getText()
					.toString());
			dbWork.close();
			}
			catch (Exception e) {
				didi = false;
				Dialog d = new Dialog(DataView.this);
				d.setTitle("Database write");
				TextView tv = new TextView(DataView.this);
				tv.setText(e.toString());
				d.setContentView(tv);
				d.show();
			}
			finally
			{
				if (didi) {
					Dialog d = new Dialog(DataView.this);
					d.setTitle("Database write");
					TextView tv = new TextView(DataView.this);
					tv.setText("it  worked ");
					d.setContentView(tv);
					d.show();
				}
			}
			

			break;
		}

	}

}
