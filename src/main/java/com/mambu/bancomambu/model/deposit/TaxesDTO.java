package com.mambu.bancomambu.model.deposit;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaxesDTO {

    private long deferredTaxOnInterestAmount;
    private long taxOnFeesAmount;
    private long taxOnInterestAmount;
    private long taxOnInterestFromArrearsAmount;
    private long taxOnPaymentHolidaysInterest;
    private long taxOnPenaltyAmount;
    private long taxRate;
}
