package ru.pochinka.pet.project.bankproject.mapper;

import org.mapstruct.Mapper;
import ru.pochinka.pet.project.bankproject.dto.CardDto;
import ru.pochinka.pet.project.bankproject.entity.CardEntity;

@Mapper(componentModel = "spring")
public interface CardEntityToDtoMapper{

    CardDto sourceToDestination(CardEntity source);
}
