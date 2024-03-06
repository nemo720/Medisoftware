package com.example.medicinesalesmanagement.controller;

import com.example.medicinesalesmanagement.dto.EmployeeDto;
import com.example.medicinesalesmanagement.model.Employee;
import com.example.medicinesalesmanagement.service.Employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService iEmployeeService;
    @GetMapping("/listSearchName")
    public ResponseEntity<List<Employee>> findAll(@RequestParam String name){
        List<Employee> employeeList = iEmployeeService.findEmployeeByNameContaining(name);
        if(employeeList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employeeList,HttpStatus.OK);
    }
    @GetMapping("/list")
    public ResponseEntity<List<Employee>> findAll(){
        List<Employee> employeeList = iEmployeeService.findAll();
        if(employeeList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employeeList,HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Employee> create(@RequestBody EmployeeDto employeeDto){
        if(employeeDto == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setGender(employeeDto.isGender());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        employee.setAddress(employeeDto.getAddress());
        employee.setSalary(employeeDto.getSalary());
        employee.setDayOfWork(employeeDto.getDayOfWork());

        iEmployeeService.save(employee);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> detail(@PathVariable Integer id){
        Employee employee = iEmployeeService.findById(id);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable Integer id, @RequestBody EmployeeDto employeeDto){
        Employee employee1 = iEmployeeService.findById(id);
        if(employee1 == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Employee employee = new Employee();
        employee.setId_employee(employeeDto.getId_employee());
        employee.setName(employeeDto.getName());
        employee.setGender(employeeDto.isGender());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        employee.setAddress(employeeDto.getAddress());
        employee.setSalary(employeeDto.getSalary());
        employee.setDayOfWork(employeeDto.getDayOfWork());

        iEmployeeService.save(employee);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> delete(@PathVariable Integer id){
        Employee employee = iEmployeeService.findById(id);
        if(employee == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iEmployeeService.delete(id);
        return new ResponseEntity<>(employee,HttpStatus.NO_CONTENT);
    }
}
