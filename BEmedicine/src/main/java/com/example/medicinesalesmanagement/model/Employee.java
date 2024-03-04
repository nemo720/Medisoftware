package com.example.medicinesalesmanagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_employee;
    private String name;
    private boolean gender;
    private String phoneNumber;
    private String address;
    private String userName;
    private String password;
    private double salary;
    private LocalDateTime dayOfWork;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> role = new HashSet<>();
//    @JsonIgnore
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonBackReference
    List<Medicine> medicineList;
//    @JsonIgnore
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonBackReference
    List<Bill> billList;

    public Employee() {
    }

    public Employee(Integer id_employee, String name, boolean gender, String phoneNumber, String address, String userName, String password, double salary, LocalDateTime dayOfWork, Set<Role> role, List<Medicine> medicineList, List<Bill> billList) {
        this.id_employee = id_employee;
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.userName = userName;
        this.password = password;
        this.salary = salary;
        this.dayOfWork = dayOfWork;
        this.role = role;
        this.medicineList = medicineList;
        this.billList = billList;
    }

    public Integer getId_employee() {
        return id_employee;
    }

    public void setId_employee(Integer id_employee) {
        this.id_employee = id_employee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDateTime getDayOfWork() {
        return dayOfWork;
    }

    public void setDayOfWork(LocalDateTime dayOfWork) {
        this.dayOfWork = dayOfWork;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    public List<Medicine> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(List<Medicine> medicineList) {
        this.medicineList = medicineList;
    }

    public List<Bill> getBillList() {
        return billList;
    }

    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }
}
