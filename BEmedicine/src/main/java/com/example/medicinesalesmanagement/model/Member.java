package com.example.medicinesalesmanagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.data.relational.core.sql.In;
import org.springframework.data.relational.core.sql.Like;

import java.util.List;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_member;
    private String name;
    private String numberPhone;
    @ManyToOne
    @JoinColumn(name = "type_member_id", referencedColumnName = "type_member_id")
    private TypeMember typeMember;
//    @JsonIgnore
    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    @JsonBackReference
    List<Bill> billList;

    public Member() {
    }

    public Member(Integer id_member, String name, String numberPhone, TypeMember typeMember, List<Bill> billList) {
        this.id_member = id_member;
        this.name = name;
        this.numberPhone = numberPhone;
        this.typeMember = typeMember;
        this.billList = billList;
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

    public TypeMember getTypeMember() {
        return typeMember;
    }

    public void setTypeMember(TypeMember typeMember) {
        this.typeMember = typeMember;
    }

    public List<Bill> getBillList() {
        return billList;
    }

    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }
}
