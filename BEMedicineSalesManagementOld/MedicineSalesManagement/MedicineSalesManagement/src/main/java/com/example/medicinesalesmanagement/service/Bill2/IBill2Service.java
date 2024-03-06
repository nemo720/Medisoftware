package com.example.medicinesalesmanagement.service.Bill2;

import com.example.medicinesalesmanagement.model.Bill2;

import java.util.List;

public interface IBill2Service {
    List<Bill2> findAll();
    void save(Bill2 bill2);
    Bill2 findById(Integer id_bill);
    void delete(Integer id_bill);
}
