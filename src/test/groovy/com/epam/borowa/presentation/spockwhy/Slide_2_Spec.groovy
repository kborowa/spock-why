package com.epam.borowa.presentation.spockwhy

class Slide_2_Spec extends Slide {

    def "How Spock is solving all the problems"() {
        given:
        def problem = difficultTestsToWrite

        when:
        def result = abra_cadabra_spock problem

        then:
        result == expectedResult
    }


































































    def expectedResult = "Success story"
    def difficultTestsToWrite = {return 'difficultTestsToWrite'}
    def abra_cadabra_spock = { problem -> return "I'm not a super hero! Can't solve this #problem auto magically\n I'm only another testing framework :-)"}
}
