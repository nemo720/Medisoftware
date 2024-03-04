package com.example.medicinesalesmanagement.repository;
import com.example.medicinesalesmanagement.model.InputWarehouse;
import com.example.medicinesalesmanagement.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISupplierRepository extends JpaRepository<Supplier,Integer> {
    List<Supplier> findSupplierByNameContaining(String name);
    @Query(value = "select * " +
            "from supplier " +
            "where status like 1",nativeQuery = true)
    List<Supplier> findAll();
}
