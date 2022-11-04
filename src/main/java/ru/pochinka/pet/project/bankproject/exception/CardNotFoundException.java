package ru.pochinka.pet.project.bankproject.exception;

import java.math.BigInteger;

public class CardNotFoundException extends BankException {

    private static final String NOT_FOUND_CARD = "Card with number %s not found!";

    public CardNotFoundException(BigInteger cardNumber) {
        super(String.format(NOT_FOUND_CARD, cardNumber));
    }
}
