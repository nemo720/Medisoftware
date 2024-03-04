package com.example.medicinesalesmanagement.controller;
import com.example.medicinesalesmanagement.dto.SupplierDto;
import com.example.medicinesalesmanagement.model.Supplier;
import com.example.medicinesalesmanagement.service.Supplier.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/supplier")
public class SupplierController {
    @Autowired
    ISupplierService iSupplierService;
    @GetMapping("/listSearchName")
    public ResponseEntity<List<Supplier>> findAll(@RequestParam String name){
        List<Supplier> supplierList = iSupplierService.findSupplierByNameContaining(name);
        if(supplierList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(supplierList,HttpStatus.OK);
    }
    @GetMapping("/list")
    public ResponseEntity<List<Supplier>> findAll(){
        List<Supplier> supplierList = iSupplierService.findAll();
        if(supplierList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(supplierList,HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Supplier> create(@RequestBody SupplierDto supplierDto){
        if(supplierDto == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Supplier supplier = new Supplier();
        supplier.setName(supplierDto.getName());
        supplier.setTaxCode(supplierDto.getTaxCode());
        supplier.setAddress(supplierDto.getAddress());
        supplier.setPhoneNumber(supplierDto.getPhoneNumber());
        supplier.setEmail(supplierDto.getEmail());
        supplier.setStatus(supplierDto.getStatus());

        iSupplierService.save(supplier);
        return new ResponseEntity<>(supplier,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Supplier> detail(@PathVariable Integer id){
        Supplier supplier = iSupplierService.findById(id);
        if (supplier == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(supplier,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Supplier> update(@PathVariable Integer id, @RequestBody  SupplierDto supplierDto){
        Supplier supplier1 = iSupplierService.findById(id);
        if(supplier1 == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Supplier supplier = new Supplier();
        supplier.setId_supplier(supplierDto.getId_supplier());
        supplier.setName(supplierDto.getName());
        supplier.setTaxCode(supplierDto.getTaxCode());
        supplier.setAddress(supplierDto.getAddress());
        supplier.setPhoneNumber(supplierDto.getPhoneNumber());
        supplier.setEmail(supplierDto.getEmail());
        supplier.setStatus(supplierDto.getStatus());

        iSupplierService.save(supplier);
        return new ResponseEntity<>(supplier,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Supplier> delete(@PathVariable Integer id){
        Supplier supplier = iSupplierService.findById(id);
        if(supplier == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iSupplierService.delete(id);
        return new ResponseEntity<>(supplier,HttpStatus.NO_CONTENT);
    }
}
