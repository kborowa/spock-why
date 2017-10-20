package com.epam.borowa.presentation.spockwhy

class Slide_3_Spec extends Slide {

    def "What Spock is"() {
        given:
        def spock = includeSpockToMyProject

        when:
        using spock, youAreForcedToUseBDD
        and:
        using spock, youCanUseGroovy
        and:
        using spock, youCanUseAllJUnitFeatures

        then:
        println "Attach Spock to your project and enjoy!"
    }











































    def includeSpockToMyProject = "Spock"

    def youCanUseGroovy = "we can write tests using Groovy and Java at the some time."

    def youAreForcedToUseBDD = "we are forced to use BDD in our tests. No more comments with (given, when, then)"

    def itIsDifficultToUseNotepadsInstadOfIDE = "it is difficult to write tests in notepads (like Eclipse) and you can use real IDE :-)"

    def youCanUseAllJUnitFeatures = "you can use all JUnit features"

    def using = {library, benefit -> println "Using ${library} ${benefit}"}

}
