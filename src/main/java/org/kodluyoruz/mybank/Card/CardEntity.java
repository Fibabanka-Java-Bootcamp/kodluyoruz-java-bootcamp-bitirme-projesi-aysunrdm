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
@Table(name = "card")
public class CardEntity {

        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column(name = "card_id")
        private Long cardId;

        @Column(name = "card_type")
        private String cardType;

        @Column(name = "card_no")
        private String cardNo;

        @Column(name = "account_id")
        private int accountId;

        @Column(name = "customer_id")
        private Long customerId;

}

