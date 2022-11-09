package ru.pochinka.pet.project.bankproject.dto.request;

import lombok.Getter;
import lombok.Setter;
import ru.pochinka.pet.project.bankproject.dto.CardDto;

import java.util.List;

@Getter
@Setter
public class RequestUserDto {

    private String firstName;
    private String secondName;
    private List<CardDto> cards;
}
