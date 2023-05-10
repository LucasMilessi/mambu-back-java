package com.mambu.bancomambu.model.deposit;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AffectedAmountsDTO {

    private long fundsAmount;
    private long interestAmount;
    private long feesAmount;
    private long overdraftAmount;
    private long overdraftFeesAmount;
    private long overdraftInterestAmount;
    private long technicalOverdraftAmount;
    private long technicalOverdraftInterestAmount;
    private long fractionAmount;
}
