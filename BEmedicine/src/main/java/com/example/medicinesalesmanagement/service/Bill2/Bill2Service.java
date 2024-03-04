package com.example.medicinesalesmanagement.service.Bill2;

import com.example.medicinesalesmanagement.model.Bill2;
import com.example.medicinesalesmanagement.repository.IBill2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Bill2Service implements IBill2Service{
    @Autowired
    IBill2Repository iBill2Repository;
    @Override
    public List<Bill2> findAll() {
        return iBill2Repository.findAll();
    }

    @Override
    public void save(Bill2 bill2) {
        iBill2Repository.save(bill2);
    }

    @Override
    public Bill2 findById(Integer id_bill) {
        return iBill2Repository.findById(id_bill).orElse(null);
    }

    @Override
    public void delete(Integer id_bill) {
        iBill2Repository.deleteById(id_bill);
    }
}
