package com.greglturnquist.payroll.service;

import com.greglturnquist.payroll.model.Account;

public interface UserService {

    public Account findbyUsername(String username);
    public Account findbyId(Long id);
    public Iterable<Account> findAll() ;
}
