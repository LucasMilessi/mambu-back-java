package com.mambu.bancomambu.model.deposit;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DepositDTO {

    private String encodedKey;
    private String id;
    private UUID externalID;
    private String paymentOrderID;
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
