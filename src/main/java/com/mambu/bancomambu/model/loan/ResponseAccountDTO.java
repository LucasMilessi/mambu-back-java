package com.mambu.bancomambu.model.loan;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseAccountDTO {

    private String encodedKey;
    private String id;
    private String description;
    private String oldAccountId;
    private String accountHolderType;
    private String creationDate;
    private String valueDate;
    private String lastLockedDate;
    private String accountState;
    private String accountSubState;
    private String loanName;
    private DisbursementDetailsDTO disbursementDetails;
    private InterestLoanSettingsDTO interestSettings;
    private ScheduleSettingsDTO scheduleSettings;
}
