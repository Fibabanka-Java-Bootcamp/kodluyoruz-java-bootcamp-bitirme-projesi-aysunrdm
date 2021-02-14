package org.kodluyoruz.mybank.Account;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {

    private Long accountId;
    private String accountType;
    private String accountNo;
    private String customerId;
    private String bankCode;
    private String currency;

}