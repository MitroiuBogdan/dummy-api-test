package com.jpadecopling.jpadecopling.jpa;

import com.jpadecopling.jpadecopling.jpa.model.BalanceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BalanceTypeRepo extends JpaRepository<BalanceType, String> {

    List<BalanceType> findByAccountId(String accountId);
}
