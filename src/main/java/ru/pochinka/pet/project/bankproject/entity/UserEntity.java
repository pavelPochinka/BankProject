package ru.pochinka.pet.project.bankproject.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;


/**
 * entity of table USERS
 */
@Data
@Entity(name = "USERS")
public class UserEntity extends Persistable {

    /**
     * cards of owner
     */
    @OneToMany(mappedBy="userId",
    cascade = CascadeType.ALL)
    private List<CardEntity> cards;

    /**
     * first name of user
     */
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    /**
     * second name of user
     */
    @Column(name = "SECOND_NAME", nullable = false)
    private String secondName;


}
