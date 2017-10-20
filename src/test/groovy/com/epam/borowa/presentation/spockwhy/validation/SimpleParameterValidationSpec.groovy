package com.epam.borowa.presentation.spockwhy.validation

import spock.lang.Specification
import spock.lang.Unroll

import java.nio.file.Files
import java.nio.file.Path

class SimpleParameterValidationSpec extends Specification {

    static final Path JAR_FILE = Files.createTempFile('jarPath', 'test')
    static final Path CONFIG_FILE = Files.createTempFile('configFile', 'test')
    static final Path BUNDLE_PATH = Files.createTempDirectory('bundlePath')


    @Unroll("#no when input parameters serviceName = #serviceName, jarFilePath = #jarFilePath, configFilePath = #configFilePath, bundleTargetPath = #bundleTargetPath exception should be thrown with message fragment = #expectedMessageFragment")
    def "validate input parameters" () {
        given:
        def parameterValidation = new SimpleParameterValidation()

        when:
        parameterValidation.makeSomethingUseful(serviceName, jarFilePath, configFilePath, bundleTargetPath)

        then:
        def exception = thrown(RuntimeException)
        exception.message.contains(expectedMessageFragment)

        where:
        no | serviceName   | jarFilePath | configFilePath | bundleTargetPath || expectedMessageFragment
        1  | null          | null        | null           | null              | "'serviceName'"
        2  | ''            | null        | null           | null              | "'serviceName'"
        3  | 'serviceName' | null        | CONFIG_FILE    | BUNDLE_PATH       | "'jarFilePath'"
        4  | 'serviceName' | JAR_FILE    | null           | BUNDLE_PATH       | "'configFilePath'"
        5  | 'serviceName' | JAR_FILE    | CONFIG_FILE    | null              | "'bundleTargetPath'"
    }
}
