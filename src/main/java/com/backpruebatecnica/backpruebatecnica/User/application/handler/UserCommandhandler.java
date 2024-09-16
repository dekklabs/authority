package com.backpruebatecnica.backpruebatecnica.User.application.handler;

import com.backpruebatecnica.backpruebatecnica.User.application.command.CreateUserCommand;
import com.backpruebatecnica.backpruebatecnica.User.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCommandhandler {
    @Autowired
    private UserService userService;

    public void handle(CreateUserCommand command) {
        userService.registerUser(command.getUsername(), command.getPassword(), command.getEmail());
    }
}
