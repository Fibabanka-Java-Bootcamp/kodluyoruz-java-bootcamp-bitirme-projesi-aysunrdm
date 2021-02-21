package org.kodluyoruz.mybank.Transfer;

import lombok.*;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transfer", schema = "my_db")
public class TransferEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transfer_id", nullable = false)
    private Long transferId;

    @Column(name = "transfer_type")
    private String transferType;

    @Column(name = "transfer_code")
    private String transferCode;

    @Column(name = "transfer_amount")
    private BigDecimal transferAmount;

    @Column(name = "transfer_status")
    private TransactionStatus transferStatus;

    @Column(name = "source_name")
    private String sourceName;

    @Column(name = "destination_name")
    private String destinationName;

    @Column(name = "transaction_description")
    private String transactionDescription;

    @Column(name = "transfer_datetime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")

    private LocalDateTime transferDatetime;


    public TransferDTO toTransferDTO() {
        return TransferDTO.builder()
                .transferId(this.transferId)
                .transferType(this.transferType)
                .transferDatetime(this.transferDatetime)
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
