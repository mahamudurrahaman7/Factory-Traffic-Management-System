package com.example.factory_traffic_management_system.repository;

import com.example.factory_traffic_management_system.model.SensorEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SensorEventRepository extends JpaRepository<SensorEvent, UUID> {

    List<SensorEvent> findAllByIsDeletedFalse();
    Optional<SensorEvent> findByIdAndIsDeletedFalse(UUID id);
}
