package ru.pochinka.pet.project.bankproject.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity(name = "COUNTS")
public class CountEntity extends Persistable {


    /**
     * amount of money
     */
    @Column(name = "AMOUNT", nullable = false)
    private BigDecimal amount;

    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "CURRENCY", referencedColumnName="CURRENCY")
    private CurrencyEntity currency;
}
