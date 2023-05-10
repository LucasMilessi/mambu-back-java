package com.mambu.bancomambu.model.loan;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mambu.bancomambu.model.deposit.TransactionDetailsDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DisbursementDTO {

    private String id;
    private String description;
    private String newAccountId;
    private String oldAccountId;
    private String creationDate;
    private String encodedKey;
    private String type;
    private TransactionDetailsDTO transactionDetails;
    private String note;
}
