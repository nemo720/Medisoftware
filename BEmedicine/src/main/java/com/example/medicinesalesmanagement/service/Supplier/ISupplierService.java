package com.example.medicinesalesmanagement.service.Supplier;
import com.example.medicinesalesmanagement.model.Supplier;

import java.util.List;

public interface ISupplierService {
    List<Supplier> findSupplierByNameContaining(String name);
    List<Supplier> findAll();
    void save(Supplier supplier);
    Supplier findById(Integer id);
    void delete(Integer id);
}
