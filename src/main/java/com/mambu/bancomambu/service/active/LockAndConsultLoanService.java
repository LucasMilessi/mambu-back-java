package com.mambu.bancomambu.service.active;

import com.mambu.bancomambu.model.loan.LoanDTO;
import com.mambu.bancomambu.model.loan.LockAccountLoanDTO;
import reactor.core.publisher.Mono;

public interface LockAndConsultLoanService {

    Mono<LoanDTO> LockAndConsultLoan(String id, LockAccountLoanDTO lockAccountLoanDTO);
}
