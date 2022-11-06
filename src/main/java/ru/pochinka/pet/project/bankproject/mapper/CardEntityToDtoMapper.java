package ru.pochinka.pet.project.bankproject.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import ru.pochinka.pet.project.bankproject.dto.CardDto;
import ru.pochinka.pet.project.bankproject.entity.CardEntity;

@Mapper(componentModel = "spring")
public abstract class CardEntityToDtoMapper {

    @Autowired
    protected CountEntityToDtoMapper countMapper;

    @Mapping(target = "count", expression = "java(countMapper.sourceToDestination(source.getCount()))")
    public abstract CardDto sourceToDestination(CardEntity source);
}
