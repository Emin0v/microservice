package com.company.service;

import com.company.AccountDTO;
import com.company.entity.Account;
import com.company.repo.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    public Slice<Account> getAll(Pageable pageable) {
        return accountRepository.findAll(pageable);
    }

    public AccountDTO get(String id) {
        Account account = accountRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return modelMapper.map(account, AccountDTO.class);
    }

    @Transactional
    public AccountDTO save(AccountDTO accountDTO) {
        Account account = modelMapper.map(accountDTO,Account.class);
        Account accountDb = accountRepository.save(account);
        accountDTO.setId(accountDb.getId());
        return accountDTO;
    }

    @Transactional
    public AccountDTO update(String id, AccountDTO accountDTO) {
        Assert.isNull(id, "id cannot be null");
        Optional<Account> optionalAccountDb = accountRepository.findById(id);
        Account account = modelMapper.map(accountDTO,optionalAccountDb.get().getClass());

        return modelMapper.map(accountRepository.save(account),AccountDTO.class);
    }

    @Transactional
    public void delete(String id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        accountRepository.delete(account);
    }

}
