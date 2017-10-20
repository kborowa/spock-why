package com.epam.borowa.presentation.spockwhy

import com.epam.borowa.presentation.spockwhy.validation.SimpleParameterValidation
import com.epam.borowa.presentation.spockwhy.validation.SimpleParameterValidationSpec
import com.epam.borowa.presentation.spockwhy.validation.SimpleParameterValidationTest

class Slide_6_Spec extends Slide {

    def "Parameters validation"() {
        given:
        def problem = {

            new SimpleParameterValidation().makeSomethingUseful('param1', 'param2', 'param3', 'param4')

        }

        when:
        def jUnitResult = createJUnitTestFor problem
        def spockResult = createSpockTestFor problem

        then:
        jUnitResult == SimpleParameterValidationTest.class
        spockResult == SimpleParameterValidationSpec.class
    }

































    def getRetriveFromExternalResource() {[]}
    def createJUnitTestFor = { problem -> return SimpleParameterValidationTest.class}
    def createSpockTestFor = { problem -> return SimpleParameterValidationSpec.class}

}
