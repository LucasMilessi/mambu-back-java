package com.mambu.bancomambu.model.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InterestSettingsDTO {

    private boolean interestPaidIntoAccount;
    private InterestRateSettingsDTO interestRateSettings;
    private String interestCalculationBalance;
    private InterestPaymentSettingsDTO interestPaymentSettings;
    private boolean collectInterestWhenLocked;
    private String daysInYear;
}
