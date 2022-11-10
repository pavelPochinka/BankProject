package ru.pochinka.pet.project.bankproject.conroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pochinka.pet.project.bankproject.dto.CardDto;
import ru.pochinka.pet.project.bankproject.dto.request.RequestCardDto;
import ru.pochinka.pet.project.bankproject.dto.response.ResponseDto;
import ru.pochinka.pet.project.bankproject.services.CardService;

import java.math.BigInteger;


@RestController
@RequestMapping("card")
public class CardController {

    private static final String SUCCESSFUL_DELETE_CARD = "card was deleted";
    private static final String SUCCESSFUL_CREATING_CARD = "card was created";
    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/get/{cardNumber}")
    public @ResponseBody ResponseEntity<CardDto> getByCardNumber(@PathVariable String cardNumber) {
        return ResponseEntity.ok(cardService.getByCardNumber(cardNumber));
    }

    @PostMapping(
            value = "/createCard", consumes = "application/json", produces = "application/json")
    public @ResponseBody ResponseEntity<ResponseDto> addCard(@RequestBody RequestCardDto card){
        cardService.save(card);
        return ResponseEntity.ok(new ResponseDto(SUCCESSFUL_CREATING_CARD));
    }

    @DeleteMapping("/del/byCardNumber/{cardNumber}")
    public @ResponseBody ResponseEntity<ResponseDto> delCardByNumber(@PathVariable BigInteger cardNumber){
        cardService.deleteCardByNumber(cardNumber);
        return ResponseEntity.ok(new ResponseDto(SUCCESSFUL_DELETE_CARD));
    }

    @DeleteMapping("/del/byCount/{count}")
    public @ResponseBody ResponseEntity<ResponseDto> delCardByCount(@PathVariable BigInteger count){
        cardService.deleteByCount(count);
        return ResponseEntity.ok(new ResponseDto(SUCCESSFUL_DELETE_CARD));
    }
}
