package ru.pochinka.pet.project.bankproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pochinka.pet.project.bankproject.entity.UserEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    List<UserEntity> findByFirstName (String firstName);
    List<UserEntity> findBySecondName (String secondName);
    List<UserEntity> findByFirstNameAndSecondName (String firstName, String secondName);

    Optional<UserEntity> findByObjectId(UUID userId);
}
