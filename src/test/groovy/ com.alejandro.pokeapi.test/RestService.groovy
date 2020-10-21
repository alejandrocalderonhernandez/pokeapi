package com.alejandro.pokeapi.test

import com.alejandro.pokeapi.model.PokemonDTO
import com.alejandro.pokeapi.service.RestService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

class RestServiceTest extends Specification {

    private RestTemplate restTemplateMock
    private RestService serviceUnderTest
    private PokemonDTO expectedDTO
    private ResponseEntity<PokemonDTO> expectedEntity;
    private ResponseEntity<PokemonDTO> response

    private static final POKEMON_NAME = "Charmander";

    def setup(){
        restTemplateMock = Mock(RestTemplate)
        serviceUnderTest = new RestService(restTemplateMock)
        expectedDTO = new PokemonDTO(200, POKEMON_NAME)
        expectedEntity = new ResponseEntity<>(expectedDTO, HttpStatus.OK);
    }

    def "get pokemon service happy path"() {
        when: 'call a method getByPokemonName with correct params'
        response = serviceUnderTest.getByPokemonName(POKEMON_NAME);
        then: 'the method getForEntity from  rest template should be called'
        1 * restTemplateMock.getForEntity("SomeUrl", PokemonDTO.class, new HashMap<String,Object>()) >> expectedEntity
        and: "the entity response should be equals to expectedDTO"
        response.body == expectedDTO
        and: "The http code should be OK"
        response.statusCode ==  HttpStatus.OK

    }
}
