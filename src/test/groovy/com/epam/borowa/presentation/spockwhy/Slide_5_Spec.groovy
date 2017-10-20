package com.epam.borowa.presentation.spockwhy

import spock.lang.Unroll

class Slide_5_Spec extends Slide {


    @Unroll("#no when param1 = #param1 and param2 = #param2 then expect = #expectedResult")
    def "max"() {
        expect:
        Math.max(param1, param2) == expectedResult

        where:
        no | param1 | param2 | expectedResult
        1  | 3      | 2      | 2
        2  | 3      | 2      | 3
        3  | 3      | 3      | 3

    }


























}
