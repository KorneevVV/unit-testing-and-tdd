package com.acme.banking.dbo.repository;

import com.acme.banking.dbo.domain.Account;

public interface AccountRepository {
    Account getById(int fromAccountId);
}
