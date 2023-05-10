package com.mambu.bancomambu.model.loan;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mambu.bancomambu.model.deposit.*;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoanAccountResponseDTO {

    private String encodedKey;
    private String id;
    private OffsetDateTime creationDate;
    private OffsetDateTime valueDate;
    private String notes;
    private String parentAccountKey;
    private String type;
    private long amount;
    private TransactionDetailsDTO transactionDetails;
}
