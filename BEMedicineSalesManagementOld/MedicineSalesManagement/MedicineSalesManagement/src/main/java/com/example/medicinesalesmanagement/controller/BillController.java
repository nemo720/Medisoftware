package com.example.medicinesalesmanagement.controller;

import com.example.medicinesalesmanagement.model.Bill;
import com.example.medicinesalesmanagement.model.Bill2;
import com.example.medicinesalesmanagement.model.Employee;
import com.example.medicinesalesmanagement.service.Bill.IBillService;
import com.example.medicinesalesmanagement.service.Bill2.IBill2Service;
import com.example.medicinesalesmanagement.service.Employee.IEmployeeService;
import com.example.medicinesalesmanagement.service.Medicine.IMedicineService;
import com.example.medicinesalesmanagement.service.Member.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/bill")
public class BillController {
    @Autowired
    IBillService iBillService;
    @Autowired
    IBill2Service iBill2Service;
    @Autowired
    IEmployeeService iEmployeeService;
    @Autowired
    IMemberService iMemberService;
    @Autowired
    IMedicineService iMedicineService;
    @GetMapping("/listSearchName")
    public ResponseEntity<List<Bill>> findAll(@RequestParam String searchNameEmployee,@RequestParam String searchNameMember,
                                              @RequestParam String searchNameMedicine){
        List<Bill> billList = iBillService.findBillByEmployeeAndMemberAndMedicineContaining(searchNameEmployee,searchNameMember,searchNameMedicine);
        if(billList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(billList,HttpStatus.OK);
    }
    @GetMapping("/thanhToan")
    public ResponseEntity<Bill> ThanhToan(){
        List<Bill2> bill2List = iBill2Service.findAll();
        for (Bill2 bill2 : bill2List) {
            Bill bill = new Bill();
            bill.setEmployee(bill2.getEmployee());
            bill.setMember(bill2.getMember());
            bill.setMedicine(bill2.getMedicine());
            bill.setQuantity(bill2.getQuantity());
            bill.setTotalPayment(bill2.getTotalPayment());
            bill.setDateCreate(bill2.getDateCreate());
            iBillService.save(bill);
        }
        for (Bill2 bill2 : bill2List) {
            iBill2Service.delete(bill2.getId_bill());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/thoat")
    public ResponseEntity<Bill> thoat(){
        List<Bill2> bill2List = iBill2Service.findAll();
        for (Bill2 bill2 : bill2List) {
            iBill2Service.delete(bill2.getId_bill());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/list")
    public ResponseEntity<List<Bill>> findAll(){
        List<Bill> billList = iBillService.findAll();
        if(billList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(billList,HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Bill> create(@RequestBody Bill bill){
        if(bill == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        iBillService.save(bill);
        return new ResponseEntity<>(bill,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Bill> detail(@PathVariable Integer id){
        Bill bill = iBillService.findById(id);
        if (bill == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bill,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Bill> update(@PathVariable Integer id, @RequestBody Bill bill){
        Bill bill1 = iBillService.findById(id);
        if(bill1 == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iBillService.save(bill);
        return new ResponseEntity<>(bill,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Bill> delete(@PathVariable Integer id){
        Bill bill = iBillService.findById(id);
        if(bill == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iBillService.delete(id);
        return new ResponseEntity<>(bill,HttpStatus.NO_CONTENT);
    }
}
