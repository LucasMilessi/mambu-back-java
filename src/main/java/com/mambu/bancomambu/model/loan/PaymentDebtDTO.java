package com.mambu.bancomambu.model.loan;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mambu.bancomambu.model.deposit.TransactionDetailsDTO;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentDebtDTO {

    private String externalId;
    private String notes;
    private TransactionDetailsDTO transactionDetails;
}
