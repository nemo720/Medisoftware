package com.example.medicinesalesmanagement.repository;

import com.example.medicinesalesmanagement.model.InputWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface IInputWarehouseResponsitory extends JpaRepository<InputWarehouse,Integer>{
    @Query(value = "select iw.id_warehouse, iw.input_day, iw.unit, iw.price, iw.quantity, iw.total_payment, s.id_supplier as supplier_id, m.id_medicine as medicine_id from " +
            "input_warehouse iw " +
            "join medicine m " +
            "on iw.medicine_id = m.id_medicine " +
            "join supplier s " +
            "on iw.supplier_id = s.id_supplier " +
            "where m.name like :nameMedicine and s.name like :nameSupplier " +
            "order by iw.id_warehouse",nativeQuery = true)
    List<InputWarehouse> findAll(@Param("nameSupplier")String nameSupplier,
                                                                 @Param("nameMedicine")String nameMedicine);
}
