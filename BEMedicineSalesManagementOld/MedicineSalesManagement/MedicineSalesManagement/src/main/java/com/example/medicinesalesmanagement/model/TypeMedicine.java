package com.example.medicinesalesmanagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class TypeMedicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer type_medicine_id;
    private String typeMedicineName;
//    @JsonIgnore
    @OneToMany(mappedBy = "typeMedicine",cascade = CascadeType.ALL)
    @JsonBackReference
    List<DetailType> detailTypeList;

    public TypeMedicine() {
    }

    public TypeMedicine(Integer type_medicine_id, String typeMedicineName, List<DetailType> detailTypeList) {
        this.type_medicine_id = type_medicine_id;
        this.typeMedicineName = typeMedicineName;
        this.detailTypeList = detailTypeList;
    }


    public Integer getType_medicine_id() {
        return type_medicine_id;
    }

    public void setType_medicine_id(Integer type_medicine_id) {
        this.type_medicine_id = type_medicine_id;
    }

    public String getTypeMedicineName() {
        return typeMedicineName;
    }

    public void setTypeMedicineName(String typeMedicineName) {
        this.typeMedicineName = typeMedicineName;
    }

    public List<DetailType> getDetailTypeList() {
        return detailTypeList;
    }

    public void setDetailTypeList(List<DetailType> detailTypeList) {
        this.detailTypeList = detailTypeList;
    }
}
