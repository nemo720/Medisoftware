package com.example.medicinesalesmanagement.dto;

public class SupplierDto {
    private Integer id_supplier;
    private String name;
    private String taxCode;
    private String address;
    private String phoneNumber;
    private String email;
    private Boolean status;

    public SupplierDto() {
    }

    public SupplierDto(Integer id_supplier, String name, String taxCode, String address, String phoneNumber, String email, Boolean status) {
        this.id_supplier = id_supplier;
        this.name = name;
        this.taxCode = taxCode;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.status = status;
    }

    public Integer getId_supplier() {
        return id_supplier;
    }

    public void setId_supplier(Integer id_supplier) {
        this.id_supplier = id_supplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
