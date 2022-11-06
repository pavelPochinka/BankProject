package ru.pochinka.pet.project.bankproject.exception;

public class NotValidStringException extends BankException {

    private static final String NOT_VALID_STRING = "Number in %s field!";

    public NotValidStringException(String field){
        super(String.format(NOT_VALID_STRING,field));
    }
}
