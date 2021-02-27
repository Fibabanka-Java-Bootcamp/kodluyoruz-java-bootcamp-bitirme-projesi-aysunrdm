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
@Table(name = "account", schema = "my_db")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id", nullable = false)
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

    @Column(name = "balance")
    private Long balance;

    @Column(name = "iban")
    private String iban;

      /*  @JsonIgnore
        @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", insertable = false, updatable = false)
        private CustomerEntity customer;

      @ManyToOne
      @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", insertable = false, updatable = false)
      private CustomerEntity customer;*/


    public AccountDTO toAccountDTO() {
        return AccountDTO.builder()
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
