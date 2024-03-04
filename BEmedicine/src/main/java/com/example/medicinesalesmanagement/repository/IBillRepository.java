package com.example.medicinesalesmanagement.repository;

import com.example.medicinesalesmanagement.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBillRepository extends JpaRepository<Bill,Integer> {
    @Query(value = "select b.id_bill, b.id_employee, b.id_member, b.id_medicine, b.quantity, b.total_payment, b.date_create " +
            "from bill b " +
            "join employee e " +
            "on b.id_employee = e.id_employee " +
            "join member m " +
            "on b.id_member = m.id_member " +
            "join medicine c " +
            "on b.id_medicine = c.id_medicine " +
            "where e.name like :name_employee and m.name like :name_member and c.name like :name_medicine " +
            "order by b.id_bill",nativeQuery = true)
    List<Bill> findBillByEmployeeAndMemberAndMedicineContaining(@Param("name_employee")String searchNameEmployee,
                                                                @Param("name_member")String searchNameMember,
                                                                @Param("name_medicine")String searchNameMedicine);
}
