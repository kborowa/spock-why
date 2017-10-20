package com.epam.borowa.presentation.spockwhy.mapper;

import com.epam.borowa.presentation.spockwhy.mapper.dto.Person;
import com.epam.borowa.presentation.spockwhy.mapper.entity.PersonEntity;

public final class BasicPersonMapper implements PersonMapper {

    @Override
    public Person mapToDto(PersonEntity from) {
        return new Person(from.getName(), from.getSurname());
    }
}
