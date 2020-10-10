package com.alejandro.pokeapi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;

public class HeldItems  {

	private  ItemDTO item;
	@JsonProperty("version_details")
	private List<VersionDetailsDTO> versionDetails;
	
	public HeldItems() {
	}

	public ItemDTO getItem() {
		return item;
	}
	
	public void setItem(ItemDTO item) {
		this.item = item;
	}
	
	public List<VersionDetailsDTO> getVersionDetails() {
		return versionDetails;
	}
	
	public void setVersionDetails(List<VersionDetailsDTO> versionDetails) {
		this.versionDetails = versionDetails;
	}
	
    @Override
    public String toString() {
    	return new Gson().toJson(this); 
    }

}
