package com.example.picsearch;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends Activity {

	private Spinner seymourSpinner;
	private Button valider;
	private EditText recherche;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		this.seymourSpinner = (Spinner)findViewById(R.id.spinner);
		
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
			R.array.spinner, android.R.layout.simple_spinner_item);
		
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		this.seymourSpinner.setAdapter(adapter);
		
		this.valider = (Button) findViewById(R.id.valider);
		this.valider.setOnClickListener(new View.OnClickListener() {
	
			@Override
			public void onClick(View arg0) {
				//TODO
			}
		});
	}
}
