package org.kodluyoruz.mybank.Card;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardDTO implements Serializable {

    private Long cardId;
    private String cardType;
    private String cardNo;
    private Long accountId;
    private Long customerId;
    private String balance;
    private Long creditCardDept;

    public CardEntity toCardEntity() {
        return CardEntity.builder()
                .cardId(this.cardId)
                .cardType(this.cardType)
                .cardNo(this.cardNo)
                .accountId(this.accountId)
                .customerId(this.customerId)
                .balance(this.balance)
                .creditCardDebt(this.creditCardDept)
                .build();
    }


}
