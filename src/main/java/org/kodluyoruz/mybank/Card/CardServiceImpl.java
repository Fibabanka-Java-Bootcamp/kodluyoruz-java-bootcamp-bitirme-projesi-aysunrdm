package org.kodluyoruz.mybank.Card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service("cardService")
@Transactional
public class CardServiceImpl implements CardService{

        @Autowired(required=true)
        @Qualifier("cardRepository")
        private CardRepository cardRepository;

        @Transactional
        public CardEntity addCard(CardEntity card) {

            System.out.println("Card Service Create invoked:"+ card.getCardNo());
            card = cardRepository.addCard(card);
            return card;
        }

        @Transactional
        public CardEntity updateCard(CardEntity card) {

            System.out.println("Card Service Update invoked:"+card.getCardNo());
            card = cardRepository.updateCard(card);
            return card;
        }

        public CardEntity getCard(Long cardId) {
            return cardRepository.getCard(cardId);
        }

        public List<CardEntity> getAllCards() {
            return (List<CardEntity>) cardRepository.getCards();
        }

        @Transactional
        public void deleteCard(Long cardId) {
            cardRepository.deleteCard(cardId);
        }

    }



