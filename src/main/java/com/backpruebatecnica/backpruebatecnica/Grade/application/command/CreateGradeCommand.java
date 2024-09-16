package com.backpruebatecnica.backpruebatecnica.Grade.application.command;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class CreateGradeCommand {
    private UUID _id;
    private BigDecimal _grade;
    private UUID _userId;
    private UUID _activityId;

    public CreateGradeCommand(
       UUID id,
       BigDecimal grade,
       UUID userId,
       UUID activityId
    ) {
        this._id = id;
        this._grade = grade;
        this._userId = userId;
        this._activityId = activityId;
    }
}
