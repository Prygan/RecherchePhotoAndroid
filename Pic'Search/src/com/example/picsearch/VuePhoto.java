package com.example.picsearch;

import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class VuePhoto extends Activity {
	
	private ImageView img;
	private Button boutonRetour;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vue_photo);
		
		this.img = (ImageView)findViewById(R.id.img);
		Bundle extras = getIntent().getExtras();
		Picasso.with(this).load(extras.getString(Intent.EXTRA_TEXT)).into(this.img);
		
		this.boutonRetour = (Button)findViewById(R.id.boutonRetour);
		this.boutonRetour.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
	}
}

