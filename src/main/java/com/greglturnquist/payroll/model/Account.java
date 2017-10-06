package com.greglturnquist.payroll.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
public class Account implements UserDetails {

    private @javax.persistence.Id
    @GeneratedValue
    Long id;
    private String username;
    private String password;
    private String email ;
    private String firstName ;
    private String lastName ;

    public Account(){}

    public Account(String username, String password, String email, String firstName , String lastName) {
        this.username = username;
        this.password = password;
        this.email = email ;
        this.firstName = firstName ;
        this.lastName = lastName ;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private List<Authority> authorities;

    @Override
    public String getUsername() {
        return this.username ;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }

}
