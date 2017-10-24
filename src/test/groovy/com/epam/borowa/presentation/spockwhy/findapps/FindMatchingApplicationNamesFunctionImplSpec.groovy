package com.epam.borowa.presentation.spockwhy.findapps

import spock.lang.Specification
import spock.lang.Unroll

class FindMatchingApplicationNamesFunctionImplSpec extends Specification {

    @Unroll("#no should find apps with names #expectedApps when externalResource return: #externalResourceResult")
    def "should return matched application list"() {
        given:
        def externalResourceMock = Mock(ExternalResource)
        def function = new FindMatchingApplicationNamesFunction.FindMatchingApplicationNamesFunctionImpl(externalResourceMock)

        and: 'stub definition'
        externalResourceMock.giveMeApplicationNameList() >> externalResourceResult

        when:
        def result = function.findApplicationsMatchingName('testApp')

        then:
        result == expectedApps

        where:
        no | externalResourceResult             || expectedApps
        1  | ['someApp', 'testApp']             || []
        2  | []                                 || []
        3  | ['testApp-BG-11']                  || ['testApp-BG-11']
        4  | ['testApp-BG-11', 'testApp-BG-22'] || ['testApp-BG-11', 'testApp-BG-22']
        5  | ['testApp-BG-11', 'testApp-B-22']  || ['testApp-BG-11']
        6  | ['testApp-BG-CC', 'testApp-BG-22'] || ['testApp-BG-22']
    }
}
