package com.employee.biodata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.biodata.model.Profession;

public interface ProfessionRepository extends JpaRepository<Profession, Long>{

}