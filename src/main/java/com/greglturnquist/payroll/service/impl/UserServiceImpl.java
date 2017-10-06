package com.greglturnquist.payroll.service.impl;

import com.greglturnquist.payroll.model.Account;
import com.greglturnquist.payroll.repository.AccountRepository;
import com.greglturnquist.payroll.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    @PreAuthorize("hasAuthority('USER')")
    public Account findbyUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMIN')")
    public Account findbyId(Long id) throws AccessDeniedException {
        return accountRepository.findOne(id) ;
    }

    @Override
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

}