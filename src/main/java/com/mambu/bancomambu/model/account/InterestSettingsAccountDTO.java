package com.mambu.bancomambu.model.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InterestSettingsAccountDTO {

    private long interestRate;
    private long interestChargeFrequencyCount;
    private boolean accrueInterestAfterMaturity;
    private boolean allowNegativeInterestRate;
}
