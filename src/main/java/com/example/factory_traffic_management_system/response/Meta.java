package com.example.factory_traffic_management_system.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Meta {

    private Long totalElements;
    private Integer totalPages;
    private Integer size;
    private Integer number;

}
