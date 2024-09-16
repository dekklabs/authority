package com.backpruebatecnica.backpruebatecnica.Activities.shared;

import java.util.UUID;

public class ActivitiesNotFoundException extends RuntimeException{
    public ActivitiesNotFoundException(UUID id) {
        super("Activity not found with id" + id);
    }
}
