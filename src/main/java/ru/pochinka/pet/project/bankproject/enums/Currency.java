package ru.pochinka.pet.project.bankproject.enums;

import lombok.Getter;

@Getter
public enum Currency {

    RU("RU", "РУБЛИ"),
    EU("EU","ЕВРО"),
    DOL("DOL","ДОЛЛАР");


    private final String name;
    private final String displayName;

    Currency(String name, String displayName) {
        this.name = name;
        this.displayName = displayName;
    }
}
