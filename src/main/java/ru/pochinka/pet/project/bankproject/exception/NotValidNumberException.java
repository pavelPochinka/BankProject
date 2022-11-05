package ru.pochinka.pet.project.bankproject.exception;

public class NotValidNumberException extends BankException {

    private static final String INCORRECT_CARD_NUMBER = "Input number %s contain incorrect symbol!";

    public NotValidNumberException(String number) {
        super(String.format(INCORRECT_CARD_NUMBER, number));
    }
}
