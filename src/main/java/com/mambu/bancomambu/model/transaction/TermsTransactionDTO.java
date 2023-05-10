package com.mambu.bancomambu.model.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mambu.bancomambu.model.deposit.TaxesDTO;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TermsTransactionDTO {

    private InterestSettingsTransactionDTO interestSettings;
    private TaxesDTO overdraftInterestSettings;
    private TaxesDTO overdraftSettings;
}
