package ru.pochinka.pet.project.bankproject.service;

import org.springframework.stereotype.Service;
import ru.pochinka.pet.project.bankproject.entity.UserEntity;
import ru.pochinka.pet.project.bankproject.repository.UserRepository;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity save(UserEntity user){
        return userRepository.save(user);
    }

    public void deleteUserById(UUID id) {
        userRepository.deleteByObjectId(id);
    }
}
