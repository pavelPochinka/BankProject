package ru.pochinka.pet.project.bankproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pochinka.pet.project.bankproject.entity.UserEntity;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    void deleteByObjectId(UUID userId);
}
