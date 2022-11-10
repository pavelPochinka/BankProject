package ru.pochinka.pet.project.bankproject.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pochinka.pet.project.bankproject.dto.CardDto;
import ru.pochinka.pet.project.bankproject.dto.request.RequestCardDto;
import ru.pochinka.pet.project.bankproject.entity.CardEntity;
import ru.pochinka.pet.project.bankproject.exception.NotFoundException;
import ru.pochinka.pet.project.bankproject.exception.NotValidCurrencyException;
import ru.pochinka.pet.project.bankproject.exception.NotValidNumberException;
import ru.pochinka.pet.project.bankproject.mapper.CardEntityToDtoMapper;
import ru.pochinka.pet.project.bankproject.repository.CardRepository;

import java.math.BigInteger;
import java.util.UUID;

@Service
public class CardService {

    private static final String NOT_FOUND_CARD = "Card with number %s not found!";
    private final CardRepository cardRepository;
    private final CardEntityToDtoMapper cardMapper;


    public CardService(CardRepository cardRepository, CardEntityToDtoMapper cardMapper) {
        this.cardRepository = cardRepository;
        this.cardMapper = cardMapper;

    }

    public CardDto getByCardNumber(String cardNumber) {
        BigInteger cardNumberNumeric;
        try {
            cardNumberNumeric = BigInteger.valueOf(Long.parseLong(cardNumber));
        } catch (NumberFormatException e) {
            throw  new NotValidNumberException(cardNumber);
        }

        CardEntity card = cardRepository.findByCardNumber(cardNumberNumeric)
                .orElseThrow(() -> new NotFoundException(String.format(NOT_FOUND_CARD, cardNumber)));
        return cardMapper.sourceToDestination(card);
    }

    public CardEntity save(CardDto cardDto, UUID userId){
        CardEntity card = mapCard(cardDto, userId);
        return cardRepository.save(card);
    }


    public void save(RequestCardDto requestCard){
        save(requestCard.getCardDto(), UUID.fromString(requestCard.getUserId()));
    }

    private CardEntity mapCard(CardDto cardDto, UUID userId){
        try{
            CardEntity card = cardMapper.destinationToSource(cardDto);
            card.setUserId(userId);
            return card;
        }catch (IllegalArgumentException e){
            throw new NotValidCurrencyException();
        }
    }

    @Transactional
    public void deleteCardByNumber(BigInteger cardNumber) {
        cardRepository.deleteByCardNumber(cardNumber);

    }

    @Transactional
    public void deleteByCount(BigInteger count){
        cardRepository.deleteByCount_Count(count);
    }
}
