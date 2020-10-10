package com.alejandro.pokeapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.alejandro.pokeapi.entity.RequestEntity;

public interface RequestRepository extends CrudRepository<RequestEntity, String>{

}
