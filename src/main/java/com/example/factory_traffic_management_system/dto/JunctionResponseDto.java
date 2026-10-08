package com.example.factory_traffic_management_system.dto;

import com.example.factory_traffic_management_system.enums.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Map;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class JunctionResponseDto {
    private String id;
    private JuntionMode mode;
    private Phase currentPhase;
    private ControllerStatus controllerStatus;
    private Map<Direction, SignalState> desiredSignals;
    private Map<Direction, SignalState> actualSignals;
    private Long version;
    private Instant updatedAt;
}
