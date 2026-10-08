package com.example.factory_traffic_management_system.dto;

import com.example.factory_traffic_management_system.enums.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatchUpdateSensorEventRequestDto {

    private String sensorId;
    private EventType eventType;

    @PositiveOrZero(message = "vehicleCount must be zero or greater")
    private Integer vehicleCount;

    private LocalDateTime occurredAt;
}
