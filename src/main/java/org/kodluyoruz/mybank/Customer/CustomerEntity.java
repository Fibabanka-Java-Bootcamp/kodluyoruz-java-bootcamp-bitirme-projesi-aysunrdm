package org.kodluyoruz.mybank.Customer;

import javax.persistence.*;
import java.lang.*;
import lombok.*;


@Data
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_surname")
    private String customerSurname;

    @Column(name = "customer_no")
    private String customerNo;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    // private Adress adress;

}
