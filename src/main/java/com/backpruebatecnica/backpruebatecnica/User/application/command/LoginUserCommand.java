package com.backpruebatecnica.backpruebatecnica.User.application.command;

import lombok.Data;

@Data
public class LoginUserCommand {
    private String username;
    private String password;

    public LoginUserCommand(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
