package com.backpruebatecnica.backpruebatecnica.User.application.dto;

import lombok.Data;

@Data
public class LoginUserDTO {
    private String username;
    private String password;

    public LoginUserDTO(String password, String username) {
        this.password = password;
        this.username = username;
    }
}
