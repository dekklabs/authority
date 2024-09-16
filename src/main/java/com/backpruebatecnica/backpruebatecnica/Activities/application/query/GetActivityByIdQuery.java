package com.backpruebatecnica.backpruebatecnica.Activities.application.query;

import lombok.Data;

import java.util.UUID;

@Data
public class GetActivityByIdQuery {
    private UUID id;

    public GetActivityByIdQuery(UUID id) {
        this.id = id;
    }
}
