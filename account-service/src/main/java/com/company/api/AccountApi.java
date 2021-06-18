package com.company.api;

import com.company.entity.Account;
import com.company.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountApi {

    private final AccountService accountService;

    @GetMapping
    public ResponseEntity<List<Account>> getAll(){
        return ResponseEntity.ok(accountService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> get(@PathVariable("id") String id){
        return ResponseEntity.ok(accountService.get(id));
    }

    @PostMapping
    public ResponseEntity<Account> save(@RequestBody Account account){
        return ResponseEntity.ok(accountService.save(account));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> update(@PathVariable("id") String id, @RequestBody Account account){
       return ResponseEntity.ok(accountService.update(id,account));
    }

    public void delete(String id){

    }

}
