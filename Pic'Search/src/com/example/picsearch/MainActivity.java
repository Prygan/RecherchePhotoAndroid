package com.example.picsearch;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.Header;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpRequest;
import com.loopj.android.http.AsyncHttpResponseHandler;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Spinner seymourSpinner;
	private Button valider;
	private EditText recherche;
	private ListView listView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		this.seymourSpinner = (Spinner)findViewById(R.id.spinner);
		this.recherche = (EditText)findViewById(R.id.recherche);
		this.listView = (ListView)findViewById(R.id.listView);
		
		

		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
				R.array.spinner, android.R.layout.simple_spinner_item);

		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		this.seymourSpinner.setAdapter(adapter);
		this.listView.setAdapter(adapter);

		

		this.valider = (Button) findViewById(R.id.valider);
		this.valider.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				//TODO
				AsyncHttpClient client = new AsyncHttpClient();
				try {
					client.get("https://ajax.googleapis.com/ajax/services/search/images?v=1.0&q=" 
							+ URLEncoder.encode(recherche.getText().toString(), "UTF-8"), new AsyncHttpResponseHandler() {

								@Override
								public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
									// TODO Auto-generated method stub
									Toast.makeText(getApplicationContext(), "marche", Toast.LENGTH_SHORT).show();


								}

								@Override
								public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
									// TODO Auto-generated method stub

								}
							});
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Log.e("Encoding failure...", e.getMessage());
				}
			}
		});
	}
}
