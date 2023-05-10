package com.mambu.bancomambu.model.withdrawal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mambu.bancomambu.model.deposit.AccountBalancesDTO;
import com.mambu.bancomambu.model.deposit.AffectedAmountsDTO;
import com.mambu.bancomambu.model.deposit.TaxesDTO;
import com.mambu.bancomambu.model.deposit.TransactionDetailsDTO;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WithdrawalDTO {

    private String encodedKey;
    private String id;
    private UUID externalID;
    private UUID paymentOrderID;
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
    private TermsWithdrawalDTO terms;
    private TransactionDetailsDTO transactionDetails;
    private TaxesDTO transferDetails;
    private List<Object> fees;
}
