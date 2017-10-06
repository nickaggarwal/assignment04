package com.greglturnquist.payroll.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserTokenState {

    private String access_token ;
    private Long expires_in ;

}