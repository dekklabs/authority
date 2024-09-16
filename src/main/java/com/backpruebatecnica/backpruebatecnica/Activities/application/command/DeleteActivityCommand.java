package com.backpruebatecnica.backpruebatecnica.Activities.application.command;

import lombok.Data;

import java.util.UUID;

@Data
public class DeleteActivityCommand {
    private UUID id;

    public DeleteActivityCommand(UUID id) {
        this.id = id;
    }
}
