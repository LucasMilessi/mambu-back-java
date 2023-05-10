package com.mambu.bancomambu.model.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO implements Serializable {

    private String encodedKey;
    private String id;
    private OffsetDateTime creationDate;
    private OffsetDateTime lastModifiedDate;
    private String name;
    private String notes;
    private String type;
    private String category;
    private String state;
    private NewAccountSettingsDTO newAccountSettings;
    private InterestSettingsDTO interestSettings;
    private CreditArrangementSettingsDTO overdraftInterestSettings;
    private OverdraftSettingsDTO overdraftSettings;
    private FeesSettingsDTO feesSettings;
    private AccountingSettingsDTO accountingSettings;
    private InternalControlsDTO internalControls;
    private MaturitySettingsDTO maturitySettings;
    private CreditArrangementSettingsDTO creditArrangementSettings;
    private AvailabilitySettingsDTO availabilitySettings;
    private OffsetSettingsDTO offsetSettings;
    private TaxSettingsDTO taxSettings;
    private CurrencySettingsDTO currencySettings;
    private List<Object> templates;
}
