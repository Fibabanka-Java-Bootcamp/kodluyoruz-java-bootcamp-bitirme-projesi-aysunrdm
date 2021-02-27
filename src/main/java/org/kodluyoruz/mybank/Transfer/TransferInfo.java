package org.kodluyoruz.mybank.Transfer;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class TransferInfo {

    public TransferInfo(String fromAccountNr, String toAccountNr, Long amount, String currency) {
        this.fromIbanNo = fromAccountNr;
        this.toIbanNo = toAccountNr;
        this.amount = amount;
        this.currency = currency;
    }

    String fromIbanNo;
    String toIbanNo;
    Long amount;
    String currency;
}
