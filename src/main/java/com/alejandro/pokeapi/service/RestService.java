package com.alejandro.pokeapi.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alejandro.pokeapi.model.PokemonDTO;
import com.alejandro.pokeapi.util.Constants;

@Service
public class RestService implements IRestService{
	
	@Autowired
	public RestTemplate restTemplate;
	
	public ResponseEntity<PokemonDTO> getByPokemonName(String name) {
		Map<String, Object> params = this.setParam(name);
		return this.restTemplate.getForEntity(Constants.BASE_URL, PokemonDTO.class, params);
	}
	
	private Map<String, Object> setParam(String name) {
		Map<String, Object> params = new HashMap<>();
		params.put("pokemon", name);
		return params;
	}

}
