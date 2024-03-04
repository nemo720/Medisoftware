package com.example.medicinesalesmanagement.service.TypeMedicine;

import com.example.medicinesalesmanagement.model.TypeMedicine;

import java.util.List;

public interface ITypeMedicineService {
    List<TypeMedicine> findAll();
    void save(TypeMedicine typeMedicine);
    TypeMedicine findById(Integer id);
    void delete(Integer id);
}
