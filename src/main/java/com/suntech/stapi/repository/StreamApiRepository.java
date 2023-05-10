package com.suntech.stapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suntech.stapi.entity.Employee;

@Repository
public interface StreamApiRepository extends JpaRepository<Employee, Integer> {

}
