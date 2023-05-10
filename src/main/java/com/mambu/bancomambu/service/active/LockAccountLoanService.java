package com.mambu.bancomambu.service.active;

import com.mambu.bancomambu.model.loan.LockAccountLoanDTO;
import com.mambu.bancomambu.model.loan.LockResponseDTO;
import reactor.core.publisher.Mono;

public interface LockAccountLoanService {
    Mono<LockResponseDTO> blockAccountLoan(String id, LockAccountLoanDTO lockAccountLoanDTO);
}
