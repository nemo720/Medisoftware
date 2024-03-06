package com.example.medicinesalesmanagement.dto;

import com.example.medicinesalesmanagement.model.Medicine;
import com.example.medicinesalesmanagement.model.Supplier;

import java.time.LocalDateTime;

public class InputWarehouseDto {
    private Integer id_warehouse;
    private LocalDateTime inputDay;
    private String unit;
    private double price;
    private int quantity;
    private double totalPayment;
    private int id_supplier;
    private int id_medicine;

    public InputWarehouseDto() {
    }

    public InputWarehouseDto(Integer id_warehouse, LocalDateTime inputDay, String unit, double price, int quantity, double totalPayment, int id_supplier, int id_medicine) {
        this.id_warehouse = id_warehouse;
        this.inputDay = inputDay;
        this.unit = unit;
        this.price = price;
        this.quantity = quantity;
        this.totalPayment = totalPayment;
        this.id_supplier = id_supplier;
        this.id_medicine = id_medicine;
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

    public int getId_supplier() {
        return id_supplier;
    }

    public void setId_supplier(int id_supplier) {
        this.id_supplier = id_supplier;
    }

    public int getId_medicine() {
        return id_medicine;
    }

    public void setId_medicine(int id_medicine) {
        this.id_medicine = id_medicine;
    }
}
