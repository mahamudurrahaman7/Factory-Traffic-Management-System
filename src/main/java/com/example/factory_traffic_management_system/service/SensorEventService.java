package com.example.factory_traffic_management_system.service;

import com.example.factory_traffic_management_system.dto.CreateSensorEventRequestDto;
import com.example.factory_traffic_management_system.dto.PatchUpdateSensorEventRequestDto;
import com.example.factory_traffic_management_system.dto.SensorEventResponseDto;
import com.example.factory_traffic_management_system.dto.UpdateSensorEventRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public interface SensorEventService {

    List<SensorEventResponseDto> getAllSensorEvents();
    SensorEventResponseDto getSensorEventById(UUID id);
    SensorEventResponseDto createSensorEvent(CreateSensorEventRequestDto dto);
    SensorEventResponseDto updateSensorEvent(UUID id, UpdateSensorEventRequestDto dto);
    SensorEventResponseDto partialUpdateSensorEvent(UUID id, PatchUpdateSensorEventRequestDto dto);
    void deleteSensorEvent(UUID id);

}
