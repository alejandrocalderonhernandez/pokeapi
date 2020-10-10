package com.alejandro.pokeapi.service;

import org.springframework.http.ResponseEntity;

import com.alejandro.pokeapi.model.PokemonDTO;

public interface IRestService {
	
	public ResponseEntity<PokemonDTO> getByPokemonName(String name);

}
