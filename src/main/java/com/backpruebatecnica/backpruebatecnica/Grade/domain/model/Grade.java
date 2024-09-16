package com.backpruebatecnica.backpruebatecnica.Grade.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(indexes = {
        @Index(name = "idx_user_id", columnList = "user_id"),
        @Index(name = "idx_activity_id", columnList = "activity_id")
})
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_grade_user"))
    private UUID userId;

    @Column(nullable = false)
    @JoinColumn(name = "activity_id", foreignKey = @ForeignKey(name = "fk_grade_activities"))
    private UUID activityId;

    @Column(nullable = false)
    private BigDecimal grade;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = new Date();
    }
}
