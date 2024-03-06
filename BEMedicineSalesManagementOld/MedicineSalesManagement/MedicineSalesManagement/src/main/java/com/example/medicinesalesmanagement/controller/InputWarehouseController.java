package com.example.medicinesalesmanagement.controller;
import com.example.medicinesalesmanagement.dto.InputWarehouseDto;
import com.example.medicinesalesmanagement.dto.InputWarehouseUpdateDto;
import com.example.medicinesalesmanagement.model.InputWarehouse;
import com.example.medicinesalesmanagement.model.Medicine;
import com.example.medicinesalesmanagement.model.Supplier;
import com.example.medicinesalesmanagement.service.InputWarehouse.IInputWarehouseService;
import com.example.medicinesalesmanagement.service.Medicine.IMedicineService;
import com.example.medicinesalesmanagement.service.Supplier.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/inputWarehouse")
public class InputWarehouseController {
    @Autowired
    IInputWarehouseService iIputWarehouseService;
    @Autowired
    ISupplierService iSupplierService;
    @Autowired
    IMedicineService iMedicineService;
    @GetMapping("/listSearchName")
    public ResponseEntity<List<InputWarehouse>> findAll(@RequestParam String nameSupplier,
                                                        @RequestParam String nameMedicine){
        System.out.println(nameSupplier);
        System.out.println(nameMedicine);
        List<InputWarehouse> inputWarehouseList = iIputWarehouseService.findAll(nameSupplier,nameMedicine);
        if(inputWarehouseList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(inputWarehouseList,HttpStatus.OK);
    }
    @GetMapping("/list")
    public ResponseEntity<List<InputWarehouse>> findAll(){
        List<InputWarehouse> inputWarehouseList = iIputWarehouseService.findAll();
        if(inputWarehouseList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(inputWarehouseList,HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<InputWarehouse> create(@RequestBody InputWarehouseDto inputWarehouseDto){
        if(inputWarehouseDto == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        InputWarehouse inputWarehouse = new InputWarehouse();
        inputWarehouse.setInputDay(inputWarehouseDto.getInputDay());
        inputWarehouse.setUnit(inputWarehouseDto.getUnit());
        inputWarehouse.setPrice(inputWarehouseDto.getPrice());
        inputWarehouse.setQuantity(inputWarehouseDto.getQuantity());
        inputWarehouse.setTotalPayment(inputWarehouseDto.getTotalPayment());
        Supplier supplier = iSupplierService.findById(inputWarehouseDto.getId_supplier());
        inputWarehouse.setSupplier(supplier);
        Medicine medicine = iMedicineService.findById(inputWarehouseDto.getId_medicine());
        inputWarehouse.setMedicine(medicine);

        iIputWarehouseService.save(inputWarehouse);
        return new ResponseEntity<>(inputWarehouse,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<InputWarehouse> detail(@PathVariable Integer id){
        InputWarehouse inputWarehouse = iIputWarehouseService.findById(id);
        if (inputWarehouse == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(inputWarehouse,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<InputWarehouse> update(@PathVariable Integer id, @RequestBody InputWarehouseUpdateDto inputWarehouseUpdateDto){
        InputWarehouse inputWarehouse1 = iIputWarehouseService.findById(id);
        if(inputWarehouse1 == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        InputWarehouse inputWarehouse = new InputWarehouse();
        inputWarehouse.setId_warehouse(inputWarehouseUpdateDto.getId_warehouse());
        inputWarehouse.setInputDay(inputWarehouseUpdateDto.getInputDay());
        inputWarehouse.setUnit(inputWarehouseUpdateDto.getUnit());
        inputWarehouse.setPrice(inputWarehouseUpdateDto.getPrice());
        inputWarehouse.setQuantity(inputWarehouseUpdateDto.getQuantity());
        inputWarehouse.setTotalPayment(inputWarehouseUpdateDto.getTotalPayment());
        Supplier supplier = iSupplierService.findById(inputWarehouseUpdateDto.getSupplier().getId_supplier());
        inputWarehouse.setSupplier(supplier);
        Medicine medicine = iMedicineService.findById(inputWarehouseUpdateDto.getMedicine().getId_medicine());
        inputWarehouse.setMedicine(medicine);

        iIputWarehouseService.save(inputWarehouse);
        return new ResponseEntity<>(inputWarehouse,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<InputWarehouse> delete(@PathVariable Integer id){
        InputWarehouse inputWarehouse = iIputWarehouseService.findById(id);
        if(inputWarehouse == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iIputWarehouseService.delete(id);
        return new ResponseEntity<>(inputWarehouse,HttpStatus.NO_CONTENT);
    }
}
