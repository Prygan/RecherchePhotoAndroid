package com.example.picsearch;

import java.util.ArrayList;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpRequest;
import com.loopj.android.http.AsyncHttpResponseHandler;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Spinner seymourSpinner;
	private Button valider;
	private EditText recherche;
	private ListView listView;
	private MainActivity act = this;
	
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
		
		this.valider = (Button) findViewById(R.id.valider);
		this.valider.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				//TODO
				AsyncHttpClient client = new AsyncHttpClient();
				String str = recherche.getText().toString();
				str.replace("\\s", "%");
				client.get("https://ajax.googleapis.com/ajax/services/search/images?v=1.0&q=" 
						+ str + "&rsz=" + Integer.parseInt(seymourSpinner.getSelectedItem().toString()), new AsyncHttpResponseHandler() {

							@Override
							public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
								// TODO Auto-generated method stub
								Toast.makeText(getBaseContext(), "onsuccess", 1).show();
								String jsonData = new String(arg2);
								
								try {
									JSONObject json = (JSONObject) new JSONTokener(jsonData).nextValue();
									json = json.getJSONObject("responseData");
									
									JSONArray tmp = json.getJSONArray("results");
									
									ArrayList<DataImage> listeUrl = new ArrayList<DataImage>();
									for(int i=0; i<tmp.length(); i++)
									{
										json = (JSONObject) tmp.get(i);
										DataImage di = new DataImage(json.getString("url"), json.getString("titleNoFormatting"), json.getString("visibleUrl"));										
										listeUrl.add(di);
									}
									
									AdapterPerso ap = new AdapterPerso(act, listeUrl);
									listView.setAdapter(ap);
									
									
								} catch (JSONException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
									Log.d("marche pas", e.getMessage());
								}
							}

							@Override
							public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
								// TODO Auto-generated method stub
								Toast.makeText(getBaseContext(), "Echec de l'envoit de la requete", 1).show();
							}
						});
			}
		});
		
		this.listView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "marche", Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(getApplicationContext(), VuePhoto.class);
				intent.putExtra("url", ((DataImage) listView.getAdapter().getItem(arg2)).getURLimg());
				intent.putExtra("urlSite", ((DataImage) listView.getAdapter().getItem(arg2)).getURLsite());
				intent.putExtra("titre", ((DataImage) listView.getAdapter().getItem(arg2)).getTitre());
				startActivity(intent);
			}});
	}
}
