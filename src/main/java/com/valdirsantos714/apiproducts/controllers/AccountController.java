package com.valdirsantos714.apiproducts.controllers;

import com.valdirsantos714.apiproducts.dto.AccountDto;
import com.valdirsantos714.apiproducts.entities.Account;
import com.valdirsantos714.apiproducts.entities.Product;
import com.valdirsantos714.apiproducts.entities.User;
import com.valdirsantos714.apiproducts.services.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public ResponseEntity<List<Account>> findAllAccounts () {
        List<Account> list = accountService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Account> findByIdAccount(@PathVariable Long id) {
        Account account = accountService.findById(id);
        return ResponseEntity.ok().body(account);
    }

    @GetMapping(value = "/{id}/products")
    public ResponseEntity<List<Product>> findProducts (@PathVariable Long id) {
        Account account = accountService.findById(id);

        return ResponseEntity.ok().body(account.getProductList());

    }

    @PostMapping
    public ResponseEntity<Account> saveAccount(@RequestBody @Valid AccountDto accountDto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.save(accountDto));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long id, @RequestBody @Valid AccountDto accountDto) {
        var account = new Account(accountDto);
        account = accountService.update(id, accountDto);

        return ResponseEntity.ok().body(account);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        accountService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
