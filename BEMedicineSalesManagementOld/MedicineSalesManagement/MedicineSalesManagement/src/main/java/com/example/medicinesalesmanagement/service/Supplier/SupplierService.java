package com.example.medicinesalesmanagement.service.Supplier;
import com.example.medicinesalesmanagement.model.Supplier;
import com.example.medicinesalesmanagement.repository.ISupplierRepository;
import com.example.medicinesalesmanagement.service.Supplier.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService implements ISupplierService {
    @Autowired
    ISupplierRepository iSupplierRepository;
    @Override
    public List<Supplier> findSupplierByNameContaining(String name) {
        return iSupplierRepository.findSupplierByNameContaining(name);
    }

    @Override
    public List<Supplier> findAll() {
        return iSupplierRepository.findAll();
    }

    @Override
    public void save(Supplier supplier) {
        iSupplierRepository.save(supplier);
    }

    @Override
    public Supplier findById(Integer id) {
        return iSupplierRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        iSupplierRepository.deleteById(id);
    }
}
