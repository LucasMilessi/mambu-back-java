package com.mambu.bancomambu.model.activeAnnexe;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mambu.bancomambu.model.loan.AccountPlanDTO;
import com.mambu.bancomambu.model.loan.LoanDTO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OperationAppMovilDTO {

    private LoanDTO loan;
    private AccountPlanDTO accountPlan;
}
