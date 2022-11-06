package ru.pochinka.pet.project.bankproject.conroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pochinka.pet.project.bankproject.dto.UserDto;
import ru.pochinka.pet.project.bankproject.services.UserService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
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
}
