package com.example.medicinesalesmanagement.dto;

import com.example.medicinesalesmanagement.model.Medicine;
import com.example.medicinesalesmanagement.model.Supplier;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class InputWarehouseUpdateDto {
    private Integer id_warehouse;
    private LocalDateTime inputDay;
    private String unit;
    private double price;
    private int quantity;
    private double totalPayment;
    private SupplierDto supplier;

    private MedicineDto medicine;

    public InputWarehouseUpdateDto() {
    }

    public InputWarehouseUpdateDto(Integer id_warehouse, LocalDateTime inputDay, String unit, double price, int quantity, double totalPayment, SupplierDto supplier, MedicineDto medicine) {
        this.id_warehouse = id_warehouse;
        this.inputDay = inputDay;
        this.unit = unit;
        this.price = price;
        this.quantity = quantity;
        this.totalPayment = totalPayment;
        this.supplier = supplier;
        this.medicine = medicine;
    }

    public Integer getId_warehouse() {
        return id_warehouse;
    }

    public void setId_warehouse(Integer id_warehouse) {
        this.id_warehouse = id_warehouse;
    }

    public LocalDateTime getInputDay() {
        return inputDay;
    }

    public void setInputDay(LocalDateTime inputDay) {
        this.inputDay = inputDay;
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

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public SupplierDto getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierDto supplier) {
        this.supplier = supplier;
    }

    public MedicineDto getMedicine() {
        return medicine;
    }

    public void setMedicine(MedicineDto medicine) {
        this.medicine = medicine;
    }
}
