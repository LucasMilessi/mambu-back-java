package com.mambu.bancomambu.model.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressDTO {

    private String city;
    private String country;
    private String encodedKey;
    private Integer indexInList;
    private Float latitude;
    private String line1;
    private String line2;
    private Float longitude;
    private String parentKey;
    private String postCode;
    private String region;
}
