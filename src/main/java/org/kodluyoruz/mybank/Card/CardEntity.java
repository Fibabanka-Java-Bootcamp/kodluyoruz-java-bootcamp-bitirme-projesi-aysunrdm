package org.kodluyoruz.mybank.Card;

import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "card", schema = "my_db")
public class CardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "card_id", nullable = false)
    private Long cardId;

    @Column(name = "card_type")
    private String cardType;

    @Column(name = "card_no")
    private String cardNo;

    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "balance")
    private String balance;

    @Column(name = "credit_card_debt")
    private Long creditCardDebt;


    public CardDTO toCardDTO() {
        return CardDTO.builder()
                .cardId(this.cardId)
                .cardType(this.cardType)
                .cardNo(this.cardNo)
                .accountId(this.accountId)
                .customerId(this.customerId)
                .balance(this.balance)
                .creditCardDept(this.creditCardDebt)
                .build();
    }

}

