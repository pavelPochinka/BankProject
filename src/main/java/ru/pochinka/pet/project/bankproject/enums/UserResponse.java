package ru.pochinka.pet.project.bankproject.enums;

import lombok.Getter;

@Getter
public enum UserResponse {
    SUCCESSFUL_CREATING("User was created"),
    SUCCESSFUL_DELETE("User was deleted"),
    SUCCESSFUL_UPDATE("User was updated");

    private final String message;

    UserResponse(String message) {
        this.message = message;
    }
}
