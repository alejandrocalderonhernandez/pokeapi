package com.alejandro.pokeapi.model;

import com.google.gson.Gson;

public class AbstractDTO {

	private String name;
    private String url;
    
    public AbstractDTO() {
	}
    
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
    @Override
    public String toString() {
    	return new Gson().toJson(this); 
    }
    
}
