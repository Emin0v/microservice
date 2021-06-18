package com.company.service;

import com.company.entity.Account;
import com.company.repo.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    public Account get(String id){
        return accountRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Transactional
    public Account save(Account account){
        return accountRepository.save(account);
    }

    @Transactional
    public Account update(String id, Account account){
        Assert.isNull(id,"id cannot be null");
        return accountRepository.save(account);
    }

    @Transactional
    public void delete(String id){
        Account account = accountRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        accountRepository.delete(account);
    }

}
