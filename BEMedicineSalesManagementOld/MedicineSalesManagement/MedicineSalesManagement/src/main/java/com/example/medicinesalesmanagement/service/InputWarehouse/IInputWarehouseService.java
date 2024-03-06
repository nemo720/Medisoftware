package com.example.medicinesalesmanagement.service.InputWarehouse;

import com.example.medicinesalesmanagement.model.InputWarehouse;

import java.util.List;

public interface IInputWarehouseService {
    List<InputWarehouse> findAll(String nameSupplier,String nameMedicine);
    List<InputWarehouse> findAll();
    void save(InputWarehouse inputWarehouse);
    InputWarehouse findById(Integer id);
    void delete(Integer id);
}
