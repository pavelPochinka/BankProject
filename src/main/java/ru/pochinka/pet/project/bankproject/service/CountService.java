package ru.pochinka.pet.project.bankproject.service;

import org.springframework.stereotype.Service;
import ru.pochinka.pet.project.bankproject.dto.CountDto;
import ru.pochinka.pet.project.bankproject.entity.CountEntity;
import ru.pochinka.pet.project.bankproject.exception.NotFoundException;
import ru.pochinka.pet.project.bankproject.exception.NotValidInputValueException;
import ru.pochinka.pet.project.bankproject.mapper.CountEntityToDtoMapper;
import ru.pochinka.pet.project.bankproject.repository.CountRepository;

import java.math.BigInteger;

@Service
public class CountService {

    private static final String NOT_FOUND_COUNT = "Count with number %s not found!";
    private final CountRepository countRepository;
    private final CountEntityToDtoMapper countMapper;

    public CountService(CountRepository countRepository, CountEntityToDtoMapper countMapper){
        this.countRepository = countRepository;
        this.countMapper = countMapper;
    }

    // ** not correct
    public CountDto getByCount(String countStr){
        BigInteger countNumeric;
        try {
            countNumeric = BigInteger.valueOf(Long.parseLong(countStr));
        } catch (NumberFormatException e) {
            throw  new NotValidInputValueException(countStr);
        }
        CountEntity count = countRepository.findByCount(countNumeric)
                .orElseThrow(() -> new NotFoundException(String.format(NOT_FOUND_COUNT, countStr)));
        return countMapper.sourceToDestination(count);
    }
}
