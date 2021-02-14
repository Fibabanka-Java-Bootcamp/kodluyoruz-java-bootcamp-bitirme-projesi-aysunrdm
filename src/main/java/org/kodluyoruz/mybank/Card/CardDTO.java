package org.kodluyoruz.mybank.Card;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardDTO {

    private Long cardId;
    private String cardType;
    private String cardNo;
    private int accountId;
    private int customerId;

}
