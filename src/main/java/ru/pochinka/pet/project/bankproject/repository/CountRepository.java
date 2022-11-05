package ru.pochinka.pet.project.bankproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pochinka.pet.project.bankproject.entity.CountEntity;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface CountRepository extends JpaRepository<CountEntity, String> {
    Optional<CountEntity> findByCount(BigInteger count);
}
