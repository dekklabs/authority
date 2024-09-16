package com.backpruebatecnica.backpruebatecnica.User.application.query;

import lombok.Data;

import java.util.UUID;

@Data
public class GetUserByIdQuery {
    private String username;

    public GetUserByIdQuery(String username) {
        this.username = username;
    }
}
