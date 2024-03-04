package com.example.medicinesalesmanagement.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_bill;
    @ManyToOne
    @JoinColumn(name = "id_employee", referencedColumnName = "id_employee")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "id_member", referencedColumnName = "id_member")
    private Member member;
    @ManyToOne
    @JoinColumn(name = "id_medicine", referencedColumnName = "id_medicine")
    private Medicine medicine;
    private int quantity;
    private double totalPayment;
    private LocalDateTime dateCreate;

    public Bill() {
    }

    public Bill(Integer id_bill, Employee employee, Member member, Medicine medicine, int quantity, double totalPayment, LocalDateTime dateCreate) {
        this.id_bill = id_bill;
        this.employee = employee;
        this.member = member;
        this.medicine = medicine;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
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
