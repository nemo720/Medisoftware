package com.example.medicinesalesmanagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_medicine;
    private String name;
    private String unit;
    private double price;
    private int quantity;
    private LocalDateTime productionDate;
    private LocalDateTime expirationDate;
    @ManyToOne
    @JoinColumn(name = "id_employee", referencedColumnName = "id_employee")
    private Employee employee;
    @OneToMany(mappedBy = "medicine", cascade = CascadeType.ALL)
    @JsonBackReference
    List<InputWarehouse> inputWarehouseList;
    @OneToMany(mappedBy = "medicine", cascade = CascadeType.ALL)
    @JsonBackReference
    List<Bill> billList;
    @OneToMany(mappedBy = "medicine", cascade = CascadeType.ALL)
    @JsonBackReference
    List<DetailType> detailTypeList;

    public Medicine() {
    }

    public Medicine(Integer id_medicine, String name, String unit, double price, int quantity, LocalDateTime productionDate, LocalDateTime expirationDate, Employee employee, List<InputWarehouse> inputWarehouseList, List<Bill> billList, List<DetailType> detailTypeList) {
        this.id_medicine = id_medicine;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.quantity = quantity;
        this.productionDate = productionDate;
        this.expirationDate = expirationDate;
        this.employee = employee;
        this.inputWarehouseList = inputWarehouseList;
        this.billList = billList;
        this.detailTypeList = detailTypeList;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<InputWarehouse> getInputWarehouseList() {
        return inputWarehouseList;
    }

    public void setInputWarehouseList(List<InputWarehouse> inputWarehouseList) {
        this.inputWarehouseList = inputWarehouseList;
    }

    public List<Bill> getBillList() {
        return billList;
    }

    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }

    public List<DetailType> getDetailTypeList() {
        return detailTypeList;
    }

    public void setDetailTypeList(List<DetailType> detailTypeList) {
        this.detailTypeList = detailTypeList;
    }
}
