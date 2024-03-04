package com.example.medicinesalesmanagement.service.TypeMedicine;

import com.example.medicinesalesmanagement.model.TypeMedicine;
import com.example.medicinesalesmanagement.repository.ITypeMedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeMedicineService implements ITypeMedicineService{
    @Autowired
    ITypeMedicineRepository iTypeMedicineRepository;
    @Override
    public List<TypeMedicine> findAll() {
        return iTypeMedicineRepository.findAll();
    }

    @Override
    public void save(TypeMedicine typeMedicine) {
        iTypeMedicineRepository.save(typeMedicine);
    }

    @Override
    public TypeMedicine findById(Integer id) {
        return iTypeMedicineRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        iTypeMedicineRepository.deleteById(id);
    }
}
