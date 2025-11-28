package com.transferbank.transferapp.repository;

import com.transferbank.transferapp.model.Account;
import org.springframework.data.repository.ListCrudRepository;

public interface AccountRepository extends ListCrudRepository<Account, Integer> {
}
