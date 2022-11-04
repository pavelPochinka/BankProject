package ru.pochinka.pet.project.bankproject.conroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pochinka.pet.project.bankproject.dto.CardDto;
import ru.pochinka.pet.project.bankproject.services.CardService;

@RestController
@RequestMapping("card")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/get/{cardNumber}")
    public @ResponseBody ResponseEntity<CardDto> getByCardNumber(@PathVariable String cardNumber) {
        return ResponseEntity.ok(cardService.getByCardNumber(cardNumber));
    }
}
