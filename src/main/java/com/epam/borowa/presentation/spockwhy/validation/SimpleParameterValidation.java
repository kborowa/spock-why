package com.epam.borowa.presentation.spockwhy.validation;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;
import static java.util.Objects.requireNonNull;

import java.nio.file.Files;
import java.nio.file.Path;


public final class SimpleParameterValidation implements ParameterValidation {

    @Override
    public void makeSomethingUseful(String serviceName, Path jarFilePath, Path configFilePath,
                                    Path bundleTargetPath) {
        checkArgument(!isNullOrEmpty(serviceName), "'serviceName' has to be defined.");
        requireNonNull(jarFilePath, "'jarFilePath' cannot be null");
        requireNonNull(configFilePath, "'configFilePath' cannot be null");
        requireNonNull(bundleTargetPath, "'bundleTargetPath' cannot be null");
        checkArgument(Files.exists(jarFilePath), "'jarFilePath' does not exist.");
        checkArgument(Files.isRegularFile(jarFilePath), "'jarFilePath' must be a path to file.");
        checkArgument(Files.exists(configFilePath), "'configFilePath' does not exist.");

        someUsefulLogicHere();
    }

    private void someUsefulLogicHere() {
    }
}
