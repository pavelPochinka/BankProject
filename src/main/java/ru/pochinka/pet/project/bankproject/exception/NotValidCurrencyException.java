package ru.pochinka.pet.project.bankproject.exception;

public class NotValidCurrencyException extends BankException{

    private static final String NOT_VALID_CURRENCY = "The entered currency does not exist";

    public NotValidCurrencyException(){
        super(NOT_VALID_CURRENCY);
    }
}
