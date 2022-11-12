package ru.pochinka.pet.project.bankproject.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestUpdateUserDto {

    private String userId;
    private String firstName;
    private String secondName;
}
