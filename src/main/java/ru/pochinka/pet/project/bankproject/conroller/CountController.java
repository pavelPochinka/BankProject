package ru.pochinka.pet.project.bankproject.conroller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pochinka.pet.project.bankproject.dto.CountDto;
import ru.pochinka.pet.project.bankproject.service.CountService;

@RestController
@RequestMapping("count")
public class CountController {
    private final CountService countService;

    public CountController(CountService countService){
        this.countService = countService;
    }

    @GetMapping("/get/{count}")
    public @ResponseBody ResponseEntity<CountDto> getByCount(@PathVariable String count){
        return ResponseEntity.ok(countService.getByCount(count));
    }
}
