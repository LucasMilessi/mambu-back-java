package com.mambu.bancomambu.service.active;

import com.mambu.bancomambu.model.loan.LoanDTO;
import com.mambu.bancomambu.model.transaction.RequestTransactionDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ConsultantLockLoanService {

    Flux<LoanDTO> lockConsultantLoan(RequestTransactionDTO transactionDTO);
}
