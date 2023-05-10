package com.mambu.bancomambu.service.active.impl;

import com.mambu.bancomambu.model.loan.DisbursementDTO;
import com.mambu.bancomambu.model.loan.RefinanceDTO;
import com.mambu.bancomambu.service.active.DisbursementLoanAccountService;
import com.mambu.bancomambu.service.active.RefinanceAndDisbursementService;
import com.mambu.bancomambu.service.active.ValidateProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class RefinanceAndDisbursementServiceImpl implements RefinanceAndDisbursementService {

    @Autowired
    private DisbursementLoanAccountService disbursementLoanAccountService;

    @Autowired
    private ValidateProductService validateProductService;

    private final String DESCRIPTION = "Se refinanció y se abrió una nueva cuenta con el siguiente identificador: ";

    @Override
    public Mono<DisbursementDTO> refinanceAndDisbursement(String id, RefinanceDTO refinanceDTO){

        return validateProductService.validateRefinance(id, refinanceDTO).flatMap( responseRef ->
            disbursementLoanAccountService.disbursementLoanAccount(responseRef.getId()).map( response -> {

                response.setNewAccountId(responseRef.getId());
                response.setOldAccountId(id);
                response.setDescription(DESCRIPTION+responseRef.getId());
                return response;
            })
        );
    }
}
