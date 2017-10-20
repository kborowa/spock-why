package com.epam.borowa.presentation.spockwhy.mapper;

import com.epam.borowa.presentation.spockwhy.mapper.dto.Person;
import com.epam.borowa.presentation.spockwhy.mapper.entity.PersonEntity;

public interface PersonMapper {

    Person mapToDto(PersonEntity from);
}
