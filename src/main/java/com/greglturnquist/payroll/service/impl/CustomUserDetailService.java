package com.greglturnquist.payroll.service.impl;

import com.greglturnquist.payroll.model.Account;
import com.greglturnquist.payroll.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    AccountRepository accountRepository ;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account user = accountRepository.findByUsername(username) ;
        {
            if( user == null )
            {
                throw new UsernameNotFoundException(String.format("No User Found with Email %s", username));
            }
            else {
                return user ;
            }
        }
    }
}
