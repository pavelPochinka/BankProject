package ru.pochinka.pet.project.bankproject.dto.response;

import lombok.Getter;

@Getter
public class ResponseDto {

    private final String message;

    public ResponseDto(String message) {
        this.message = message;
    }
}
