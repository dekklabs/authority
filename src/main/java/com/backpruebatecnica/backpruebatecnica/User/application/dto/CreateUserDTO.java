package com.backpruebatecnica.backpruebatecnica.User.application.dto;

import lombok.Data;

@Data
public class CreateUserDTO {
    private String username;
    private String password;
    private String email;

    public CreateUserDTO(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
