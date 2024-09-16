package com.backpruebatecnica.backpruebatecnica.Grade.application.query;

import lombok.Data;

import java.util.UUID;

@Data
public class GetGradeByIdQuery {
    private UUID _id;

    public GetGradeByIdQuery(UUID id) {
        this._id = id;
    }
}
