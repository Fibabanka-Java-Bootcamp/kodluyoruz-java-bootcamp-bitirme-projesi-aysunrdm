package org.kodluyoruz.mybank.Card;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("cardRepository")
@Transactional
public class CardRepositoryImpl implements CardRepository {


        @PersistenceContext
        public EntityManager entityManager;

        @Transactional(readOnly=false)
        public CardEntity addCard(CardEntity cardEntity) {

            entityManager.persist(cardEntity);
            return cardEntity;
        }

        @Transactional(readOnly=false)
        public CardEntity updateCard(CardEntity cardEntity) {
            entityManager.merge(cardEntity);
            return cardEntity;
        }

        @Transactional(readOnly=false)
        public void deleteCard(Long cardId) {

            CardEntity cardEntity = getCard(cardId);
            entityManager.remove(cardEntity);
        }

        @Transactional(readOnly=true)
        public CardEntity getCard(Long cardId) {
            String sql = "select card from CardEntity card where card.cardId="+cardId;

            try{
                return (CardEntity) entityManager.createQuery(sql).getSingleResult();
            }catch(Exception e){
            }
            return null;
        }

        @Transactional(readOnly=true)
        public List getCards() {

            return entityManager.createQuery("select card from CardEntity card").getResultList();
        }

    }

