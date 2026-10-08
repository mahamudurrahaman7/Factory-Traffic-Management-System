package com.example.factory_traffic_management_system.model;


import com.example.factory_traffic_management_system.enums.*;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.data.domain.ScrollPosition;

import java.time.Instant;
import java.util.EnumMap;
import java.util.Map;

@Entity
@Table(name = "junction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Junction {

    @Id
    @Column(length = 32)
    private String id; // e.g. "A"

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private JuntionMode mode;

    @Enumerated(EnumType.STRING)
    @Column(name = "current_phase", nullable = false, length = 20)
    private Phase currentPhase;

    @Enumerated(EnumType.STRING)
    @Column(name = "controller_status", nullable = false, length = 20)
    private ControllerStatus controllerStatus;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "desired_signals", columnDefinition = "json", nullable = false)
    private Map<Direction, SignalState> desiredSignals;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "actual_signals", columnDefinition = "json", nullable = false)
    private Map<Direction, SignalState> actualSignals;

    @Version
    private Long version;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @Column(name = "is_deleted", nullable = false)
    @Builder.Default
    private Boolean isDeleted = false;

    @PrePersist
    @PreUpdate
    void touch() {
        this.updatedAt = Instant.now();
    }


}
