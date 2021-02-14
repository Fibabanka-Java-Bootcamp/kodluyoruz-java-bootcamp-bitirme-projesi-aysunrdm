package org.kodluyoruz.mybank.Card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.logging.Logger;


@RestController
@RequestMapping("/card")
public class CardController {

        Logger LOG = Logger.getLogger(CardController.class.getName());

        @Autowired(required=true)
        @Qualifier("cardService")
        private CardService cardService;

        @GetMapping("/{cardId}")
        public CardEntity getCards(@PathVariable("cardId") Long cardId){

            return cardService.getCard(cardId);
        }

        @RequestMapping(value="/all",method= RequestMethod.GET)
        public List<CardEntity> allCards(){
            List<CardEntity> list = cardService.getAllCards();
            return list;
        }

        @RequestMapping(value="/update",method=RequestMethod.POST)
        public CardEntity editCard(@RequestBody CardEntity card){
            card = cardService.updateCard(card);
            return card;

        }
        @RequestMapping(value="/add",method=RequestMethod.POST)
        public CardEntity addCard(@RequestBody CardEntity card){
            card = cardService.addCard(card);
            return card;
        }

    }

