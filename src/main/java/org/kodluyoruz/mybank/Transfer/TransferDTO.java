package org.kodluyoruz.mybank.Transfer;

import lombok.*;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TransferDTO implements Serializable {

    private Long transferId;
    private String transferType;
    private String transferCode;
    private BigDecimal transferAmount;
    private TransactionStatus transferStatus;
    private String sourceName;
    private String destinationName;
    private String transactionDescription;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime transferDatetime;


    public TransferEntity toTransferEntity() {
        return TransferEntity.builder()
                .transferId(this.transferId)
                .transferType(this.transferType)
                .transferCode(this.transferCode)
                .transferAmount(this.transferAmount)
                .transferStatus(this.transferStatus)
                .sourceName(this.sourceName)
                .destinationName(this.destinationName)
                .transactionDescription(this.transactionDescription)
                .transferDatetime(this.transferDatetime)
                .build();
    }


}