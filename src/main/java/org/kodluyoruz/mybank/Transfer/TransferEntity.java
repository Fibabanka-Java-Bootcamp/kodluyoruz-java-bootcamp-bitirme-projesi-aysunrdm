package org.kodluyoruz.mybank.Transfer;

import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transfer")
public class TransferEntity {

        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        @Column(name = "transfer_id")
        private Long transferId;

        @Column(name = "transfer_type")
        private String transferType;

        @Column(name = "transfer_datetime")
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime transferDatetime;

        @Column(name = "transaction_code")
        private String transactionCode;

        @Column(name = "transfer_amount")
        private BigDecimal transferAmount;

        @Column(name = "transfer_status")
        private TransactionStatus transferStatus;

        @Column(name = "source_name")
        private double sourceName;

        @Column(name = "destination_name")
        private double destinationName;

        @Column(name = "transaction_description")
        private String transactionDescription;


    @Override
    public String toString() {
        return "TransferEntity{" +
                "transferId=" + transferId +
                ", transferType='" + transferType + '\'' +
                ", transferDatetime=" + transferDatetime +
                ", transactionCode='" + transactionCode + '\'' +
                ", transferAmount=" + transferAmount +
                ", transferStatus=" + transferStatus +
                ", sourceName=" + sourceName +
                ", destinationName=" + destinationName +
                ", transactionDescription='" + transactionDescription + '\'' +
                '}';
    }
}
