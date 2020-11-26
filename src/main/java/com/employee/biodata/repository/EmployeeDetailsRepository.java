package com.employee.biodata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.biodata.model.EmployeeDetails;

public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Long> {

}