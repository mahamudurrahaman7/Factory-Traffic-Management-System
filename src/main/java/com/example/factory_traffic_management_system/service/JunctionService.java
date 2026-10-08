package com.example.factory_traffic_management_system.service;

import com.example.factory_traffic_management_system.dto.CreateJunctionRequestDto;
import com.example.factory_traffic_management_system.dto.JunctionResponseDto;
import com.example.factory_traffic_management_system.dto.PatchUpdateJunctionRequestDto;
import com.example.factory_traffic_management_system.dto.UpdateJunctionRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface JunctionService {


    List<JunctionResponseDto> getAllJunctions();
    JunctionResponseDto getJunctionById(String id);
    JunctionResponseDto createJunction(CreateJunctionRequestDto user);
    JunctionResponseDto updateJunction(String id, UpdateJunctionRequestDto dto);
    JunctionResponseDto partialUpdateJunction(String id, PatchUpdateJunctionRequestDto dto);
    void deleteUser(String id);
}
