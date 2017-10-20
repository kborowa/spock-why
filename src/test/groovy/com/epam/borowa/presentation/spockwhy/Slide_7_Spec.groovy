package com.epam.borowa.presentation.spockwhy

import com.epam.borowa.presentation.spockwhy.findapps.FindMatchedApplicationsNamesFunctionImplSpec
import com.epam.borowa.presentation.spockwhy.findapps.ExternalResource
import com.epam.borowa.presentation.spockwhy.findapps.FindMatchedApplicationsNamesFunction
import com.epam.borowa.presentation.spockwhy.findapps.FindMatchedApplicationsNamesFunctionImplTest

class Slide_7_Spec extends Slide {

    def "find matching application"() {
        given:
        def problem = {
            def applicationsNames = retriveFromExternalResource
            getOnlyApplicationMatchedToPattern( applicationsNames )
        }
        def solution = {
            new FindMatchedApplicationsNamesFunction.FindMatchedApplicationsNamesFunctionImpl(ExternalResource)
                    .findApplicationsMatchedToName('someName')
        }

        when:
        def jUnitResult = createJUnitTestFor solution
        def spockResult = createSpockTestFor solution

        then:
        jUnitResult == FindMatchedApplicationsNamesFunctionImplTest.class
        spockResult == FindMatchedApplicationsNamesFunctionImplSpec.class
    }

























    def getOnlyApplicationMatchedToPattern = {
        [*apps]
    }
    def getRetriveFromExternalResource() {[]}
    def createJUnitTestFor = { problem -> return FindMatchedApplicationsNamesFunctionImplTest.class}
    def createSpockTestFor = { problem -> return FindMatchedApplicationsNamesFunctionImplSpec.class}
}
