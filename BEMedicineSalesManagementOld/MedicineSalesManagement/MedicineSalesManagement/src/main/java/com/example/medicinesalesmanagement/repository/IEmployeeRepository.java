package com.example.medicinesalesmanagement.repository;

import com.example.medicinesalesmanagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee> findEmployeeByNameContaining(String name);
}
