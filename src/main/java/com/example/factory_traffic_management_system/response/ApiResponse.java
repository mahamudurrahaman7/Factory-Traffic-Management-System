package com.example.factory_traffic_management_system.response;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.time.LocalDateTime;

@JsonPropertyOrder({
        "message",
        "success",
        "error",
        "data",
        "status",
        "timestamp",
        "meta"


})

@Data

public class ApiResponse <T>{

    private T data;
    private String message;
    private Object error;
    private boolean success;
    private Integer status;
    private LocalDateTime timestamp = LocalDateTime.now();
    private Meta meta;

}
