package ru.pochinka.pet.project.bankproject.facade;

import ru.pochinka.pet.project.bankproject.dto.UserDto;
import ru.pochinka.pet.project.bankproject.dto.request.RequestUpdateUserDto;
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

    /**
     * Update user name
     *
     * @param updatedUser
     * @return ResponseDto
     */
    ResponseDto update(RequestUpdateUserDto updatedUser);

    /**
     * Get user by id
     *
     * @param id
     * @return UserDto
     */
    UserDto getById(String id);
}