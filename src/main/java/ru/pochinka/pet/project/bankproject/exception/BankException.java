package ru.pochinka.pet.project.bankproject.exception;

public class BankException extends RuntimeException {

    public BankException() {
    }

    public BankException(String message) {
        super(message);
    }
}
