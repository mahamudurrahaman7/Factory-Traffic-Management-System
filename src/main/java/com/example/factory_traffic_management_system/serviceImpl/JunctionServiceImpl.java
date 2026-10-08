package com.example.factory_traffic_management_system.serviceImpl;


import com.example.factory_traffic_management_system.dto.CreateJunctionRequestDto;
import com.example.factory_traffic_management_system.dto.JunctionResponseDto;
import com.example.factory_traffic_management_system.dto.PatchUpdateJunctionRequestDto;
import com.example.factory_traffic_management_system.dto.UpdateJunctionRequestDto;
import com.example.factory_traffic_management_system.mapper.JunctionMapper;
import com.example.factory_traffic_management_system.model.Junction;
import com.example.factory_traffic_management_system.repository.JunctionRepository;
import com.example.factory_traffic_management_system.service.JunctionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class JunctionServiceImpl implements JunctionService {

    private final JunctionRepository junctionRepository;
    private final JunctionMapper junctionMapper;


    @Override
    public List<JunctionResponseDto> getAllJunctions() {

        return junctionMapper.toResponseList(
                junctionRepository.findAllByIsDeletedFalse()
        );
    }

    @Override
    public JunctionResponseDto getJunctionById(String id) {
        Junction junction = junctionRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Junction not found with id: " + id));

        return junctionMapper.toResponseDto(junction);
    }

    @Override
    public JunctionResponseDto createJunction(CreateJunctionRequestDto junctionRequestDto) {


        Junction junction = junctionMapper.toEntity(junctionRequestDto);



        junction = junctionRepository.save(junction);

        return junctionMapper.toResponseDto(junction);
    }

    @Override
    public JunctionResponseDto updateJunction(String id, UpdateJunctionRequestDto dto) {
        Junction junction = junctionRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Junction not found with id: " + id));

        junctionMapper.updateJunctionFromDto(dto, junction);
        Junction savedJunction = junctionRepository.save(junction);

        return junctionMapper.toResponseDto(savedJunction);
    }

    @Override
    public JunctionResponseDto partialUpdateJunction(String id, PatchUpdateJunctionRequestDto dto) {
        Junction junction = junctionRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Junction not found with id: " + id));

        junctionMapper.partialUpdateJunctionFromDto(dto, junction);
        Junction savedJunction = junctionRepository.save(junction);

        return junctionMapper.toResponseDto(savedJunction);
    }

    @Override
    public void deleteUser(String id) {
        Junction junction = junctionRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Junction not found with id: " + id));

        junction.setIsDeleted(true);
        junctionRepository.save(junction);
    }
}
