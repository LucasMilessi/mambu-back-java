package com.mambu.bancomambu.service.active;

import com.mambu.bancomambu.model.loan.DisbursementDTO;
import com.mambu.bancomambu.model.loan.LoanDTO;
import reactor.core.publisher.Mono;

public interface DisbursementLoanAccountService {
    Mono<DisbursementDTO> disbursementLoanAccount(String loanAccountId);
}
