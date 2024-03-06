package com.example.medicinesalesmanagement.dto;

import com.example.medicinesalesmanagement.model.TypeMember;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class MemberDto {
    private Integer id_member;
    private String name;
    private String numberPhone;
    private int id_typeMember;

    public MemberDto() {
    }

    public MemberDto(Integer id_member, String name, String numberPhone, int id_typeMember) {
        this.id_member = id_member;
        this.name = name;
        this.numberPhone = numberPhone;
        this.id_typeMember = id_typeMember;
    }

    public Integer getId_member() {
        return id_member;
    }

    public void setId_member(Integer id_member) {
        this.id_member = id_member;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public int getId_typeMember() {
        return id_typeMember;
    }

    public void setId_typeMember(int id_typeMember) {
        this.id_typeMember = id_typeMember;
    }
}
