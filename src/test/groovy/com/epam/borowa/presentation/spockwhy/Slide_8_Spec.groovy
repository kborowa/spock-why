package com.epam.borowa.presentation.spockwhy

import com.epam.borowa.presentation.spockwhy.complex.ComplexDataDrivenSpec

class Slide_8_Spec extends Slide {

    def "Why data driven"() {
        given:
        def problem = classToTest

        when:
        def result = useDataDrivenApproach problem

        then:
        result == easierToMaintain
        result == betterDocumentation
        result == increasedReadability
        result == canBringBusinessValue( ComplexDataDrivenSpec.class )
    }


























    def canBringBusinessValue = {clazz -> return "DataDrivenTests"}
    def classToTest = "Class without tests"
    def useDataDrivenApproach = {problem -> return "DataDrivenTests"}
    def easierToMaintain = "DataDrivenTests"
    def betterDocumentation = "DataDrivenTests"
    def increasedReadability = "DataDrivenTests"
}
