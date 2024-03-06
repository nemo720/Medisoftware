package com.example.medicinesalesmanagement.model;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class InputWarehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_warehouse;
    private LocalDateTime inputDay;
    private String unit;
    private double price;
    private int quantity;
    private double totalPayment;

    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "id_supplier")
    private Supplier supplier;
    @ManyToOne
    @JoinColumn(name = "medicine_id", referencedColumnName = "id_medicine")
    private Medicine medicine;
    public InputWarehouse(){}

    public InputWarehouse(Integer id_warehouse, LocalDateTime inputDay, String unit, double price, int quantity, double totalPayment, Supplier supplier, Medicine medicine) {
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

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }
}
