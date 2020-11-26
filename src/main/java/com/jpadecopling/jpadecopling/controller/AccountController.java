package com.jpadecopling.jpadecopling.controller;


import com.jpadecopling.jpadecopling.jpa.AccountStrategyService;
import com.jpadecopling.jpadecopling.jpa.StreamService;
import com.jpadecopling.jpadecopling.stream.KafkaStreamEmulator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class AccountController {

    @Autowired
    KafkaStreamEmulator kafkaStreamEmulator;

    @Autowired
    AccountStrategyService accountStrategyService;

    @Autowired
    StreamService streamService;

//    @PostMapping("/post")
//    public void postUser(@RequestBody Account user) {
//        accountService.save(user);
//        System.out.println("perfection");
//
//    }
//
//    @GetMapping("/get")
//    public Account getUser() {
//        return accountService.get(1);
//    }
//
//    @GetMapping("/start")
//    public void startjob() throws InterruptedException {
//        for (int i = 0; i < 5; i++) {
//            Thread.sleep(2000);
//            run();
//        }
//    }
//
//    private Account buildAccount(String username, String pass) {
//        return new Account(username, pass);
//    }
//
//    private List<Account> loadAccounts(int nr, int parity) {
//        List<Account> accounts = new ArrayList<>();
//        for (int i = 0; i < nr; i++) {
//            if (i != parity) {
//                accounts.add(buildAccount("user" + i, "pass" + i));
//
//            } else {
//                accounts.add(buildAccount("userBroke" + i, null));
//            }
//        }
//        return accounts;
//    }
//
//    public void run() {
//        List<Account> accounts = loadAccounts(10, 4);
//
//        accounts.forEach(account -> {
//
//                    accountStrategyService.process(account);
//                    log.info("ACCOUNT HAS BEEN SAVED");
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                e.printStackTrace();
//
//                }
//        );
//
//    }

    @GetMapping("/process")
    public void processAccounts() throws InterruptedException {
          streamService.consumeStream(kafkaStreamEmulator.getAccountStream());

        //accountStrategyService.process(kafkaStreamEmulator.getAccountStream());
    }
}
