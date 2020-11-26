package com.jpadecopling.jpadecopling.jpa.model;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BALANCE_TYPE")
public class BalanceType {


    //    @GenericGenerator(name = "generator", strategy = "uuid2")
//    @GeneratedValue(generator = "generator")
    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "TYPE")
    private String balanceTypeEnum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;


}
