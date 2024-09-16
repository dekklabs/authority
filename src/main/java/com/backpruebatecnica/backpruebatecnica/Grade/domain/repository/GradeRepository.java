package com.backpruebatecnica.backpruebatecnica.Grade.domain.repository;

import com.backpruebatecnica.backpruebatecnica.Grade.domain.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GradeRepository extends JpaRepository<Grade, UUID> {
}
