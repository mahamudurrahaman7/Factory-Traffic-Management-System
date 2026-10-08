package com.example.factory_traffic_management_system.dto;

import com.example.factory_traffic_management_system.enums.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UpdateJunctionRequestDto {

    @NotNull(message = "mode is required")
    private JuntionMode mode;

    @NotNull(message = "currentPhase is required")
    private Phase currentPhase;

    @NotNull(message = "controllerStatus is required")
    private ControllerStatus controllerStatus;

    @NotEmpty(message = "desiredSignals must not be empty")
    private Map<Direction, SignalState> desiredSignals;

    @NotEmpty(message = "actualSignals must not be empty")
    private Map<Direction, SignalState> actualSignals;

    private Long version;
}
