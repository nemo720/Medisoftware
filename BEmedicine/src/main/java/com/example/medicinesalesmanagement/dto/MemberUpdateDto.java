package com.example.medicinesalesmanagement.dto;

import com.example.medicinesalesmanagement.model.TypeMember;

public class MemberUpdateDto {
    private Integer id_member;
    private String name;
    private String numberPhone;
    private TypeMemberDto typeMember;

    public MemberUpdateDto() {
    }

    public MemberUpdateDto(Integer id_member, String name, String numberPhone, TypeMemberDto typeMember) {
        this.id_member = id_member;
        this.name = name;
        this.numberPhone = numberPhone;
        this.typeMember = typeMember;
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

    public TypeMemberDto getTypeMember() {
        return typeMember;
    }

    public void setTypeMember(TypeMemberDto typeMember) {
        this.typeMember = typeMember;
    }
}
