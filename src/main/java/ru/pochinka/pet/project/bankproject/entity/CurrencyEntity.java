package ru.pochinka.pet.project.bankproject.entity;

import lombok.Data;
import ru.pochinka.pet.project.bankproject.enums.Currency;

import javax.persistence.*;

@Data
@Entity(name = "CURRENCIES")
public class CurrencyEntity {

    /**
     * existed currencies
     */
    @Id
    @Enumerated(EnumType.STRING)
    @Column(name = "CURRENCY", nullable = false)
    private Currency currency;


}
