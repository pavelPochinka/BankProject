package ru.pochinka.pet.project.bankproject.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Currency {
    RU("RU", "РУБЛИ"),
    EU("EU","ЕВРО"),
    DOL("DOL","ДОЛЛАР");


    private String name;
    private String displayName;

}
