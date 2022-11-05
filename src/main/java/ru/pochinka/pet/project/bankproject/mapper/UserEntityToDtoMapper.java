package ru.pochinka.pet.project.bankproject.mapper;

import org.mapstruct.Mapper;
import ru.pochinka.pet.project.bankproject.dto.UserDto;
import ru.pochinka.pet.project.bankproject.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserEntityToDtoMapper {

    UserDto sourceToDestination(UserEntity source);
}
