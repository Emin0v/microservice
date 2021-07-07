package com.company.api;

import com.company.client.contract.AccountDTO;
import com.company.entity.Account;
import com.company.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountApi {

    private final AccountService accountService;

    @GetMapping
    public ResponseEntity<Slice<Account>> getAll(Pageable pageable){
        return ResponseEntity.ok(accountService.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> get(@PathVariable("id") String id){
        return ResponseEntity.ok(accountService.get(id));
    }

    @PostMapping
    public ResponseEntity<AccountDTO> save(@RequestBody AccountDTO account){
        return ResponseEntity.ok(accountService.save(account));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountDTO> update(@PathVariable("id") String id, @RequestBody AccountDTO account){
       return ResponseEntity.ok(accountService.update(id,account));
    }

    public void delete(String id){

    }

}
