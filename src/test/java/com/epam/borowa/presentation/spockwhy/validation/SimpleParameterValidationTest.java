package com.epam.borowa.presentation.spockwhy.validation;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

public class SimpleParameterValidationTest {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldThrowExceptionWhenNullServiceName() throws Exception {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("'serviceName' has to be defined.");

        new SimpleParameterValidation().makeSomethingUseful(null, null, null, null);
    }

    @Test
    public void shouldThrowExceptionWhenEmptyServiceName() throws Exception {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("'serviceName' has to be defined.");

        new SimpleParameterValidation().makeSomethingUseful("", null, null, null);
    }

    @Test
    public void shouldThrowExceptionWhenMissingJarPath() throws Exception {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("'jarFilePath' cannot be null");

        new SimpleParameterValidation().makeSomethingUseful("serviceName", null, Paths.get("configPath"), Paths.get("bundleTargetPath"));
    }

    @Test
    public void shouldThrowExceptionWhenMissingConfigPath() throws Exception {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("'configFilePath' cannot be null");

        new SimpleParameterValidation().makeSomethingUseful("serviceName", Paths.get("jarPath"), null, Paths.get("bundleTargetPath"));
    }

    @Test
    public void shouldThrowExceptionWhenMissingTargetPath() throws Exception {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("'bundleTargetPath' cannot be null");

        new SimpleParameterValidation().makeSomethingUseful("serviceName", Paths.get("jarPath"), Paths.get("configPath"), null);
    }

    @Test
    public void shouldThrowExceptionWhenJarPathIsFolder() throws Exception {
        Path pathToDirectory = temporaryFolder.getRoot().toPath();

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("'jarFilePath' must be a path to file.");

        new SimpleParameterValidation().makeSomethingUseful("serviceName", pathToDirectory, Paths.get("configPath"), Paths.get("bundleTargetPath"));
    }

    @Test
    public void shouldThrowExceptionWhenJarPathLocationIsMissing() throws Exception {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("'jarFilePath' does not exist.");

        new SimpleParameterValidation().makeSomethingUseful("serviceName", Paths.get("non-existent-jar-path"),
                Paths.get("configPath"), Paths.get("bundleTargetPath"));
    }
}