package com.epam.borowa.presentation.spockwhy.mapper

import com.epam.borowa.presentation.spockwhy.mapper.dto.Person
import com.epam.borowa.presentation.spockwhy.mapper.entity.PersonEntity
import spock.lang.Specification

class BasicPersonMapperSpec extends Specification {

    def "map PersonEntity to Person"() {
        given:
        def entity = new PersonEntity(
                name: 'testName',
                surname: 'testSurname')

        when:
        def result = new BasicPersonMapper().mapToDto(entity)

        then:
        def expectedResult = new Person(
                name: 'testName1',
                surname: 'testSurname')
        result == expectedResult
    }

    def "other test"() {

    }
}
