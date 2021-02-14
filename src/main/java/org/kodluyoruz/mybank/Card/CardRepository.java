package org.kodluyoruz.mybank.Card;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository {

        public CardEntity addCard(CardEntity cardEntity);
        public CardEntity updateCard(CardEntity cardEntity);
        public void deleteCard(Long cardId);
        public CardEntity getCard(Long cardId);
        public List<CardEntity> getCards();

    }
