package com.jpadecopling.jpadecopling.jpa;

import com.jpadecopling.jpadecopling.jpa.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account, String> {
}
