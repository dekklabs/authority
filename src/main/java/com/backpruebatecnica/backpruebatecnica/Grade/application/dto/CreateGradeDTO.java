package com.backpruebatecnica.backpruebatecnica.Grade.application.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateGradeDTO {
    private UUID _id;

    public CreateGradeDTO(UUID id) {
        this._id = id;
    }
}
