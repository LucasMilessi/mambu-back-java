package com.mambu.bancomambu.model.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InterestRateSettingsBlockDTO {

    private String encodedKey;
    private long interestRate;
    private String interestChargeFrequency;
    private long interestChargeFrequencyCount;
    private List<Object> interestRateTiers;
    private String interestRateTerms;
    private String interestRateSource;
}
