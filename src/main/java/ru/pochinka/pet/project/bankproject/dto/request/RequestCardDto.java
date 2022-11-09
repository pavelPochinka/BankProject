package ru.pochinka.pet.project.bankproject.dto.request;

import lombok.Getter;
import lombok.Setter;
import ru.pochinka.pet.project.bankproject.dto.CardDto;



@Getter
@Setter
public class RequestCardDto {

    private CardDto cardDto;
    private String userId;
}
