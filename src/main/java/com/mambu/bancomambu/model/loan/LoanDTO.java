package com.mambu.bancomambu.model.loan;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoanDTO implements Serializable {

    private String id;
    private String encodedKey;
    private String accountHolderKey;
    private String accountHolderType;
    private String accountState;
    private String accountSubState;
    private String paymentMethod;
    private String loanName;
    private String note;
    private String creationDate;
    private InterestLoanSettingsDTO interestSettings;
    private long loanAmount;
    private String productTypeKey;
    private ScheduleSettingsDTO scheduleSettings;
    private PenaltySettingsDTO penaltySettings;
}
