package com.greglturnquist.payroll;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;

/**
 * Created by Nilesh on 04/08/17.
 */

@Data
@Entity
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    String name ;
    String category ;
    String description ;
    @Min(1)
    Integer quantity ;
    Float buy_price ;
    Float sell_price ;

    public Product() {}

}
