package com.greglturnquist.payroll.repository;

import com.greglturnquist.payroll.model.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Nilesh on 04/08/17.
 */
public interface ProductRepository extends CrudRepository<Product, Long> {

}
