package com.backpruebatecnica.backpruebatecnica.User.application.command;

import lombok.Data;

@Data
public class CreateUserCommand {
    private String username;
    private String password;
    private String email;

    public CreateUserCommand(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
