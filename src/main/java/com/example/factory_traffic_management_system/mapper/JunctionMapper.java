package com.example.factory_traffic_management_system.mapper;

import com.example.factory_traffic_management_system.dto.CreateJunctionRequestDto;
import com.example.factory_traffic_management_system.dto.JunctionResponseDto;
import com.example.factory_traffic_management_system.dto.PatchUpdateJunctionRequestDto;
import com.example.factory_traffic_management_system.dto.UpdateJunctionRequestDto;
import com.example.factory_traffic_management_system.model.Junction;

import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface JunctionMapper {


    Junction toEntity(CreateJunctionRequestDto dto);

    JunctionResponseDto toResponseDto(Junction user);

    List<JunctionResponseDto> toResponseList(List<Junction> users);

    @Mapping(target = "id", ignore = true)
    void updateJunctionFromDto(UpdateJunctionRequestDto dto, @MappingTarget Junction user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void partialUpdateJunctionFromDto(PatchUpdateJunctionRequestDto dto, @MappingTarget Junction user);
}
