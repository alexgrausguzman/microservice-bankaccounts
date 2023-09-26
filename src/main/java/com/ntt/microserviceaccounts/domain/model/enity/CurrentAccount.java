package com.ntt.microserviceaccounts.domain.model.enity;


import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "currentaccounts")
public class CurrentAccount extends BankAccount{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double maintenanceFee;
    private int monthlyTransactions;

}
