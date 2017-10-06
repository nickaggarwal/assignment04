package com.greglturnquist.payroll.repository;

import com.greglturnquist.payroll.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AccountRepository extends JpaRepository<Account, Long> {

    public Account findByUsername(String username);

}
