package org.kodluyoruz.mybank.Card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("cardService")
@Transactional
public class CardServiceImpl implements CardService {


    @Autowired
    private CardRepository cardRepository;

    @Transactional
    public CardEntity createCard(CardDTO card) {

        System.out.println("Card Service Create invoked...");

        CardEntity cardEntity = new CardEntity();

        cardEntity.setCardType(card.getCardType());
        cardEntity.setCardNo(card.getCardNo());
        cardEntity.setAccountId(card.getAccountId());
        cardEntity.setCustomerId(card.getCustomerId());

        return cardRepository.save(cardEntity);
    }


    @Transactional
    public List<CardEntity> findAll() {
        return cardRepository.findAll();
    }


    @Transactional
    public CardEntity updateCard(Long cardId, CardDTO request) {

        CardEntity updatedCard = Optional.ofNullable(cardRepository.findOne(cardId)).map(cardEntity -> {

            CardEntity card = new CardEntity();

            card.setCardId(request.getCardId());
            card.setCardType(request.getCardType());
            card.setCardNo(request.getCardNo());
            card.setAccountId(request.getAccountId());
            card.setCustomerId(request.getCustomerId());
            return card;

        }).get();

        return cardRepository.save(updatedCard);
    }

    @Transactional
    public void deleteCard(Long cardId) {
        cardRepository.deleteById(cardId);
    }


    @Transactional
    public Long debtInquiry(Long cardId) {
        CardEntity card = cardRepository.findById(cardId) //
                .orElseThrow(() -> new DebtNotFoundException(cardId));
        return cardRepository.findById(cardId).get().getCreditCardDebt();
    }

}



