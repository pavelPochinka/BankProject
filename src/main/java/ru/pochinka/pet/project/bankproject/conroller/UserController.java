package ru.pochinka.pet.project.bankproject.conroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pochinka.pet.project.bankproject.dto.request.RequestUserDto;
import ru.pochinka.pet.project.bankproject.dto.UserDto;
import ru.pochinka.pet.project.bankproject.dto.response.ResponseDto;
import ru.pochinka.pet.project.bankproject.facade.UserFacade;
import ru.pochinka.pet.project.bankproject.services.UserService;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("user")
public class UserController {

    private static final String SUCCESSFUL_DELETE_USER ="user was deleted";
    private static final String SUCCESSFUL_CREATING_USER ="user was created";
    private final UserService userService;
    private final UserFacade userFacade;

    public UserController(UserService userService, UserFacade userFacade){
        this.userService = userService;
        this.userFacade = userFacade;
    }

    @GetMapping("/get/byFirstName/{firstName}")
    public @ResponseBody ResponseEntity<List<UserDto>> getByFirstName(@PathVariable String firstName){
        return ResponseEntity.ok(userService.getByFirstName(firstName));
    }

    @GetMapping("/get/bySecondName/{secondName}")
    public  @ResponseBody ResponseEntity<List<UserDto>> getBySecondName(@PathVariable String secondName){
        return ResponseEntity.ok(userService.getBySecondName(secondName));
    }

    @GetMapping("/get/byFullName/{firstName}/{secondName}")
    public @ResponseBody ResponseEntity<List<UserDto>> getByFullName(@PathVariable Map<String,String> firstAndSecondName){
        String firstName = firstAndSecondName.get("firstName");
        String secondName = firstAndSecondName.get("secondName");
        return ResponseEntity.ok(userService.getByFirstNameAndSecondName(firstName,secondName));
    }

    @PostMapping(
            value = "/createUser", consumes = "application/json", produces = "application/json")
    public @ResponseBody ResponseEntity<ResponseDto> addUser(@RequestBody RequestUserDto user){
        userFacade.saveNewUser(user);
        return ResponseEntity.ok(new ResponseDto(SUCCESSFUL_CREATING_USER));
    }

    @DeleteMapping("/del/byId/{id}")
    public @ResponseBody ResponseEntity<ResponseDto> delUser(@PathVariable UUID id){
        userService.deleteUserById(id);
        return ResponseEntity.ok(new ResponseDto(SUCCESSFUL_DELETE_USER));
    }


}
