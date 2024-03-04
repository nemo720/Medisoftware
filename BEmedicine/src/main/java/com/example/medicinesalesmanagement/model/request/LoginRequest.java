package com.example.medicinesalesmanagement.model.request;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class LoginRequest {
    
    @NotNull(message="Usernamerỗng")
    @NotEmpty(message="Username rỗng")
    @Size(min=5,max=30,message="Username có từ 5-30 ký tự")
    private String username;

    @NotNull(message = "Mật khẩu rỗng")
    @NotEmpty(message = "Mật khẩu rỗng")
    @Size(min=6,max=30,message="Mật khẩu có từ 6-30 ký tự")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginRequest() {
    }
}
