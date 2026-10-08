package com.example.factory_traffic_management_system.response;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseBuilder {

    private ResponseBuilder(){

    }


    public static <T> ResponseEntity<ApiResponse<T>> status(HttpStatus status,
                                                            String message,
                                                            T data){

        return build(status, message, data);
    }



    @SuppressWarnings("unchecked")
    private static <T> ResponseEntity<ApiResponse<T>> build(HttpStatus status,
                                                            String message,
                                                            T data){

        ApiResponse <T> apiResponse = new ApiResponse<>();

        apiResponse.setStatus(status.value());
        apiResponse.setSuccess(status.is2xxSuccessful());
        apiResponse.setMessage(message);

        if(data instanceof Page<?> page){

            Meta meta =  new Meta();
            meta.setTotalElements(page.getTotalElements());
            meta.setTotalPages(page.getTotalPages());
            meta.setSize(page.getSize());
            meta.setNumber(page.getNumber());

            apiResponse.setMeta(meta);


            apiResponse.setData((T) page.getContent());



        }else {
            apiResponse.setData(data);
        }

        return ResponseEntity.status(status).body(apiResponse);

    }







}
