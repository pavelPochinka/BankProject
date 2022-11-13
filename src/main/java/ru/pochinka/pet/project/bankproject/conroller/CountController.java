package ru.pochinka.pet.project.bankproject.conroller;


import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pochinka.pet.project.bankproject.dto.CountDto;
import ru.pochinka.pet.project.bankproject.service.CountService;

@RestController
@RequestMapping("api/count")
public class CountController {
    private final CountService countService;


    public CountController(CountService countService){
        this.countService = countService;
    }

    @ApiOperation(value = "Get count by count number", nickname = "getByCount", httpMethod = "GET")
    @GetMapping("/get/{count}")
    public @ResponseBody ResponseEntity<CountDto> getByCount(@PathVariable String count){
        return ResponseEntity.ok(countService.getByCount(count));
    }
}