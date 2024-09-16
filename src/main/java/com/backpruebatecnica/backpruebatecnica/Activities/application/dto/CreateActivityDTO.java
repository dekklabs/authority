package com.backpruebatecnica.backpruebatecnica.Activities.application.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateActivityDTO {
    private UUID id;

    public CreateActivityDTO(UUID id) {
        this.id = id;
    }
}
