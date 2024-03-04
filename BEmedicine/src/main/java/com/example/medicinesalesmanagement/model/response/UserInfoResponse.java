package com.example.medicinesalesmanagement.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


public class UserInfoResponse {
    private long id;

    private String username;

    private List<String> roles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public UserInfoResponse(long id, String username, List<String> roles) {
        this.id = id;
        this.username = username;
        this.roles = roles;
    }

    public UserInfoResponse() {
    }
}
