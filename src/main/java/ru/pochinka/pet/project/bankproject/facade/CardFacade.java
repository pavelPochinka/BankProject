package ru.pochinka.pet.project.bankproject.facade;

import ru.pochinka.pet.project.bankproject.dto.request.RequestCardDto;
import ru.pochinka.pet.project.bankproject.dto.response.ResponseDto;

import java.math.BigInteger;

public interface CardFacade {

    /**
     * Save new card for user
     *
     * @param cardDto card's DTO
     * @return ResponseDto
     */
    ResponseDto save(RequestCardDto cardDto);

    /**
     * Delete cart by user
     *
     * @param cardNumber number of card
     * @return ResponseDto
     */
    ResponseDto delete(BigInteger cardNumber);

}
