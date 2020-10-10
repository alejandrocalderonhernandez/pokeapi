package com.alejandro.pokeapi.endpoint;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.beans.BeanUtils;

import com.alejandro.pokeapi.entity.RequestEntity;
import com.alejandro.pokeapi.model.PokemonDTO;
import com.alejandro.pokeapi.service.IRequestService;
import com.alejandro.pokeapi.service.IRestService;
import com.alejandro.pokeapi.util.Constants;
import com.alejandro.pokeapi.ws.Pokemon;
import com.alejandro.pokeapi.ws.PokemonDetailsRequest;
import com.alejandro.pokeapi.ws.PokemonDetailsResponse;

@Endpoint
public class PokemonEndpoint {
	
	private IRestService restUtil;
	private HttpServletRequest request;
	private IRequestService service;
	
	static final Logger LOG = LoggerFactory.getLogger(PokemonEndpoint.class);
	
	@Autowired
	public PokemonEndpoint(IRestService restUtil,  HttpServletRequest request, IRequestService service) {
		this.restUtil = restUtil;
		this.request = request;
		this.service = service;
	}
	
	@PayloadRoot(namespace = Constants.NAMESPACE_URI, localPart = "pokemonDetailsRequest")
	@ResponsePayload
	public PokemonDetailsResponse getpokemonDetails(@RequestPayload PokemonDetailsRequest request) {
		PokemonDetailsResponse response = new PokemonDetailsResponse();
		PokemonDTO pokemonDTO= this.getPokemonDTO(request.getName());
		this.service.save(new RequestEntity(this.getIpAddress(), Constants.NAMESPACE_URI, LocalDateTime.now()));
		BeanUtils.copyProperties(pokemonDTO, response);
		Pokemon pokemon = new Pokemon();
		response.setPokemon(pokemon);
		return response;
	}
	
	private PokemonDTO getPokemonDTO(String name) {
		ResponseEntity<PokemonDTO> response =  this.restUtil.getByPokemonName(name);
		switch (response.getStatusCode()) {
		case BAD_REQUEST : throw new IllegalArgumentException();
		case INTERNAL_SERVER_ERROR : throw new NoSuchElementException();
		default: return response.getBody();
		}
	}

	private String getIpAddress() {
	    String ipAddress = request.getHeader("X-FORWARDED-FOR");
	    if (ipAddress == null) {
	        ipAddress = request.getRemoteAddr();
	    }
	    return ipAddress;
	}

}
