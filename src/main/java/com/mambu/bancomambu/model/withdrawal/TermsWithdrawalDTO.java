package com.mambu.bancomambu.model.withdrawal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mambu.bancomambu.model.deposit.TaxesDTO;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TermsWithdrawalDTO {

    private TaxesDTO interestSettings;
    private TaxesDTO overdraftInterestSettings;
    private TaxesDTO overdraftSettings;
}
