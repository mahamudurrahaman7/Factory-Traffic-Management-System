package com.example.factory_traffic_management_system.mapper;

import com.example.factory_traffic_management_system.dto.*;
import com.example.factory_traffic_management_system.model.SensorEvent;
import org.mapstruct.*;

import java.util.List;



@Mapper(componentModel = "spring")
public interface SensorEventMapper {

        @Mapping(target = "id", ignore = true)
        SensorEvent toEntity(CreateSensorEventRequestDto dto);

        @Mapping(source = "junction.id", target = "junctionId")
        SensorEventResponseDto toResponseDto(SensorEvent sensorEvent);

        List<SensorEventResponseDto> toResponseList(List<SensorEvent> users);

        @Mapping(target = "id", ignore = true)
        void updateToSensorEventFromDto(UpdateSensorEventRequestDto dto, @MappingTarget SensorEvent event);

        @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
        @Mapping(target = "id", ignore = true)
        void partialUpdateToSensorEventFromDto(PatchUpdateSensorEventRequestDto dto, @MappingTarget SensorEvent event);
}


