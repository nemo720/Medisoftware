package com.example.medicinesalesmanagement.dto;

public class TypeMemberDto {
    private Integer type_member_id;
    private String type_member_name;

    public TypeMemberDto() {
    }

    public TypeMemberDto(Integer type_member_id, String type_member_name) {
        this.type_member_id = type_member_id;
        this.type_member_name = type_member_name;
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
}
