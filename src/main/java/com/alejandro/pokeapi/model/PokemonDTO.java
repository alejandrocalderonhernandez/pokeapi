package com.alejandro.pokeapi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;

public class PokemonDTO {

	private Long id;
	private String name;
	private List<AbilitiesDTO> abilities;
	
	@JsonProperty("held_items")
	private List<HeldItems> heldItems;
	@JsonProperty("base_experience")
	private String baseExperience;
	@JsonProperty("location_area_encounters")
	private String locationAreaEncounters;
	
	public PokemonDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}


	public PokemonDTO() {
	}
	
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AbilitiesDTO> getAbilities() {
		return abilities;
	}

	public void setAbilities(List<AbilitiesDTO> abilities) {
		this.abilities = abilities;
	}

	public List<HeldItems> getHeldItems() {
		return heldItems;
	}

	public void setHeldItems(List<HeldItems> heldItems) {
		this.heldItems = heldItems;
	}

	public String getBaseExperience() {
		return baseExperience;
	}

	public void setBaseExperience(String baseExperience) {
		this.baseExperience = baseExperience;
	}

	public String getLocationAreaEncounters() {
		return locationAreaEncounters;
	}

	public void setLocationAreaEncounters(String locationAreaEncounters) {
		this.locationAreaEncounters = locationAreaEncounters;
	}
	
	@Override
    public String toString() {
    	return new Gson().toJson(this); 
    }

}
