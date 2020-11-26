package com.employee.biodata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.biodata.model.Title;

public interface TitleRepository extends JpaRepository<Title, Long>{

}