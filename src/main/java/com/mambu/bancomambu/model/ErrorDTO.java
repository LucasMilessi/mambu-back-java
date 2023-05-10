package com.mambu.bancomambu.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatusCode;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDTO {

    private final String code;
    private final String description;
    private final HttpStatusCode httpStatus;
}
