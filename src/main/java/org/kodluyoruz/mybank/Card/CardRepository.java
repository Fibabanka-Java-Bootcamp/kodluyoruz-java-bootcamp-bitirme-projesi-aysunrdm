package org.kodluyoruz.mybank.Card;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, Long> {

    default <S extends CardEntity> Optional<S> findOne(Long example) {
        return Optional.empty();
    }

    void deleteById(Long cardId);

}