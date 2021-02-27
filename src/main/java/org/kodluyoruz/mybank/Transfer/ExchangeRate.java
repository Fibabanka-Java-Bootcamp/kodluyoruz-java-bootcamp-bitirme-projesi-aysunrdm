package org.kodluyoruz.mybank.Transfer;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Data
@ToString
public class ExchangeRate {

    public ExchangeRate(String Try, String Usd, String Eur) {
        this.Try = Try;
        this.Usd = Usd;
        this.Eur = Eur;
    }

    String Try;
    String Usd;
    String Eur;

}
