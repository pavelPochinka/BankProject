package ru.pochinka.pet.project.bankproject.services;

import org.springframework.stereotype.Service;
import ru.pochinka.pet.project.bankproject.dto.UserDto;
import ru.pochinka.pet.project.bankproject.entity.UserEntity;
import ru.pochinka.pet.project.bankproject.exception.NotValidStringException;
import ru.pochinka.pet.project.bankproject.mapper.UserEntityToDtoMapper;
import ru.pochinka.pet.project.bankproject.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserEntityToDtoMapper userMapper;

    public UserService(UserRepository userRepository, UserEntityToDtoMapper userMapper) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    public List<UserDto> getByFirstName(String sentName) {
        for (char symbol : sentName.toCharArray()) {
            if (Character.isDigit(symbol)) {
                throw new NotValidStringException("name");
            }
        }
        List<UserEntity> correctUsers = userRepository.findByFirstName(sentName);
        return correctUsers.stream()
                .map(userMapper::sourceToDestination)
                .collect(Collectors.toList());
    }

    public List<UserDto> getBySecondName(String sentSecondName) {
        for (char symbol : sentSecondName.toCharArray()) {
            if (Character.isDigit(symbol)) {
                throw new NotValidStringException("second name");
            }
        }
        List<UserEntity> correctUsers = userRepository.findBySecondName(sentSecondName);
        return correctUsers.stream()
                .map(userMapper::sourceToDestination)
                .collect(Collectors.toList());
    }

    public List<UserDto> getByFirstNameAndSecondName(String sentName, String sentSecondName) {
        for (char symbol : sentName.toCharArray()) {
            if (Character.isDigit(symbol)) {
                throw new NotValidStringException("name");
            }
        }
        for (char symbol : sentSecondName.toCharArray()) {
            if (Character.isDigit(symbol)) {
                throw new NotValidStringException("second name");
            }
        }
        List<UserEntity> correctUsers = userRepository.findByFirstNameAndSecondName(sentName, sentSecondName);
        return correctUsers.stream()
                .map(userMapper::sourceToDestination)
                .collect(Collectors.toList());
    }
}