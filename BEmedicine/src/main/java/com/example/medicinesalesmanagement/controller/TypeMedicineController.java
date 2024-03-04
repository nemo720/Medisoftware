package com.example.medicinesalesmanagement.controller;

import com.example.medicinesalesmanagement.dto.TypeMedicineDto;
import com.example.medicinesalesmanagement.model.Bill;
import com.example.medicinesalesmanagement.model.TypeMedicine;
import com.example.medicinesalesmanagement.service.TypeMedicine.ITypeMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/typeMedicine")
public class TypeMedicineController {
    @Autowired
    ITypeMedicineService iTypeMedicineService;
    @GetMapping("/list")
    public ResponseEntity<List<TypeMedicine>> findAll(){
        List<TypeMedicine> typeMedicines = iTypeMedicineService.findAll();
        if(typeMedicines.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(typeMedicines,HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<TypeMedicine> create(@RequestBody TypeMedicineDto typeMedicineDto){
        if(typeMedicineDto == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        TypeMedicine typeMedicine = new TypeMedicine();
        typeMedicine.setTypeMedicineName(typeMedicineDto.getTypeMedicineName());

        iTypeMedicineService.save(typeMedicine);
        return new ResponseEntity<>(typeMedicine,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<TypeMedicine> delete(@PathVariable Integer id){
        TypeMedicine typeMedicine = iTypeMedicineService.findById(id);
        if(typeMedicine == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iTypeMedicineService.delete(id);
        return new ResponseEntity<>(typeMedicine,HttpStatus.NO_CONTENT);
    }
}
