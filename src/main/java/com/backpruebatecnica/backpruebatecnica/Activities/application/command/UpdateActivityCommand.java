package com.backpruebatecnica.backpruebatecnica.Activities.application.command;

import lombok.Data;

import java.util.UUID;

@Data
public class UpdateActivityCommand {
    private UUID id;
    private String title;
    private String typeActivity;
    private UUID userId;

    public UpdateActivityCommand(
            UUID id,
            String title,
            String typeActivity,
            UUID userId) {
        this.id = id;
        this.title = title;
        this.typeActivity = typeActivity;
        this.userId = userId;
    }
}
