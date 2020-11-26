package com.employee.biodata.service;

import com.employee.biodata.model.CustomUserDetails;
import com.employee.biodata.model.Employee;
import com.employee.biodata.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employee> employee = employeeRepository.findByUsername(username);

        if(employee == null){
            throw new UsernameNotFoundException("Employee not found");
        }else {
            return new CustomUserDetails(employee.get());
        }
    }
}
