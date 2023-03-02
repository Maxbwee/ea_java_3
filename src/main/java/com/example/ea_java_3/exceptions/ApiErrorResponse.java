package com.example.ea_java_3.exceptions;

public class ApiErrorResponse {
   private Integer status;
    private String message;

    public ApiErrorResponse(Integer status, String message) {
        this.status = status;
        this.message = message;
    }
}
