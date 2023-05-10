package com.mambu.bancomambu.model.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDTO implements Serializable {

    private String encodedKey;

    private String id;

    private String firstName;

    private String lastName;

    @JsonProperty("_personalizados")
    private PersonalizadosDTO personalizados;
}
