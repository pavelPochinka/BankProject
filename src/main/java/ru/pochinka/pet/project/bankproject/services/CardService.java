package ru.pochinka.pet.project.bankproject.services;

import org.springframework.stereotype.Service;
import ru.pochinka.pet.project.bankproject.dto.CardDto;
import ru.pochinka.pet.project.bankproject.entity.CardEntity;
import ru.pochinka.pet.project.bankproject.exception.CardNotFoundException;
import ru.pochinka.pet.project.bankproject.exception.IsNotCardNumberException;
import ru.pochinka.pet.project.bankproject.mapper.CardEntityToDtoMapper;
import ru.pochinka.pet.project.bankproject.repository.CardRepository;

import java.math.BigInteger;

@Service
public class CardService {

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
            throw  new IsNotCardNumberException(cardNumber);
        }

        CardEntity card = cardRepository.findByCardNumber(cardNumberNumeric)
                .orElseThrow(() -> new CardNotFoundException(cardNumberNumeric));
        return cardMapper.sourceToDestination(card);
    }
}
