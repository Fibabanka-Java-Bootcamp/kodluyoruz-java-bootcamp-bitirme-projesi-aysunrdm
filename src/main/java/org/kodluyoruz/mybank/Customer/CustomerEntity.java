package org.kodluyoruz.mybank.Customer;

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
@Table(name = "customer", schema = "my_db")
//@EntityListeners(AuditingEntityListener.class)
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "customer_surname", nullable = false)
    private String customerSurname;

    @Column(name = "customer_no", nullable = false)
    private String customerNo;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    /*
    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
    private List<AccountEntity> findAll;


     @OneToMany(mappedBy = "customer")
     private List<AccountEntity> account;
    */

    public CustomerDTO toCustomerDTO() {
        return CustomerDTO.builder()
                .customerId(this.customerId)
                .customerName(this.customerName)
                .customerSurname(this.customerSurname)
                .customerNo(this.customerNo)
                .email(this.email)
                .phone(this.phone)
                .build();
    }

}

// private Adress adress;