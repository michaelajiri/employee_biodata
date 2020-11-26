package com.employee.biodata.model;

import java.util.Set;

import com.employee.biodata.model.Authority;
import com.employee.biodata.model.Employee;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails extends Employee implements UserDetails {

    public CustomUserDetails() {
    }

    public CustomUserDetails(Employee employee) {
        this.setId(employee.getId());
        this.setUsername(employee.getUsername());
        this.setPassword(employee.getPassword());
        this.setAuthorities(employee.getAuthorities());
    }

    @Override
    public Set<Authority> getAuthorities() {
        return super.getAuthorities();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}