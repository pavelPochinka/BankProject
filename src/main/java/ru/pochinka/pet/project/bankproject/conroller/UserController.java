package ru.pochinka.pet.project.bankproject.conroller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pochinka.pet.project.bankproject.dto.UserDto;
import ru.pochinka.pet.project.bankproject.dto.request.RequestUpdateUserDto;
import ru.pochinka.pet.project.bankproject.dto.request.RequestUserDto;
import ru.pochinka.pet.project.bankproject.dto.response.ResponseDto;
import ru.pochinka.pet.project.bankproject.facade.UserFacade;

@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserFacade userFacade;

    public UserController(UserFacade userFacade){
        this.userFacade = userFacade;
    }

    @ApiOperation(value = "Get user by Id", nickname = "getById", httpMethod = "GET")
    @GetMapping ("/get/byId/{id}")
    public @ResponseBody ResponseEntity<UserDto> getById(@PathVariable String id){
        return ResponseEntity.ok(userFacade.getById(id));
    }

    @ApiOperation(value = "Add new user", nickname = "add", httpMethod = "POST")
    @PostMapping(
            value = "/add", consumes = "application/json", produces = "application/json")
    public @ResponseBody ResponseEntity<ResponseDto> add(@RequestBody RequestUserDto user){
        return ResponseEntity.ok(userFacade.save(user));
    }

    @ApiOperation(value = "delete user", nickname = "delete", httpMethod = "DELETE")
    @DeleteMapping("/delete")
    public @ResponseBody ResponseEntity<ResponseDto> delete(@RequestBody String id){
        return ResponseEntity.ok(userFacade.delete(id));
    }

    @ApiOperation(value = "update user", nickname = "update", httpMethod = "PATCH")
    @PatchMapping(
            value = "/update/name", consumes = "application/json", produces = "application/json")
    public @ResponseBody ResponseEntity<ResponseDto> update(@RequestBody RequestUpdateUserDto updatedUser){
        return ResponseEntity.ok(userFacade.update(updatedUser));
    }


}
