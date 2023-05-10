package com.mambu.bancomambu.model.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mambu.bancomambu.model.loan.ScheduleProductDTO;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductLoanDTO {

    private String encodedKey;
    private InterestIndexSettingsDTO interestSettings;
    private ScheduleProductDTO scheduleSettings;
    private PenaltyLoanSettingsDTO penaltySettings;
}
