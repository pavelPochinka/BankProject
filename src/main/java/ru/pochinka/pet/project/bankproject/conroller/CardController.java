package ru.pochinka.pet.project.bankproject.conroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pochinka.pet.project.bankproject.dto.CardDto;
import ru.pochinka.pet.project.bankproject.dto.request.RequestCardDto;
import ru.pochinka.pet.project.bankproject.dto.response.ResponseDto;
import ru.pochinka.pet.project.bankproject.facade.CardFacade;
import ru.pochinka.pet.project.bankproject.service.CardService;

import java.math.BigInteger;


@RestController
@RequestMapping("card")
public class CardController {

    private final CardService cardService;
    private final CardFacade cardFacade;

    public CardController(CardService cardService, CardFacade cardFacade) {
        this.cardService = cardService;
        this.cardFacade = cardFacade;
    }

    @GetMapping("/get/{cardNumber}")
    public @ResponseBody ResponseEntity<CardDto> getByCardNumber(@PathVariable String cardNumber) {
        return ResponseEntity.ok(cardService.getByCardNumber(cardNumber));
    }

    @PostMapping(
            value = "/add", consumes = "application/json", produces = "application/json")
    public @ResponseBody ResponseEntity<ResponseDto> add(@RequestBody RequestCardDto card){
        return ResponseEntity.ok(cardFacade.save(card));
    }

    @DeleteMapping("/delete")
    public @ResponseBody ResponseEntity<ResponseDto> delete(@RequestBody BigInteger cardNumber){
        cardService.deleteCardByNumber(cardNumber);
        return ResponseEntity.ok(cardFacade.delete(cardNumber));
    }
}
