package org.kodluyoruz.mybank.CustomerAccount;

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
@Table(name = "customer_account_card", schema = "my_db")
public class CustomerAccountCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long idCustomerAccountCard;
    @Column
    private Long customerId;
    @Column
    private Long accountId;
    @Column
    private Long cardId;

}
