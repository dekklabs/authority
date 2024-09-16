package com.backpruebatecnica.backpruebatecnica.Activities.application.command;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateActivityCommand {
    private String title;
    private String typeActivity;
    private UUID userId;

    public CreateActivityCommand(
            String title,
            String typeActivity,
            UUID userId) {
        this.title = title;
        this.typeActivity = typeActivity;
        this.userId = userId;
    }
}
