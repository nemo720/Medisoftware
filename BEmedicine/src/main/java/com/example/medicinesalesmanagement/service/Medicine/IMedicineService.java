package com.example.medicinesalesmanagement.service.Medicine;

import com.example.medicinesalesmanagement.model.Employee;
import com.example.medicinesalesmanagement.model.Medicine;

import java.util.List;

public interface IMedicineService {
    List<Medicine> findMedicineByNameContaining(String name);
    List<Medicine> findAll();
    void save(Medicine medicine);
    Medicine findById(Integer id);
    void delete(Integer id);
    List<Medicine> findMedicineById_type_medicineContaining(Integer id);
}
