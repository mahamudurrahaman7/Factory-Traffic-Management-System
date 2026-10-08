package com.example.factory_traffic_management_system.controller;


import com.example.factory_traffic_management_system.dto.CreateJunctionRequestDto;
import com.example.factory_traffic_management_system.dto.JunctionResponseDto;
import com.example.factory_traffic_management_system.dto.PatchUpdateJunctionRequestDto;
import com.example.factory_traffic_management_system.dto.UpdateJunctionRequestDto;
import com.example.factory_traffic_management_system.response.ApiResponse;
import com.example.factory_traffic_management_system.response.ResponseBuilder;
import com.example.factory_traffic_management_system.service.JunctionService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
@RequestMapping("api/v1/junctions")
public class JunctionController {

    private final JunctionService junctionService;
    @PostMapping
    public ResponseEntity<ApiResponse<JunctionResponseDto>> saveUser(@Valid @RequestBody CreateJunctionRequestDto createJunctionRequestDto) {
        return ResponseBuilder.status(HttpStatus.CREATED,
                "New user is created successfully",
                junctionService.createJunction(createJunctionRequestDto)
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<JunctionResponseDto>>> getAllUsers(){
        return ResponseBuilder.status(HttpStatus.OK,
                "All users is retrieved successfully",
                junctionService.getAllJunctions()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<JunctionResponseDto>> getUserById(@PathVariable String id){
        return ResponseBuilder.status(HttpStatus.OK,
                "User is retrieved successfully by id",
                junctionService.getJunctionById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<JunctionResponseDto>> updateUser(@PathVariable String id,
                                                                   @Valid @RequestBody UpdateJunctionRequestDto updateDto) {
        return ResponseBuilder.status(HttpStatus.OK,
                "User is updated successfully",
                junctionService.updateJunction(id, updateDto)
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<JunctionResponseDto>> partialUpdateUser(@PathVariable String id,
                                                                              @Valid @RequestBody PatchUpdateJunctionRequestDto updateDto) {
        return ResponseBuilder.status(HttpStatus.OK,
                "User is partially updated successfully",
                junctionService.partialUpdateJunction(id, updateDto)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable String id) {
        junctionService.deleteUser(id);
        return ResponseBuilder.status(HttpStatus.OK,
                "User is deleted successfully",
                null
        );
    }
}