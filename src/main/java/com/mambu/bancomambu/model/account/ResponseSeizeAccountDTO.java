package com.mambu.bancomambu.model.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mambu.bancomambu.model.deposit.*;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseSeizeAccountDTO {

    private String encodedKey;
    private String id;
    private String externalID;
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
    private String blockID;
    private TermsDTO terms;
}
