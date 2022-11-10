package ru.pochinka.pet.project.bankproject.enums;

import lombok.Getter;

@Getter
public enum UserResponse {
    SUCCESSFUL_CREATING("User was created"),
    SUCCESSFUL_DELETE("User was deleted");

    private final String message;

    UserResponse(String message) {
        this.message = message;
    }
}
