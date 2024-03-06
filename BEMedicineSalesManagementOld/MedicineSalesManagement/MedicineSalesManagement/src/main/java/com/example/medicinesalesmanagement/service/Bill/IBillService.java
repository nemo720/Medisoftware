package com.example.medicinesalesmanagement.service.Bill;

import com.example.medicinesalesmanagement.model.Bill;

import java.util.List;

public interface IBillService {
    List<Bill> findBillByEmployeeAndMemberAndMedicineContaining(String searchNameEmployee,String searchNameMember,String searchNameMedicine);
    List<Bill> findAll();
    void save(Bill bill);
    Bill findById(Integer id);
    void delete(Integer id);
}
