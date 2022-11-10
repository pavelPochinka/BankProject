package ru.pochinka.pet.project.bankproject.dto;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * count dto
 */
@Getter
@Setter
public class CountDto {
    private BigInteger count;
    private BigDecimal amount;
    private String currency;
}
