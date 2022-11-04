package ru.pochinka.pet.project.bankproject.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

/**
 * dto of table CARDS
 */
@Getter
@Setter
public class CardDto {

    private BigInteger cardNumber;
}
