package com.mambu.bancomambu.model.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mambu.bancomambu.model.product.CreditArrangementSettingsDTO;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InternalControlsDTO {

    private CreditArrangementSettingsDTO openingBalance;
}
