package org.kodluyoruz.mybank.Card;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface CardService {

        public CardEntity addCard(CardEntity card);
        public CardEntity updateCard(CardEntity card);
        public CardEntity getCard(Long cardId);
        public List<CardEntity> getAllCards();
        public void deleteCard(Long cardId);
    }

