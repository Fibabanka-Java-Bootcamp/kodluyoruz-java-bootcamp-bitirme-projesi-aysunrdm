package org.kodluyoruz.mybank.Card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;


@RestController
@RequestMapping(value = "/card", produces = "application/json")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public CardEntity createCard(@RequestBody CardDTO request) {
        return cardService.createCard(request);
    }

    @GetMapping(value = "/list")
    public List<CardEntity> listAllCards() {
        return cardService.findAll();
    }

    @PutMapping(value = "/update/{cardId}")
    public CardEntity updateCard(@PathVariable Long cardId, @RequestBody CardDTO request) {
        return cardService.updateCard(cardId, request);
    }

    @DeleteMapping("/delete/{cardId}")
    private void deleteCard(@PathVariable("cardId") Long cardId) {
        cardService.deleteCard(cardId);
    }


}

