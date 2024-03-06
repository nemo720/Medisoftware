package com.example.medicinesalesmanagement.service.Bill;

import com.example.medicinesalesmanagement.model.Bill;
import com.example.medicinesalesmanagement.repository.IBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BillService implements IBillService {
    @Autowired
    IBillRepository iBillRepository;
    @Override
    public List<Bill> findBillByEmployeeAndMemberAndMedicineContaining(String searchNameEmployee, String searchNameMember, String searchNameMedicine) {
        return iBillRepository.findBillByEmployeeAndMemberAndMedicineContaining("%" + searchNameEmployee + "%",
                "%" + searchNameMember + "%","%" + searchNameMedicine + "%");
    }

    @Override
    public List<Bill> findAll() {
        return iBillRepository.findAll();
    }

    @Override
    public void save(Bill bill) {
        iBillRepository.save(bill);
    }

    @Override
    public Bill findById(Integer id) {
        return iBillRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        iBillRepository.deleteById(id);
    }
}
