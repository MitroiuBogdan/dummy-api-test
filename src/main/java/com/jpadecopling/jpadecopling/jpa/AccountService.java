package com.jpadecopling.jpadecopling.jpa;

import com.jpadecopling.jpadecopling.jpa.model.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Table;


@Service
@Slf4j
public class AccountService {

    @Autowired
    AccountRepo accountRepo;

    @Transactional
    public Account save(Account account) {
        log.info("AccountService- save () : save account: {}", account);
        return accountRepo.save(account);
    }
}
