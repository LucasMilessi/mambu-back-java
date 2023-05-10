package com.mambu.bancomambu.model.deposit;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mambu.bancomambu.model.product.InterestSettingsDTO;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TermsDTO {

    private InterestSettingsDTO interestSettings;
    private TaxesDTO overdraftInterestSettings;
    private TaxesDTO overdraftSettings;
}
