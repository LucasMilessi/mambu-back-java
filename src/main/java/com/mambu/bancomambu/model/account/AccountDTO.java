package com.mambu.bancomambu.model.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mambu.bancomambu.model.product.InternalControlsDTO;
import com.mambu.bancomambu.model.product.OverdraftSettingsDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountDTO {

    private String encodedKey;
    private OffsetDateTime creationDate;
    private OffsetDateTime lastModifiedDate;
    private String id;
    private String name;
    private String notes;
    private String accountHolderType;
    private String accountHolderKey;
    private String accountState;
    private String productTypeKey;
    private String accountType;
    private OffsetDateTime approvedDate;
    private String currencyCode;
    private InternalControlsDTO internalControls;
    private OverdraftSettingsDTO overdraftSettings;
    private InterestSettingsAccountDTO interestSettings;
    private InternalControlsDTO overdraftInterestSettings;
    private Map<String, Long> balances;
    private AccruedAmountsDTO accruedAmounts;
}
