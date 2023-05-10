package com.mambu.bancomambu.model.passiveAnnexe.onBoarding;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mambu.bancomambu.model.account.AccountDTO;
import com.mambu.bancomambu.model.client.ClientDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OnBoardingResponseDTO {

    private ClientDTO client;
    private AccountDTO account;
}
