package ru.pochinka.pet.project.bankproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pochinka.pet.project.bankproject.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {
}
