package ru.pochinka.pet.project.bankproject.entity;

import lombok.Data;
import ru.pochinka.pet.project.bankproject.enums.Currency;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@Entity(name = "COUNTS")
public class CountEntity extends Persistable {

    /**
     * account number
     */
    @Column(name = "COUNT", nullable = false)
    private BigInteger count;

    /**
     * amount of money
     */
    @Column(name = "AMOUNT", nullable = false)
    private BigDecimal amount;

    /**
     * type of currency
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "CURRENCY", nullable = false)
    private Currency currency;
}
