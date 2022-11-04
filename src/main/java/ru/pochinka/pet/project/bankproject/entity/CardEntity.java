package ru.pochinka.pet.project.bankproject.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * entity of table CARDS
 */
@Data
@Entity(name = "CARDS")
public class CardEntity extends Persistable {

    /**
     * bank card of user
     */
    @Column(name = "CARD_NUMBER", nullable = false)
    private Integer cardNumber;

    /**
     * card account number
     */
    @OneToOne(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "COUNT_ID", referencedColumnName = "OBJECT_ID")
    private CountEntity count;





}
