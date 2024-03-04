package com.example.medicinesalesmanagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class DetailType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_type_detail;
    @ManyToOne
    @JoinColumn(name = "id_type_medicine", referencedColumnName = "type_medicine_id")
    private TypeMedicine typeMedicine;
    @ManyToOne
    @JoinColumn(name = "id_medicine", referencedColumnName = "id_medicine")
    private Medicine medicine;

    public DetailType() {
    }

    public DetailType(Integer id_type_detail, TypeMedicine typeMedicine, Medicine medicine) {
        this.id_type_detail = id_type_detail;
        this.typeMedicine = typeMedicine;
        this.medicine = medicine;
    }

    public Integer getId_type_detail() {
        return id_type_detail;
    }

    public void setId_type_detail(Integer id_type_detail) {
        this.id_type_detail = id_type_detail;
    }

    public TypeMedicine getTypeMedicine() {
        return typeMedicine;
    }

    public void setTypeMedicine(TypeMedicine typeMedicine) {
        this.typeMedicine = typeMedicine;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }
}
