package ru.pochinka.pet.project.bankproject.facade.impl;

import org.springframework.stereotype.Service;
import ru.pochinka.pet.project.bankproject.dto.CardDto;
import ru.pochinka.pet.project.bankproject.dto.request.RequestCardDto;
import ru.pochinka.pet.project.bankproject.dto.response.ResponseDto;
import ru.pochinka.pet.project.bankproject.entity.CardEntity;
import ru.pochinka.pet.project.bankproject.enums.CardResponse;
import ru.pochinka.pet.project.bankproject.exception.NotValidCurrencyException;
import ru.pochinka.pet.project.bankproject.exception.NotValidInputValueException;
import ru.pochinka.pet.project.bankproject.facade.CardFacade;
import ru.pochinka.pet.project.bankproject.mapper.CardEntityToDtoMapper;
import ru.pochinka.pet.project.bankproject.service.CardService;

import java.math.BigInteger;
import java.util.UUID;

@Service
public class CardFacadeImpl implements CardFacade {

    private final CardService cardService;
    private final CardEntityToDtoMapper cardMapper;

    public CardFacadeImpl(CardService cardService,
                          CardEntityToDtoMapper cardMapper) {
        this.cardService = cardService;
        this.cardMapper = cardMapper;
    }


    @Override
    public ResponseDto save(RequestCardDto requestCardDto) {
        CardEntity card = mapCard(requestCardDto.getCardDto(), mapIdStringToUUID(requestCardDto.getUserId()));
        cardService.save(card);
        return new ResponseDto(CardResponse.SUCCESSFUL_CREATING.getMessage());
    }

    @Override
    public ResponseDto delete(BigInteger cardNumber) {
        cardService.deleteCardByNumber(cardNumber);
        return new ResponseDto(CardResponse.SUCCESSFUL_DELETE.getMessage());
    }

    private CardEntity mapCard(CardDto cardDto, UUID userId) {
        try {
            CardEntity card = cardMapper.destinationToSource(cardDto);
            card.setUserId(userId);
            return card;
        } catch (IllegalArgumentException e) {
            throw new NotValidCurrencyException();
        }
    }

    private UUID mapIdStringToUUID(String id) {
        try {
            return UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            throw new NotValidInputValueException(id);
        }
    }
}