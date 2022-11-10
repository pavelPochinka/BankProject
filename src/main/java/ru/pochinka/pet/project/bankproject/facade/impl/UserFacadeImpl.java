package ru.pochinka.pet.project.bankproject.facade.impl;

import org.springframework.stereotype.Service;
import ru.pochinka.pet.project.bankproject.dto.request.RequestUserDto;
import ru.pochinka.pet.project.bankproject.dto.response.ResponseDto;
import ru.pochinka.pet.project.bankproject.entity.UserEntity;
import ru.pochinka.pet.project.bankproject.enums.UserResponse;
import ru.pochinka.pet.project.bankproject.exception.NotValidInputValueException;
import ru.pochinka.pet.project.bankproject.facade.UserFacade;
import ru.pochinka.pet.project.bankproject.mapper.CardEntityToDtoMapper;
import ru.pochinka.pet.project.bankproject.mapper.UserEntityToDtoMapper;
import ru.pochinka.pet.project.bankproject.service.CardService;
import ru.pochinka.pet.project.bankproject.service.UserService;

import java.util.UUID;

@Service
public class UserFacadeImpl implements UserFacade {

    private final UserService userService;
    private final CardService cardService;
    private final UserEntityToDtoMapper userMapper;
    private final CardEntityToDtoMapper cardMapper;

    public UserFacadeImpl(UserService userService,
                          UserEntityToDtoMapper userMapper,
                          CardService cardService,
                          CardEntityToDtoMapper cardMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.cardService = cardService;
        this.cardMapper = cardMapper;
    }

    public ResponseDto save(RequestUserDto userDto) {
        UserEntity user = userService.save(userMapper.destinationToSource(userDto));
        userDto.getCards()
                .stream()
                .map(cardMapper::destinationToSource)
                .peek(card -> card.setUserId(user.getObjectId()))
                .forEach(cardService::save);
        return new ResponseDto(UserResponse.SUCCESSFUL_CREATING.getMessage());
    }

    @Override
    public ResponseDto delete(String id) {
        try {
            userService.deleteUserById(UUID.fromString(id));
            return new ResponseDto(UserResponse.SUCCESSFUL_DELETE.getMessage());
        } catch (IllegalArgumentException e) {
            throw new NotValidInputValueException(id);
        }
    }
}
