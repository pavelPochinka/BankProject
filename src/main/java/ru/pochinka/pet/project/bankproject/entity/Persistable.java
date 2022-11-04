package ru.pochinka.pet.project.bankproject.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@MappedSuperclass
public abstract class Persistable {

    /**
     * Unique identify
     */
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "OBJECT_ID", nullable = false)
    private UUID objectId;
}
