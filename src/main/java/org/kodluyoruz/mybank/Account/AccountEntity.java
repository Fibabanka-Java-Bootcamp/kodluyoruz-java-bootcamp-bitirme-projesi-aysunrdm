package org.kodluyoruz.mybank.Account;

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
@Table(name = "account")
public class AccountEntity {

        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        @Column(name = "account_id")
        private Long accountId;

        @Column(name = "account_type")
        private String accountType;

        @Column(name = "account_no")
        private String accountNo;


        @Column(name = "customer_id")
        private Long customerId;

        @Column(name = "bank_code")
        private String bankCode;

        @Column(name = "currency")
        private String currency;


}
