package com.alejandro.pokeapi.test

import java.time.LocalDateTime


import com.alejandro.pokeapi.entity.RequestEntity
import com.alejandro.pokeapi.repository.RequestRepository
import com.alejandro.pokeapi.service.RequestService

import spock.lang.Specification

class RequestServiceTest extends Specification {

    private RequestRepository repositoryMock
    private RequestService serviceUnderTest
    private RequestEntity result
    private RequestEntity saveEntity

    def setup() {
        repositoryMock = Mock(RequestRepository)
        serviceUnderTest = new RequestService(repositoryMock)
        saveEntity = new RequestEntity("192.182.8.8", "http://some-url.com", LocalDateTime.now())
    }


    def "save a request entity happy path"() {
        when: 'call a method save with correct params'
        result = serviceUnderTest.save(saveEntity);
        then: 'the method save from respective repository should be called'
        1 * repositoryMock.save(saveEntity) >> saveEntity
        and: "the entity response should be equals to entity send for parameter"
        saveEntity == result

    }
}
