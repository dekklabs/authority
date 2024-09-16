package com.backpruebatecnica.backpruebatecnica.Grade.shared;

import java.util.UUID;

public class GradeNotFoundException extends RuntimeException {
    public GradeNotFoundException(UUID id) {
        super("Cat not found with id: " + id);
    }
}
