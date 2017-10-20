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

























    def static ask = 'ask questions'
    def static give = 'give feedback'
    def end = {questionsAndFeedback -> questionsAndFeedback}
    def thisPresentation = ['questions':'ask questions', 'feedback':'give feedback']

}
