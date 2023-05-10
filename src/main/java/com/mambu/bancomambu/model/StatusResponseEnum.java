package com.mambu.bancomambu.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@AllArgsConstructor
public enum StatusResponseEnum {

    PROCESSING("102","Your idempotent request was already submitted and is currently being processed, try again later.", HttpStatus.PROCESSING),
    NO_CONTENT("204","Interest applied.", HttpStatus.NO_CONTENT),
    BAD_REQUEST("400","Ocurrio un error de validación.", HttpStatus.BAD_REQUEST),
    UNAUTHORIZED("401","No autorizado.", HttpStatus.UNAUTHORIZED),
    FORBIDDEN("403","Prohibido.", HttpStatus.FORBIDDEN),
    NOT_FOUND("404", "Cuenta de depósito no encontrada.", HttpStatus.NOT_FOUND);

    private final String code;
    private final String Description;
    private final HttpStatusCode httpStatus;

}
