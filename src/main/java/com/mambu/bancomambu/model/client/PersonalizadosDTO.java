package com.mambu.bancomambu.model.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonalizadosDTO implements Serializable {

    @JsonProperty("External_ID")
    private UUID externalID;
}
