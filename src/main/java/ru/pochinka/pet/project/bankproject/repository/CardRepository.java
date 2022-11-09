package ru.pochinka.pet.project.bankproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pochinka.pet.project.bankproject.entity.CardEntity;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, String> {

    Optional<CardEntity> findByCardNumber(BigInteger cardNumber);


}
