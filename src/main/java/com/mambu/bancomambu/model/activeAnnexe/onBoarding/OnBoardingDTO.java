package com.mambu.bancomambu.model.activeAnnexe.onBoarding;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mambu.bancomambu.model.client.PersonalizadosDTO;
import com.mambu.bancomambu.model.loan.InterestLoanSettingsDTO;
import com.mambu.bancomambu.model.loan.PenaltySettingsDTO;
import com.mambu.bancomambu.model.loan.ScheduleSettingsDTO;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OnBoardingDTO {

    private String firstName;

    private String lastName;

    @JsonProperty("_personalizados")
    private PersonalizadosDTO personalizados;

    private String productId;

    private String accountHolderType;

    private InterestLoanSettingsDTO interestSettings;

    private long loanAmount;

    private ScheduleSettingsDTO scheduleSettings;

    private PenaltySettingsDTO penaltySettings;
}
