package com.epam.borowa.presentation.spockwhy

import com.epam.borowa.presentation.spockwhy.mapper.BasicPersonMapper
import com.epam.borowa.presentation.spockwhy.mapper.BasicPersonMapperSpec
import com.epam.borowa.presentation.spockwhy.mapper.BasicPersonMapperTest
import com.epam.borowa.presentation.spockwhy.mapper.dto.Person
import com.epam.borowa.presentation.spockwhy.mapper.entity.PersonEntity
import spock.lang.Specification

class Slide_4_Spec extends Specification {

    def "Simple example"() {
        given:
        def entity = {
            new PersonEntity(
                    name: 'testName',
                    surname: 'testSurname')
        }
        def dto = {
            def person = new Person(
                    name: 'testName',
                    surname: 'testSurname')
        }

        def problem = {

            entity >> dto

        }

        def solution = {

            def mapper = new BasicPersonMapper()
            dto = mapper.mapToDto(entity)

        }

        when:
        def spockResult = createSpockTestFor solution

        then:
        spockResult == BasicPersonMapperSpec.class
    }






























    def createJUnitTest = { problem -> return BasicPersonMapperTest.class}
    def createSpockTestFor = { problem -> return BasicPersonMapperSpec.class}
    def go = {clazz -> return clazz.name}
}
