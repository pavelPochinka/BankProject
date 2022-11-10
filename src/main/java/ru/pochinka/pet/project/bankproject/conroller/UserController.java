package ru.pochinka.pet.project.bankproject.conroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pochinka.pet.project.bankproject.dto.request.RequestUserDto;
import ru.pochinka.pet.project.bankproject.dto.response.ResponseDto;
import ru.pochinka.pet.project.bankproject.facade.UserFacade;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserFacade userFacade;

    public UserController(UserFacade userFacade){
        this.userFacade = userFacade;
    }

    @PostMapping(
            value = "/add", consumes = "application/json", produces = "application/json")
    public @ResponseBody ResponseEntity<ResponseDto> add(@RequestBody RequestUserDto user){
        return ResponseEntity.ok(userFacade.save(user));
    }

    @DeleteMapping("/delete")
    public @ResponseBody ResponseEntity<ResponseDto> delete(@RequestBody String id){
        return ResponseEntity.ok(userFacade.delete(id));
    }


}
