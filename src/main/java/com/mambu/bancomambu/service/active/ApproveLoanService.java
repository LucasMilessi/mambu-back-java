package com.mambu.bancomambu.service.active;

import com.mambu.bancomambu.model.loan.LoanDTO;
import reactor.core.publisher.Mono;

public interface ApproveLoanService {
    Mono<LoanDTO> approveLoan(String loanAccountId);
}
