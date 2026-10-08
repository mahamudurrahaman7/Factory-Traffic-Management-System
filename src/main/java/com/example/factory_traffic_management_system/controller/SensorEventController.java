package com.example.factory_traffic_management_system.controller;


import com.example.factory_traffic_management_system.dto.CreateSensorEventRequestDto;
import com.example.factory_traffic_management_system.dto.PatchUpdateSensorEventRequestDto;
import com.example.factory_traffic_management_system.dto.SensorEventResponseDto;
import com.example.factory_traffic_management_system.dto.UpdateSensorEventRequestDto;
import com.example.factory_traffic_management_system.response.ApiResponse;
import com.example.factory_traffic_management_system.response.ResponseBuilder;
import com.example.factory_traffic_management_system.service.SensorEventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("api/v1/sensor-events")
public class SensorEventController {
    private final SensorEventService sensorEventService;

    @PostMapping
    public ResponseEntity<ApiResponse<SensorEventResponseDto>> saveSensorEvent(@Valid @RequestBody CreateSensorEventRequestDto createDto) {
        return ResponseBuilder.status(HttpStatus.CREATED,
                "New sensor event is created successfully",
                sensorEventService.createSensorEvent(createDto)
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<SensorEventResponseDto>>> getAllSensorEvents() {
        return ResponseBuilder.status(HttpStatus.OK,
                "All sensor events are retrieved successfully",
                sensorEventService.getAllSensorEvents()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SensorEventResponseDto>> getSensorEventById(@PathVariable UUID id) {
        return ResponseBuilder.status(HttpStatus.OK,
                "Sensor event is retrieved successfully by id",
                sensorEventService.getSensorEventById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<SensorEventResponseDto>> updateSensorEvent(@PathVariable UUID id,
                                                                                 @Valid @RequestBody UpdateSensorEventRequestDto updateDto) {
        return ResponseBuilder.status(HttpStatus.OK,
                "Sensor event is updated successfully",
                sensorEventService.updateSensorEvent(id, updateDto)
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<SensorEventResponseDto>> partialUpdateSensorEvent(@PathVariable UUID id,
                                                                                        @Valid @RequestBody PatchUpdateSensorEventRequestDto updateDto) {
        return ResponseBuilder.status(HttpStatus.OK,
                "Sensor event is partially updated successfully",
                sensorEventService.partialUpdateSensorEvent(id, updateDto)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteSensorEvent(@PathVariable UUID id) {
        sensorEventService.deleteSensorEvent(id);
        return ResponseBuilder.status(HttpStatus.OK,
                "Sensor event is deleted successfully",
                null
        );
    }
}