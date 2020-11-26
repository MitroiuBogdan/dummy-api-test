package com.jpadecopling.jpadecopling.jpa;

import com.jpadecopling.jpadecopling.jpa.model.Account;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

@Component
@Slf4j
public class StreamService {

    @Autowired
    AccountStrategyService accountStrategyService;

    public void consumeStream(List<Account> accounts) {
        //   try {
        accountStrategyService.processAndSendEvents(accounts);
//        } catch (DataIntegrityViolationException e) {
//            log.error(e.getMessage());
//        }
    }

}
