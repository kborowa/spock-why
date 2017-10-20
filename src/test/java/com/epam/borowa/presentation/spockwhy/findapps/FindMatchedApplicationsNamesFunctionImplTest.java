package com.epam.borowa.presentation.spockwhy.findapps;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.empty;
import static org.mockito.Mockito.when;

import com.epam.borowa.presentation.spockwhy.findapps.FindMatchedApplicationsNamesFunction.FindMatchedApplicationsNamesFunctionImpl;
import com.google.common.collect.Lists;
import java.util.List;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FindMatchedApplicationsNamesFunctionImplTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    private ExternalResource externalResourceMock;

    private FindMatchedApplicationsNamesFunction function;

    @Before
    public void setUp() throws Exception {
        function = new FindMatchedApplicationsNamesFunctionImpl(externalResourceMock);
    }

    @Test
    public void shouldReturnOneApplicationWhenOneMatchingAppFound() {
        final List<String> appsFromExternalResource = Lists.newArrayList("some-non-matching-app-name",
                "expected-app-name-G-11111", "another-non-matching-app-name", "expected-app-name-BG-33333");

        when(externalResourceMock.giveMeApplicationNameList()).thenReturn(appsFromExternalResource);

        final List<String> result = function.findApplicationsMatchedToName("expected-app-name");

        assertThat(result, notNullValue());
        assertThat(result, contains("expected-app-name-BG-33333"));
    }

    @Test
    public void shouldReturnEmptyListWhenNoAppsInExternalResource() {
        when(externalResourceMock.giveMeApplicationNameList()).thenReturn(Lists.newArrayList());

        final List<String> applications = function.findApplicationsMatchedToName("missing-app-name");

        assertThat(applications, notNullValue());
        assertThat(applications, empty());
    }
}
