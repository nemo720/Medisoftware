package com.example.medicinesalesmanagement.service.InputWarehouse;

import com.example.medicinesalesmanagement.model.InputWarehouse;
import com.example.medicinesalesmanagement.model.Medicine;
import com.example.medicinesalesmanagement.repository.IInputWarehouseResponsitory;
import com.example.medicinesalesmanagement.repository.IMedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InputWarehouseService implements IInputWarehouseService {
    private int saveQuantity;
    @Autowired
    IInputWarehouseResponsitory iInputWarehouseResponsitory;
    @Autowired
    IMedicineRepository iMedicineRepository;
    @Override
    public List<InputWarehouse> findAll(String nameSupplier,String nameMedicine) {
        return iInputWarehouseResponsitory.findAll("%" + nameSupplier + "%", "%" + nameMedicine + "%");
    }

    @Override
    public List<InputWarehouse> findAll() {
        return iInputWarehouseResponsitory.findAll();
    }

    @Override
    public void save(InputWarehouse inputWarehouse) {
        if(inputWarehouse.getId_warehouse() == null){
            Optional<Medicine> mecidine = iMedicineRepository.findById(inputWarehouse.getMedicine().getId_medicine());
            mecidine.get().setQuantity(mecidine.get().getQuantity() + inputWarehouse.getQuantity());
        }else {
            Optional<Medicine> mecidine = iMedicineRepository.findById(inputWarehouse.getMedicine().getId_medicine());
            mecidine.get().setQuantity(mecidine.get().getQuantity() - saveQuantity + inputWarehouse.getQuantity());
        }
        iInputWarehouseResponsitory.save(inputWarehouse);
    }

    @Override
    public InputWarehouse findById(Integer id) {
        saveQuantity = iInputWarehouseResponsitory.findById(id).get().getQuantity();
        return iInputWarehouseResponsitory.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        Optional<InputWarehouse> inputWarehouse = iInputWarehouseResponsitory.findById(id);
        Optional<Medicine> mecidine = iMedicineRepository.findById(inputWarehouse.get().getMedicine().getId_medicine());
        mecidine.get().setQuantity(mecidine.get().getQuantity() - inputWarehouse.get().getQuantity());
        iInputWarehouseResponsitory.deleteById(id);
    }
}
