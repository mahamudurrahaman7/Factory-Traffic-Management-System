package com.example.factory_traffic_management_system.repository;

import com.example.factory_traffic_management_system.model.Junction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface JunctionRepository extends JpaRepository<Junction, String> {



    List<Junction> findAllByIsDeletedFalse();
    Optional<Junction> findByIdAndIsDeletedFalse(String id);



}