package com.backpruebatecnica.backpruebatecnica.Grade.application.command;

import lombok.Data;

import java.util.UUID;

@Data
public class DeleteGradeCommand {
    private UUID _id;

    public DeleteGradeCommand(
            UUID id
    ) {
        this._id = id;
    }
}
