package com.example.factory_traffic_management_system.dto;

import com.example.factory_traffic_management_system.enums.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateSensorEventRequestDto {


    @NotBlank(message = "junctionId is required")
    @Size(max = 32, message = "junctionId must be at most 32 characters")
    private String junctionId;

    @NotBlank(message = "sensorId is required")
    private String sensorId;

    @NotNull(message = "eventType is required")
    private EventType eventType;

    @PositiveOrZero(message = "vehicleCount must be zero or greater")
    private Integer vehicleCount;

    @NotNull(message = "occurredAt is required")
    private LocalDateTime occurredAt;
}
