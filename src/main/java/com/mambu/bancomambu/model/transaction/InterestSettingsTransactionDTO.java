package com.mambu.bancomambu.model.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InterestSettingsTransactionDTO {

    private long interestRate;
}
