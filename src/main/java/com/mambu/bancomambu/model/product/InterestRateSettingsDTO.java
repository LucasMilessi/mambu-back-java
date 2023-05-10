package com.mambu.bancomambu.model.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mambu.bancomambu.model.product.InterestRateDTO;
import lombok.Data;

import java.util.List;
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InterestRateSettingsDTO {

    private InterestRateDTO interestRate;
    private String interestRateSource;
    private String interestRateTerms;
    private String interestChargeFrequency;
    private long interestChargeFrequencyCount;
    private String encodedKey;
    private boolean accrueInterestAfterMaturity;
    private List<Object> interestRateTiers;
    private boolean allowNegativeInterestRate;
}
