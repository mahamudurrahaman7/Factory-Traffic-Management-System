package com.example.factory_traffic_management_system.serviceImpl;

import com.example.factory_traffic_management_system.dto.CreateSensorEventRequestDto;
import com.example.factory_traffic_management_system.dto.PatchUpdateSensorEventRequestDto;
import com.example.factory_traffic_management_system.dto.SensorEventResponseDto;
import com.example.factory_traffic_management_system.dto.UpdateSensorEventRequestDto;
import com.example.factory_traffic_management_system.mapper.SensorEventMapper;
import com.example.factory_traffic_management_system.model.Junction;
import com.example.factory_traffic_management_system.model.SensorEvent;
import com.example.factory_traffic_management_system.repository.JunctionRepository;
import com.example.factory_traffic_management_system.repository.SensorEventRepository;
import com.example.factory_traffic_management_system.service.SensorEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SensorEventServiceImpl implements SensorEventService {


    private final SensorEventRepository sensorEventRepository;
    private final JunctionRepository junctionRepository;
    private final SensorEventMapper sensorEventMapper;

    @Override
    public List<SensorEventResponseDto> getAllSensorEvents() {
        return sensorEventMapper.toResponseList(
                sensorEventRepository.findAllByIsDeletedFalse()
        );
    }

    @Override
    public SensorEventResponseDto getSensorEventById(UUID id) {
        return sensorEventMapper.toResponseDto(findActiveById(id));
    }

    @Override
    public SensorEventResponseDto createSensorEvent(CreateSensorEventRequestDto dto) {
        SensorEvent sensorEvent = sensorEventMapper.toEntity(dto);

        Junction junction = junctionRepository.findByIdAndIsDeletedFalse(dto.getJunctionId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Junction not found with id: " + dto.getJunctionId()));

        sensorEvent.setJunction(junction);
        sensorEvent = sensorEventRepository.save(sensorEvent);

        return sensorEventMapper.toResponseDto(sensorEvent);
    }

    @Override
    public SensorEventResponseDto updateSensorEvent(UUID id, UpdateSensorEventRequestDto dto) {
        SensorEvent sensorEvent = findActiveById(id);

        sensorEventMapper.updateToSensorEventFromDto(dto, sensorEvent);
        SensorEvent savedSensorEvent = sensorEventRepository.save(sensorEvent);

        return sensorEventMapper.toResponseDto(savedSensorEvent);
    }

    @Override
    public SensorEventResponseDto partialUpdateSensorEvent(UUID id, PatchUpdateSensorEventRequestDto dto) {
        SensorEvent sensorEvent = findActiveById(id);

        sensorEventMapper.partialUpdateToSensorEventFromDto(dto, sensorEvent);
        SensorEvent savedSensorEvent = sensorEventRepository.save(sensorEvent);

        return sensorEventMapper.toResponseDto(savedSensorEvent);
    }

    @Override
    public void deleteSensorEvent(UUID id) {
        SensorEvent sensorEvent = findActiveById(id);

        sensorEvent.setIsDeleted(true);
        sensorEventRepository.save(sensorEvent);
    }

    private SensorEvent findActiveById(UUID id) {
        return sensorEventRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Sensor event not found with id: " + id));
    }


}
