package com.example.factory_traffic_management_system.dto;


import com.example.factory_traffic_management_system.enums.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateJunctionRequestDto {


    @NotBlank(message = "id is required")
    @Size(max = 32, message = "id must be at most 32 characters")
    private String id;

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
}
