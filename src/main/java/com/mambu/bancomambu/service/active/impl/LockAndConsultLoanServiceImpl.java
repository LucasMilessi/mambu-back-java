package com.mambu.bancomambu.service.active.impl;

import com.mambu.bancomambu.model.loan.LoanDTO;
import com.mambu.bancomambu.model.loan.LockAccountLoanDTO;
import com.mambu.bancomambu.service.active.ConsultantOperationService;
import com.mambu.bancomambu.service.active.LockAccountLoanService;
import com.mambu.bancomambu.service.active.LockAndConsultLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class LockAndConsultLoanServiceImpl implements LockAndConsultLoanService {

    @Autowired
    private LockAccountLoanService lockAccountLoanService;

    @Autowired
    private ConsultantOperationService consultantOperationService;

    @Override
    public Mono<LoanDTO> LockAndConsultLoan(String id, LockAccountLoanDTO lockAccountLoanDTO) {

        return lockAccountLoanService.blockAccountLoan(id, lockAccountLoanDTO).flatMap( resp ->
                consultantOperationService.consultantOperationById(id)
        );
    }
}
