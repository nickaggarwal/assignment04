package com.greglturnquist.payroll.repository;

import com.greglturnquist.payroll.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Nilesh on 23/07/17.
 */
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    Authority findByName(String Name);
}

