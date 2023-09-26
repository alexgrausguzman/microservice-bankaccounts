package com.ntt.microserviceaccounts.domain.model.enity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
public class Customer {


    private Long id;

    private String name;

    private String documentNumber;

    private String typeCustomer;
}
