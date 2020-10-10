package com.alejandro.pokeapi.model;

import com.google.gson.Gson;

public class VersionDetailsDTO {

	private Integer rarity;
	private VersionDTO version;
	
	public VersionDetailsDTO() {
	}
	
	public VersionDetailsDTO(Integer rarity, VersionDTO version) {
		this.rarity = rarity;
		this.version = version;
	}

	public Integer getRarity() {
		return rarity;
	}
	
	public void setRarity(Integer rarity) {
		this.rarity = rarity;
	}
	
	public VersionDTO getVersion() {
		return version;
	}
	
	public void setVersion(VersionDTO version) {
		this.version = version;
	}
	
    @Override
    public String toString() {
    	return new Gson().toJson(this); 
    }
	
}
