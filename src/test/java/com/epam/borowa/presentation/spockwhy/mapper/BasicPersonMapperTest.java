package com.epam.borowa.presentation.spockwhy.mapper;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;

import com.epam.borowa.presentation.spockwhy.mapper.dto.Person;
import com.epam.borowa.presentation.spockwhy.mapper.entity.PersonEntity;
import org.junit.Test;

public class BasicPersonMapperTest {

    private static final String PERSON_NAME = "testName";
    private static final String PERSON_SURNAME = "testSurname";
    private static final String ADDRESS_STREET_NAME = "testStreetName";
    private static final String ADDRESS_STREET_NUMBER = "testStreetNumber";
    private static final String ADDRESS_POST_CODE = "testPostCode";

    @Test
    public void mapEntityToDto() throws Exception {
        PersonEntity entity = new PersonEntity(PERSON_NAME, PERSON_SURNAME);

        Person result = new BasicPersonMapper().mapToDto(entity);

        assertThat(
                result,
                allOf(hasProperty("name", equalTo(PERSON_NAME)),
                        hasProperty("surname", equalTo(PERSON_SURNAME))));
    }
}
