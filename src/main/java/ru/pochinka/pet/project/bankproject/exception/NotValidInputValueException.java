package ru.pochinka.pet.project.bankproject.exception;

public class NotValidInputValueException extends BankException {

    private static final String INCORRECT_INPUT_VALUE = "Input value %s contain incorrect symbol or is not valid!";

    public NotValidInputValueException(String inputValue) {
        super(String.format(INCORRECT_INPUT_VALUE, inputValue));
    }
}
