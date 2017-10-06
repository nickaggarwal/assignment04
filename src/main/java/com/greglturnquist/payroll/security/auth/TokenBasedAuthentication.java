package com.greglturnquist.payroll.security.auth ;

import lombok.Setter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by Nilesh on 21/07/17.
 */

@Setter
public class TokenBasedAuthentication extends AbstractAuthenticationToken {

    private String token ;
    private final UserDetails principle ;

    @Override
    public boolean isAuthenticated() {
        return true;
    }

    public TokenBasedAuthentication( UserDetails principle ) {
        super( principle.getAuthorities() );
        this.principle = principle;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    @Override
    public UserDetails getPrincipal() {
        return principle;
    }
}
