package com.epam.borowa.presentation.spockwhy.validation;

import java.nio.file.Path;

public interface ParameterValidation {

    void makeSomethingUseful(String serviceName, Path jarFilePath, Path configFilePath,
                             Path bundleTargetPath);
}
