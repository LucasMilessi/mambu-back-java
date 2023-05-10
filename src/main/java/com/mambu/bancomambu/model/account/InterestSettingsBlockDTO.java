package com.mambu.bancomambu.model.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mambu.bancomambu.model.product.InterestPaymentSettingsDTO;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InterestSettingsBlockDTO {

    private InterestRateSettingsBlockDTO interestRateSettings;
    private InterestPaymentSettingsDTO interestPaymentSettings;
}
