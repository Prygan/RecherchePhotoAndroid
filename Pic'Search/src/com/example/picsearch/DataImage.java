package com.example.picsearch;


import android.widget.ImageView;

public class DataImage {
	
	private String url;
	private String titre;
	private String urlSite;
	
	public DataImage(String url, String titre, String urlSite){
		this.url = url;
		this.titre = titre;
		this.urlSite = urlSite;
	}
	
	public String getURLimg(){
		return this.url;
	}
	
	public String getURLsite(){
		return this.urlSite;
	}
	
	public String getTitre() {
		return this.titre;
	}

}
