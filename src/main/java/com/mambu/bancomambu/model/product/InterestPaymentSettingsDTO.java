package com.mambu.bancomambu.model.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mambu.bancomambu.model.product.InterestPaymentDateDTO;
import lombok.Data;

import java.util.List;
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InterestPaymentSettingsDTO {

    private String interestPaymentPoint;
    private List<InterestPaymentDateDTO> interestPaymentDates;
}
