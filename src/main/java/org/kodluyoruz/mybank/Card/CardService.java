package org.kodluyoruz.mybank.Card;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CardService {

    CardEntity createCard(CardDTO card);

    List<CardEntity> findAll();

    CardEntity updateCard(Long cardId, CardDTO request);

    void deleteCard(Long cardId);
}

//English level test