package com.example.medicinesalesmanagement.repository;

import com.example.medicinesalesmanagement.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMedicineRepository extends JpaRepository<Medicine,Integer> {
    List<Medicine> findMedicineByNameContaining(String name);
    @Query(value = "select m.id_medicine,m.name,m.unit,m.price,m.quantity,m.production_date,m.expiration_date,m.id_employee from " +
            "type_medicine tm " +
            "join detail_type dt " +
            "on tm.type_medicine_id = dt.id_type_medicine " +
            "join medicine m " +
            "on dt.id_medicine = m.id_medicine " +
            "where id_type_medicine like :id_type_medicine",nativeQuery = true)
    List<Medicine> findMedicineById_type_medicineContaining(@Param("id_type_medicine")Integer id);
}
