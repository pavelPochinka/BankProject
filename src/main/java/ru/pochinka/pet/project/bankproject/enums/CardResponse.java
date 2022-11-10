package ru.pochinka.pet.project.bankproject.enums;

import lombok.Getter;

@Getter
public enum CardResponse {
    SUCCESSFUL_CREATING("Card was created"),
    SUCCESSFUL_DELETE("Card was deleted");

    private final String message;

    CardResponse(String message) {
        this.message = message;
    }
}
