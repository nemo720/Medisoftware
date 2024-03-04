package com.example.medicinesalesmanagement.dto;

public class TypeMedicineDto {
    private Integer type_medicine_id;
    private String typeMedicineName;

    public TypeMedicineDto() {
    }

    public TypeMedicineDto(Integer type_medicine_id, String typeMedicineName) {
        this.type_medicine_id = type_medicine_id;
        this.typeMedicineName = typeMedicineName;
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
}
