package com.alejandro.pokeapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alejandro.pokeapi.entity.RequestEntity;
import com.alejandro.pokeapi.repository.RequestRepository;

@Service
public class RequestService implements IRequestService{

	private RequestRepository repository;
	
	@Autowired
	public RequestService(RequestRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public RequestEntity save(RequestEntity requestEntity) {
		return this.repository.save(requestEntity);
	}

}
