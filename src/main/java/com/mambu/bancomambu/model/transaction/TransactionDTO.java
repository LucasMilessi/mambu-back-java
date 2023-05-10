package com.mambu.bancomambu.model.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mambu.bancomambu.model.deposit.*;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionDTO {

    private String encodedKey;
    private String id;
    private OffsetDateTime creationDate;
    private OffsetDateTime valueDate;
    private String notes;
    private String parentAccountKey;
    private String type;
    private long amount;
    private String currencyCode;
    private AffectedAmountsDTO affectedAmounts;
    private TaxesDTO taxes;
    private AccountBalancesDTO accountBalances;
    private String userKey;
    private TermsDTO terms;
    private TransactionDetailsDTO transactionDetails;
    private TaxesDTO transferDetails;
    private List<Object> fees;
}
