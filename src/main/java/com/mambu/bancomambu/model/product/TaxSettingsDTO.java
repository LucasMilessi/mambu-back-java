package com.mambu.bancomambu.model.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaxSettingsDTO {

    private boolean withholdingTaxEnabled;
}
