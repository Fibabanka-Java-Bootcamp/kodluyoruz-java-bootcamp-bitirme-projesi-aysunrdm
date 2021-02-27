package org.kodluyoruz.mybank.Account;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO implements Serializable {

    private Long accountId;
    private String accountType;
    private String accountNo;
    private Long customerId;
    private String bankCode;
    private String currency;
    private Long balance;
    private String iban;

    public AccountEntity toAccountEntity() {
        return AccountEntity.builder()
                .accountId(this.accountId)
                .accountType(this.accountType)
                .accountNo(this.accountNo)
                .accountId(this.accountId)
                .bankCode(this.bankCode)
                .currency(this.currency)
                .balance(this.balance)
                .iban(this.iban)
                .build();
    }

}




/*
Currency para birimi
Amount miktar
Balance bakiye
 */