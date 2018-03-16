package com.bd.tm.modules.teacher.repository;

import com.bd.tm.schemas.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AccountRepository
        extends JpaRepository<Account, Integer>, JpaSpecificationExecutor<Account> {
}

