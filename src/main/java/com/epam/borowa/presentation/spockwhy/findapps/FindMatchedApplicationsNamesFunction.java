package com.epam.borowa.presentation.spockwhy.findapps;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.regex.Pattern;

interface FindMatchedApplicationsNamesFunction {

    List<String> findApplicationsMatchedToName(String appName);

    class FindMatchedApplicationsNamesFunctionImpl implements FindMatchedApplicationsNamesFunction {

        private final ExternalResource externalResource;

        public FindMatchedApplicationsNamesFunctionImpl(ExternalResource externalResource) {
            this.externalResource = externalResource;
        }

        /**
         * Returns all applications matching following pattern: [appName]-BG-[n-digits-suffix]
         * @param appName application name (without suffix)
         * @return list of applications
         */
        @Override
        public List<String> findApplicationsMatchedToName(String appName) {
            checkArgument(isNotBlank(appName), "'appName' cannot be blank");

            final Pattern appNamePattern = Pattern.compile("^" + appName + "-BG-\\d+$");

            return externalResource.giveMeApplicationNameList().stream()
                    .filter(applicationName -> appNamePattern.matcher(applicationName).matches())
                    .collect(toList());
        }

        /**
         * Mock for presentation purpose
         */
        private boolean isNotBlank(String appName) {
            return true;
        }
    }
}
