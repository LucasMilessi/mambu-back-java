package com.mambu.bancomambu.service.active;

import com.mambu.bancomambu.model.loan.LoanDTO;
import reactor.core.publisher.Mono;

public interface CreateAccountLoanService {
    Mono<LoanDTO> createLoanAccount(LoanDTO loanDTO);
}
