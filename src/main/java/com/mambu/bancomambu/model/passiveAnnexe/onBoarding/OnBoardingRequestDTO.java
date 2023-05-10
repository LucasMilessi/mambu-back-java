package com.mambu.bancomambu.model.passiveAnnexe.onBoarding;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mambu.bancomambu.model.client.PersonalizadosDTO;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OnBoardingRequestDTO {

    //Client
    private String firstName;
    private String lastName;
    @JsonProperty("_personalizados")
    private PersonalizadosDTO personalizados;

    //Product

    private String depositProductId;

    //Account

    private String accountHolderType;

    private String name;

    private String notes;

    private String accountState;
}
