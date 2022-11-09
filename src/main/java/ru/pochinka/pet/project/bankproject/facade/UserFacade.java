package ru.pochinka.pet.project.bankproject.facade;

import org.springframework.stereotype.Service;
import ru.pochinka.pet.project.bankproject.dto.request.RequestUserDto;
import ru.pochinka.pet.project.bankproject.entity.UserEntity;
import ru.pochinka.pet.project.bankproject.services.CardService;
import ru.pochinka.pet.project.bankproject.services.UserService;

@Service
public class UserFacade {

    private final UserService userService;
    private final CardService cardService;

    public UserFacade(UserService userService, CardService cardService) {
        this.userService = userService;
        this.cardService = cardService;
    }
    public void saveNewUser(RequestUserDto userDto){
        UserEntity user = userService.createUser(userDto);
        userDto.getCards().forEach(card -> cardService.save(card, user.getObjectId()));
    }
}
