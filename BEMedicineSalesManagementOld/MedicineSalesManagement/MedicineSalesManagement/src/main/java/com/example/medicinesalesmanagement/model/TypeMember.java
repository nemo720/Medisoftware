package com.example.medicinesalesmanagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

@Entity
public class TypeMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer type_member_id;
    private String type_member_name;
    @OneToMany(mappedBy = "typeMember", cascade = CascadeType.ALL)
    @JsonBackReference
    List<Member> memberList;

    public TypeMember() {
    }

    public TypeMember(Integer type_member_id, String type_member_name, List<Member> memberList) {
        this.type_member_id = type_member_id;
        this.type_member_name = type_member_name;
        this.memberList = memberList;
    }

    public Integer getType_member_id() {
        return type_member_id;
    }

    public void setType_member_id(Integer type_member_id) {
        this.type_member_id = type_member_id;
    }

    public String getType_member_name() {
        return type_member_name;
    }

    public void setType_member_name(String type_member_name) {
        this.type_member_name = type_member_name;
    }

    public List<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }
}
