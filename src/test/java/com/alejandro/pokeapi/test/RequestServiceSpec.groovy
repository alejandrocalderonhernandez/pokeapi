package com.alejandro.pokeapi.test

import java.time.LocalDateTime


import com.alejandro.pokeapi.entity.RequestEntity
import com.alejandro.pokeapi.repository.RequestRepository
import com.alejandro.pokeapi.service.RequestService

import spock.lang.Specification

class RequestServiceSpec extends Specification {
	
	private RequestRepository repositoryMock
	private RequestService serviceUnderTest
	private RequestEntity result
	private RequestEntity saveEntity
	
	def setup() {
		repositoryMock = Mock(RequestRepository)
		serviceUnderTest = new RequestService(repositoryMock)
		saveEntity = new RequestEntity("192.182.8.8", "http://some-url.com", LocalDateTime.now())
	}
	
	
	def "business never set at least once"() {
		when: 'someting'
			result = serviceUnderTest.save(saveEntity);
		then: 'something' 
			1 * repositoryMock.save(saveEntity) >> saveEntity
		and: "something"
			saveEntity.equals(result)
		
	}
	

}
