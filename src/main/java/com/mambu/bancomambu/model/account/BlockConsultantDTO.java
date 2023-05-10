package com.mambu.bancomambu.model.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mambu.bancomambu.model.product.InternalControlsDTO;
import lombok.Data;

import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BlockConsultantDTO {

    private String encodedKey;
    private String creationDate;
    private String lastModifiedDate;
    private String id;
    private String name;
    private String notes;
    private String accountHolderType;
    private String accountHolderKey;
    private String accountState;
    private String productTypeKey;
    private String accountType;
    private String approvedDate;
    private String activationDate;
    private String lockedDate;
    private String currencyCode;
    private InternalControlsDTO internalControls;
    private OverdraftSettingsBlockDTO overdraftSettings;
    private InterestSettingsBlockDTO interestSettings;
    private InternalControlsDTO overdraftInterestSettings;
    private Map<String, Long> balances;
    private AccruedAmountsDTO accruedAmounts;
}
