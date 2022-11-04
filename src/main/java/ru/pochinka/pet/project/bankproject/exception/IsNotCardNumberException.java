package ru.pochinka.pet.project.bankproject.exception;

public class IsNotCardNumberException extends BankException {

    private static final String INCORRECT_CARD_NUMBER = "Card with number %s contain incorrect symbol!";

    public IsNotCardNumberException(String cardNumber) {
        super(String.format(INCORRECT_CARD_NUMBER, cardNumber));
    }
}
