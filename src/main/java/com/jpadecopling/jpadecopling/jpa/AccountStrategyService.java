package com.jpadecopling.jpadecopling.jpa;

import com.jpadecopling.jpadecopling.jpa.model.Account;
import com.jpadecopling.jpadecopling.jpa.model.BalanceType;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AccountStrategyService {

    @Autowired
    AccountService accountService;

    @Autowired
    BalanceTypeRepo balanceTypeRepo;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Tuple2<Account, Boolean>> process(List<Account> accounts) {
        log.info("process {} accounts", accounts.size());
        List<Tuple2<Account, Boolean>> modifiedAccounts = new ArrayList<>();
        accounts.stream().forEach(account -> {

            System.out.println(accountService.save(account));
            //  System.out.println("EVENT HAS BEEN SENT FOR ACCOUNT:" + account.toString());

            List<String> balanceTypeId = balanceTypeRepo.findByAccountId(account.getId()).stream()
                    .map(BalanceType::getId)
                    .collect(Collectors.toList());

            System.out.println(balanceTypeId);
            if (true) {
                modifiedAccounts.add(Tuple.of(account, true));
            }

            //   System.out.println("EVENT HAS BEEN SENT FOR ACCOUNT:" + account);

        });
        return modifiedAccounts;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void processAndSendEvents(List<Account> accounts) {
        List<Tuple2<Account, Boolean>> deltaAccountes = process(accounts);
        System.out.println("###########################################################################################################");
        deltaAccountes.forEach(accountBooleanTuple2 -> System.out.println(accountBooleanTuple2._1 + " HELLO " + accountBooleanTuple2._2));

    }
}
