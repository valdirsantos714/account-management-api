package com.valdirsantos714.apiproducts.services;

import com.valdirsantos714.apiproducts.dto.AccountDto;
import com.valdirsantos714.apiproducts.entities.Account;
import com.valdirsantos714.apiproducts.repositories.AccountRepository;
import com.valdirsantos714.apiproducts.services.exceptions.DataBaseException;
import com.valdirsantos714.apiproducts.services.exceptions.ResourceNotFound;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public Account save(AccountDto accountDto) {

        var account = new Account(accountDto);

        return accountRepository.save(account);
    }

    public List<Account> findAll() {
        List<Account> accountList = accountRepository.findAll();
        return accountList;
    }

    public Account findById(Long id) {
        Optional<Account> account = accountRepository.findById(id);
        return account.orElseThrow(() -> new ResourceNotFound(id));
    }

    public Account update(Long id, AccountDto updatedAccount) {
        try {
            Account account = accountRepository.getReferenceById(id);

            updateData(account, updatedAccount);

            return accountRepository.save(account);

        } catch (EntityNotFoundException e) {
            throw new ResourceNotFound(id);
        }
    }

    private void updateData(Account outdatedAccount, AccountDto updatedAccount) {
        outdatedAccount.setBalance(updatedAccount.balance());
        outdatedAccount.setBankName(updatedAccount.bankName());
    }

    @Transactional
    public void delete(Long id) {
        try {
            accountRepository.deleteById(id);

        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFound(id);

        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }
    }
}
