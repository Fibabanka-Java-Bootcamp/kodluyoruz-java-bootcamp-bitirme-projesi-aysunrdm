package org.kodluyoruz.mybank.Card;

public class DebtNotFoundException extends RuntimeException {

    public DebtNotFoundException(Long cardId) {

        super("Could not find debt for " + cardId);
    }
}
