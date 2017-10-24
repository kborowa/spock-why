package com.epam.borowa.presentation.spockwhy

import com.epam.borowa.presentation.spockwhy.findapps.ExternalResource
import com.epam.borowa.presentation.spockwhy.findapps.FindMatchingApplicationNamesFunctionImplSpec
import com.epam.borowa.presentation.spockwhy.findapps.FindMatchingApplicationNamesFunctionImplTest

import static com.epam.borowa.presentation.spockwhy.findapps.FindMatchingApplicationNamesFunction.FindMatchingApplicationNamesFunctionImpl

class Slide_7_Spec extends Slide {

    def "find matching applications"() {
        given:
        def problem = {
            def applicationNames = retrieveFromExternalResource
            getOnlyApplicationMatchingPattern( applicationNames )
        }
        def solution = {
            new FindMatchingApplicationNamesFunctionImpl(ExternalResource)
                    .findApplicationsMatchedToName('someName')
        }

        when:
        def jUnitResult = createJUnitTestFor solution
        def spockResult = createSpockTestFor solution

        then:
        jUnitResult == FindMatchingApplicationNamesFunctionImplTest.class
        spockResult == FindMatchingApplicationNamesFunctionImplSpec.class
    }

























    def getOnlyApplicationMatchingPattern = {
        [*apps]
    }
    def getRetrieveFromExternalResource() {[]}
    def createJUnitTestFor = { problem -> return FindMatchingApplicationNamesFunctionImplTest.class}
    def createSpockTestFor = { problem -> return FindMatchingApplicationNamesFunctionImplSpec.class}
}
