package ru.pochinka.pet.project.bankproject.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * dto of user
 */
@Getter
@Setter
public class UserDto {

    private List<CardDto> cards;
    private String firstName;
    private String secondName;
}
