package com.example.medicinesalesmanagement.service.Medicine;

import com.example.medicinesalesmanagement.model.Medicine;
import com.example.medicinesalesmanagement.repository.IMedicineRepository;
import com.example.medicinesalesmanagement.service.Medicine.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MedicineService implements IMedicineService {
    @Autowired
    IMedicineRepository iMedicineRepository;
    @Override
    public List<Medicine> findMedicineByNameContaining(String name) {
        return iMedicineRepository.findMedicineByNameContaining(name);
    }

    @Override
    public List<Medicine> findAll() {
        return iMedicineRepository.findAll();
    }

    @Override
    public void save(Medicine medicine) {
        iMedicineRepository.save(medicine);
    }

    @Override
    public Medicine findById(Integer id) {
        return iMedicineRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        iMedicineRepository.deleteById(id);
    }

    @Override
    public List<Medicine> findMedicineById_type_medicineContaining(Integer id) {
        return iMedicineRepository.findMedicineById_type_medicineContaining(id);
    }
}
