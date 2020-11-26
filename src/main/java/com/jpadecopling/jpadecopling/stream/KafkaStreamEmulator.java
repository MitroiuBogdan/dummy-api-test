package com.jpadecopling.jpadecopling.stream;

import com.jpadecopling.jpadecopling.jpa.model.Account;
import com.jpadecopling.jpadecopling.jpa.model.BalanceType;
import com.jpadecopling.jpadecopling.jpa.model.BalanceTypeEnum;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.UUID;

@Component
public class KafkaStreamEmulator {

    public List<Account> getAccountStream() {
        return List.of(
                buildAccount("a43"),
                buildBrokeAccount("a44"),
                buildAccount("a45")
        );
    }

    public List<BalanceType> buildBalanceType(Account account) {
        return List.of(
                BalanceType.builder()
                        .id(UUID.randomUUID().toString().toUpperCase())
                        .account(account)
                        .balanceTypeEnum(BalanceTypeEnum.AVAILABLE.name())
                        .build(),

                BalanceType.builder()
                        .id(UUID.randomUUID().toString().toUpperCase())
                        .account(account)
                        .balanceTypeEnum(BalanceTypeEnum.NOT_AVAILABLE.name())
                        .build()
        );

    }

    public Account buildAccount(String name) {
        Account account = Account.builder()
                .id(UUID.randomUUID().toString().toUpperCase())
                .clientId("client")
                .name(name)
                .checksum("checksum")
                .build();

        account.setBalances(buildBalanceType(account));

        return account;

    }

    public Account buildBrokeAccount(String name) {
        Account account = Account.builder()
                .id(UUID.randomUUID().toString().toUpperCase())
                .clientId("client")
                .name(name)
                .checksum("checksum")
                .build();

        account.setBalances(List.of(
                BalanceType.builder()
                        .id(UUID.randomUUID().toString().toUpperCase())
                        .account(account)
                        .build()
        ));

        return account;
    }
}
