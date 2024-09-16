package com.backpruebatecnica.backpruebatecnica.Activities.domain.repository;

import com.backpruebatecnica.backpruebatecnica.Activities.domain.model.Activities;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ActivitiesRepository extends JpaRepository<Activities, UUID> {
}
