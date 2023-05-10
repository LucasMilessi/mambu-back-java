package com.mambu.bancomambu.model.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IdDocumentosDTO implements Serializable {

    private String documentID;
    private String documentType;
}
