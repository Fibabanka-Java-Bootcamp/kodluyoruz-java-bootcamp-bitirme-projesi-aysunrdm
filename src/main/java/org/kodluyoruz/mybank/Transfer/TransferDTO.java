package org.kodluyoruz.mybank.Transfer;

import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TransferDTO {

    private Long transferId;
    private String transferType;
    private String transactionCode;
    private BigDecimal transferAmount;
    private TransactionStatus transferStatus;
    private double sourceName;
    private double destinationName;
    private String transactionDescription;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime transferDatetime;

}