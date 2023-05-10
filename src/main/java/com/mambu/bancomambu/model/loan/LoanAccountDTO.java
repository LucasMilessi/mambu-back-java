package com.mambu.bancomambu.model.loan;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoanAccountDTO {

    private String productTypeKey;
    private DisbursementDetailsDTO disbursementDetails;
    private InterestLoanSettingsDTO interestSettings;
    private ScheduleSettingsDTO scheduleSettings;
}
