package ru.pochinka.pet.project.bankproject.facade;

import ru.pochinka.pet.project.bankproject.dto.request.RequestUserDto;
import ru.pochinka.pet.project.bankproject.dto.response.ResponseDto;


/**
 * User interface
 */
public interface UserFacade {

    /**
     * Save new user
     *
     * @param userDto DTO for create new user
     * @return ResponseDto
     */
    ResponseDto save(RequestUserDto userDto);

    /**
     * Delete user
     *
     * @param id user's id
     * @return ResponseDto
     */
    ResponseDto delete(String id);

}