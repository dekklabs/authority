package com.backpruebatecnica.backpruebatecnica.User.application.handler;

import com.backpruebatecnica.backpruebatecnica.User.application.query.GetUserByIdQuery;
import com.backpruebatecnica.backpruebatecnica.User.domain.model.User;
import com.backpruebatecnica.backpruebatecnica.User.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserQueryHandler {
    @Autowired
    private UserService userService;

    public User handle(GetUserByIdQuery query) {
        return userService.findByUsername(query.getUsername());
    }
}
