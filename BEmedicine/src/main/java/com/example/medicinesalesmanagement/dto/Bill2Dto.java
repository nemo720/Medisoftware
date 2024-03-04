package com.example.medicinesalesmanagement.dto;

import com.example.medicinesalesmanagement.model.Employee;
import com.example.medicinesalesmanagement.model.Medicine;
import com.example.medicinesalesmanagement.model.Member;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class Bill2Dto {
    private Integer id_bill;
    private int id_employee;
    private int id_member;
    private int id_medicine;
    private int quantity;
    private double totalPayment;
    private LocalDateTime dateCreate;

    public Bill2Dto() {
    }

    public Bill2Dto(Integer id_bill, int id_employee, int id_member, int id_medicine, int quantity, double totalPayment, LocalDateTime dateCreate) {
        this.id_bill = id_bill;
        this.id_employee = id_employee;
        this.id_member = id_member;
        this.id_medicine = id_medicine;
        this.quantity = quantity;
        this.totalPayment = totalPayment;
        this.dateCreate = dateCreate;
    }

    public Integer getId_bill() {
        return id_bill;
    }

    public void setId_bill(Integer id_bill) {
        this.id_bill = id_bill;
    }

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    public int getId_member() {
        return id_member;
    }

    public void setId_member(int id_member) {
        this.id_member = id_member;
    }

    public int getId_medicine() {
        return id_medicine;
    }

    public void setId_medicine(int id_medicine) {
        this.id_medicine = id_medicine;
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

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }
}
