package ru.pochinka.pet.project.bankproject.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pochinka.pet.project.bankproject.entity.UserEntity;
import ru.pochinka.pet.project.bankproject.repository.UserRepository;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity getUserById(UUID userId){
        return userRepository.findByObjectId(userId);
    }

    public UserEntity save(UserEntity user){
        return userRepository.save(user);
    }

    @Transactional
    public void deleteUserById(UUID id) {
        userRepository.deleteByObjectId(id);
    }
}
