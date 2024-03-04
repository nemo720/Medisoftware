package com.example.medicinesalesmanagement.service.Employee;

import com.example.medicinesalesmanagement.model.Employee;
import com.example.medicinesalesmanagement.model.request.CreateUserRequest;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findEmployeeByNameContaining(String name);
    List<Employee> findAll();
    void save(Employee employee);
    Employee findById(Integer id);
    void delete(Integer id);

    void register(CreateUserRequest request);
}
