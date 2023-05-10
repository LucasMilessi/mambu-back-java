package com.mambu.bancomambu.model.activeAnnexe.onBoarding;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mambu.bancomambu.model.client.ClientDTO;
import com.mambu.bancomambu.model.loan.LoanDTO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OnBoardingActiveResponseDTO {

    private ClientDTO client;
    private LoanDTO loan;
}
