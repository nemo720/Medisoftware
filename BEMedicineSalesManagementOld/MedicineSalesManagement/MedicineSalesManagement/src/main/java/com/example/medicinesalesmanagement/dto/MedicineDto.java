package com.example.medicinesalesmanagement.dto;

import com.example.medicinesalesmanagement.model.Employee;
import com.example.medicinesalesmanagement.model.TypeMedicine;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class MedicineDto {
    private Integer id_medicine;
    private String name;
    private String unit;
    private double price;
    private int quantity;
    private LocalDateTime productionDate;
    private LocalDateTime expirationDate;
    private int id_employee;
    private int[] typeMedicine;

    public MedicineDto() {
    }

    public MedicineDto(Integer id_medicine, String name, String unit, double price, int quantity, LocalDateTime productionDate, LocalDateTime expirationDate, int id_employee, int[] typeMedicine) {
        this.id_medicine = id_medicine;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.quantity = quantity;
        this.productionDate = productionDate;
        this.expirationDate = expirationDate;
        this.id_employee = id_employee;
        this.typeMedicine = typeMedicine;
    }

    public Integer getId_medicine() {
        return id_medicine;
    }

    public void setId_medicine(Integer id_medicine) {
        this.id_medicine = id_medicine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDateTime productionDate) {
        this.productionDate = productionDate;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    public int[] getTypeMedicine() {
        return typeMedicine;
    }

    public void setTypeMedicine(int[] typeMedicine) {
        this.typeMedicine = typeMedicine;
    }
}
