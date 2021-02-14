package org.kodluyoruz.mybank.Customer;

import java.lang.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private Long customerId;
    private String customerNo;
    private String customerName;
    private String customerSurname;
    private String email;
    private String phone;

}



