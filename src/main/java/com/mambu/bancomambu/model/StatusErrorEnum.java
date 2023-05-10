package com.mambu.bancomambu.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@AllArgsConstructor
public enum StatusErrorEnum {

    INTEREST_RATE("400","Este tipo de producto solo admite aplicarle interes entre estos valores: ", HttpStatus.BAD_REQUEST),
    INSTALLMENTS("400","Este tipo de producto solo admite aplicar las cuotas entre estos valores: ", HttpStatus.BAD_REQUEST),
    UNAUTHORIZED("401","No se le puede cambiar la tasa de interes a este tipo de producto ", HttpStatus.UNAUTHORIZED);

    private final String code;
    private final String description;
    private final HttpStatusCode httpStatus;
}
