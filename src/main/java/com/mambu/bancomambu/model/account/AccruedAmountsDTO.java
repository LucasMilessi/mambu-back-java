package com.mambu.bancomambu.model.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccruedAmountsDTO {

    private long interestAccrued;
    private long overdraftInterestAccrued;
    private long technicalOverdraftInterestAccrued;
    private long negativeInterestAccrued;
}
