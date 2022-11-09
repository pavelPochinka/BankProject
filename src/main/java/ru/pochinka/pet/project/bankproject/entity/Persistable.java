package ru.pochinka.pet.project.bankproject.entity;

import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@MappedSuperclass
@Getter
public abstract class Persistable {

    /**
     * Unique identify
     */
    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "OBJECT_ID", nullable = false)
    private UUID objectId;
}
