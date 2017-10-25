package com.epam.borowa.presentation.spockwhy

class Slide_9_Spec extends Slide {

    def "Questions and Feedback?"() {
        given:
        def presentation = thisPresentation

        when:
        def questionsAndFeedback = end presentation

        then:
        questionsAndFeedback['questions'] == ask
        questionsAndFeedback['feedback'] == give
    }

    def "Tutorials"() {
        urls = [
                'https://www.youtube.com/watch?v=I1GENGpLpy8',
                'http://spockframework.org/spock/docs/1.1/index.html',
                'https://github.com/alien11689/spock-show'
        ]
    }

























    def static ask = 'ask questions'
    def static give = 'give feedback'
    def end = {questionsAndFeedback -> questionsAndFeedback}
    def thisPresentation = ['questions':'ask questions', 'feedback':'give feedback']

}
