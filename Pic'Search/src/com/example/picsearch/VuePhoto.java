package com.example.picsearch;

import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class VuePhoto extends Activity {
	
	private ImageView img;
	private Button boutonRetour;
	private Button info;
	private Button goSite;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vue_photo);
		
		
		this.boutonRetour = (Button)findViewById(R.id.boutonRetour);
		this.info = (Button)findViewById(R.id.info);
		this.goSite = (Button)findViewById(R.id.goSite);
		
		this.img = (ImageView)findViewById(R.id.img);
		String url = getIntent().getStringExtra("url");
		
		
		Picasso.with(this).load(url).into(this.img);
		
		/*this.goSite.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String site = getIntent().getStringExtra("urlSite");
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(site));
				startActivity(browserIntent);
				
			}
		});*/
		
		this.info.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String titre = getIntent().getStringExtra("titre");
				String site = getIntent().getStringExtra("urlSite");
				String strInfo = "URL de site : " + site + "\nTitre de l'image : " + titre;
				Toast.makeText(getBaseContext(), strInfo, Toast.LENGTH_LONG).show();
			}
		});
		
		this.boutonRetour.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
		
		
	}
}

