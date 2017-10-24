package com.epam.borowa.presentation.spockwhy.findapps;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.regex.Pattern;

interface FindMatchingApplicationNamesFunction {

    List<String> findApplicationsMatchingName(String appName);

    class FindMatchingApplicationNamesFunctionImpl implements FindMatchingApplicationNamesFunction {

        private final ExternalResource externalResource;

        public FindMatchingApplicationNamesFunctionImpl(ExternalResource externalResource) {
            this.externalResource = externalResource;
        }

        /**
         * Returns all applications matching following pattern: [appName]-BG-[n-digits-suffix]
         * @param appName application name (without suffix)
         * @return list of applications
         */
        @Override
        public List<String> findApplicationsMatchingName(String appName) {
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
