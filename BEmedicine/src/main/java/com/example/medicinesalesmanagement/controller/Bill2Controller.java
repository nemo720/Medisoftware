package com.example.medicinesalesmanagement.controller;

import com.example.medicinesalesmanagement.dto.Bill2Dto;
import com.example.medicinesalesmanagement.model.*;
import com.example.medicinesalesmanagement.service.Bill2.IBill2Service;
import com.example.medicinesalesmanagement.service.Employee.IEmployeeService;
import com.example.medicinesalesmanagement.service.Medicine.IMedicineService;
import com.example.medicinesalesmanagement.service.Member.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
@RestController
@CrossOrigin("*")
@RequestMapping("/api/bill2")
public class Bill2Controller {
    @Autowired
    IBill2Service iBill2Service;
    @Autowired
    IEmployeeService iEmployeeService;
    @Autowired
    IMemberService iMemberService;
    @Autowired
    IMedicineService iMedicineService;
    @GetMapping("/list")
    public ResponseEntity<List<Bill2>> findAll(){
        List<Bill2> billList = iBill2Service.findAll();
        if(billList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(billList,HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Bill2> create(@RequestBody Bill2Dto bill2Dto){
        if(bill2Dto == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Bill2 bill2 = new Bill2();
        Employee employee = iEmployeeService.findById(bill2Dto.getId_employee());
        bill2.setEmployee(employee);
        Member member = iMemberService.findById(bill2Dto.getId_member());
        bill2.setMember(member);
        Medicine medicine = iMedicineService.findById(bill2Dto.getId_medicine());
        bill2.setMedicine(medicine);
        bill2.setQuantity(bill2Dto.getQuantity());
        bill2.setTotalPayment(bill2Dto.getTotalPayment());
        LocalDateTime currentDateTime = LocalDateTime.now();
        bill2.setDateCreate(currentDateTime);

        iBill2Service.save(bill2);
        return new ResponseEntity<>(bill2,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Bill2> detail(@PathVariable Integer id){
        Bill2 bill2 = iBill2Service.findById(id);
        if (bill2 == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bill2,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Bill2> update(@PathVariable Integer id, @RequestBody Bill2 bill2){
        Bill2 bill21 = iBill2Service.findById(id);
        if(bill21 == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iBill2Service.save(bill2);
        return new ResponseEntity<>(bill2,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Bill2> delete(@PathVariable Integer id){
        Bill2 bill2 = iBill2Service.findById(id);
        if(bill2 == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iBill2Service.delete(id);
        return new ResponseEntity<>(bill2,HttpStatus.NO_CONTENT);
    }
}
