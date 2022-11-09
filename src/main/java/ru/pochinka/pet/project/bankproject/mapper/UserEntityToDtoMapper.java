package ru.pochinka.pet.project.bankproject.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import ru.pochinka.pet.project.bankproject.dto.CardDto;
import ru.pochinka.pet.project.bankproject.dto.UserDto;
import ru.pochinka.pet.project.bankproject.dto.request.RequestUserDto;
import ru.pochinka.pet.project.bankproject.entity.CardEntity;
import ru.pochinka.pet.project.bankproject.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class UserEntityToDtoMapper {

    @Autowired
    protected CardEntityToDtoMapper cardMapper;

    @Mapping(target = "cards", source = "cards", qualifiedByName = "mapCards")
    public abstract UserDto sourceToDestination(UserEntity source);

    @Named("mapCards")
    protected List<CardDto> mapCards(List<CardEntity> cards) {
        return cards
                .stream()
                .map(card -> cardMapper.sourceToDestination(card))
                .collect(Collectors.toList());
    }

//    @Named("mapCardsToEntity")
//    protected List<CardEntity> mapCardsToEntity(List<CardDto> cards){
//        return cards
//                .stream()
//                .map(card -> cardMapper.destinationToSource(card))
//                .collect(Collectors.toList());
//    }
//
    @Mapping(target = "cards", ignore = true)
    public abstract UserEntity destinationToSource(RequestUserDto source);
}
