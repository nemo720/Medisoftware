package com.example.medicinesalesmanagement.service.Employee;

import com.example.medicinesalesmanagement.model.Employee;
import com.example.medicinesalesmanagement.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    IEmployeeRepository iEmployeeRepository;
    @Override
    public List<Employee> findEmployeeByNameContaining(String name) {
        return iEmployeeRepository.findEmployeeByNameContaining(name);
    }

    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public Employee findById(Integer id) {
        return iEmployeeRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        iEmployeeRepository.deleteById(id);
    }
}
