package com.example.factory_traffic_management_system.dto;

import com.example.factory_traffic_management_system.enums.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SensorEventResponseDto {



    private UUID id;
    private String junctionId;
    private String sensorId;
    private EventType eventType;
    private Integer vehicleCount;
    private LocalDateTime occurredAt;
}
