package com.jpadecopling.jpadecopling.jpa.model;


import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "ACCOUNT")
public class Account {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CLIENT_ID", nullable = false)
    private String clientId;

    @Column(name = "CHECKSUM", nullable = false)
    private String checksum;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY, orphanRemoval = true, cascade = {CascadeType.ALL})
    @Fetch(value = FetchMode.SUBSELECT)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<BalanceType> balances = new ArrayList<>();


}
