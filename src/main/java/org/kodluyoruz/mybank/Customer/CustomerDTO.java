package org.kodluyoruz.mybank.Customer;

import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO implements Serializable {

    private Long customerId;
    private String customerName;
    private String customerSurname;
    private String customerNo;
    private String email;
    private String phone;


    public CustomerEntity toCustomerEntity() {
        return CustomerEntity.builder()
                .customerId(this.customerId)
                .customerName(this.customerName)
                .customerSurname(this.customerSurname)
                .customerNo(this.customerNo)
                .email(this.email)
                .phone(this.phone)
                .build();
    }

}



