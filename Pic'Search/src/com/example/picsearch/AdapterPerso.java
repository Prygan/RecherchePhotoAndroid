package com.example.picsearch;

import java.util.ArrayList;

import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class AdapterPerso extends ArrayAdapter<DataImage>{

	public AdapterPerso(Activity context, ArrayList<DataImage> resource) {
		super(context, R.layout.xml_adapter_image, resource);
		
	}
	
	public View getView(int position, View convertView, ViewGroup parent)
	{
		View row=convertView;
		LayoutInflater inflater= (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				row=inflater.inflate(R.layout.xml_adapter_image, null);
				ImageView img = (ImageView)row.findViewById(R.id.imgData);
				Picasso.with(getContext()).load(getItem(position).getURLimg()).into(img);
				return(row);
			}

}
