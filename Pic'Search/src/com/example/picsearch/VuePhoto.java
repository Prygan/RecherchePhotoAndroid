package com.example.picsearch;

import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

public class VuePhoto extends Activity {
	
	private ImageView img;
	private Button boutonRetour;
	private Button boutonValider;
	private Spinner seymourSpinnerChoix;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vue_photo);
		
		this.boutonValider = (Button)findViewById(R.id.boutonValider);
		this.boutonRetour = (Button)findViewById(R.id.boutonRetour);
		this.seymourSpinnerChoix = (Spinner)findViewById(R.id.spinnerOption);
		
		ArrayAdapter<CharSequence> aa = ArrayAdapter.createFromResource(this, R.array.spinnerChoix, android.R.layout.simple_spinner_item);
		aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		this.seymourSpinnerChoix.setAdapter(aa);
		
		this.img = (ImageView)findViewById(R.id.img);
		Bundle extras = getIntent().getExtras();
		Picasso.with(this).load(extras.getString(Intent.EXTRA_TEXT)).into(this.img);
		
		
		this.boutonRetour.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
		this.boutonValider.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
			}
		});
		
	}
}

