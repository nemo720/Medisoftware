package com.example.medicinesalesmanagement.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class MessageResponse {
    
    private String message;

    public MessageResponse() {
    }

    public MessageResponse(String message) {
        this.message = message;
    }
}
