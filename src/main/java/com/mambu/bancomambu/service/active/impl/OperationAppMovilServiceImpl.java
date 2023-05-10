package com.mambu.bancomambu.service.active.impl;

import com.mambu.bancomambu.model.activeAnnexe.OperationAppMovilDTO;
import com.mambu.bancomambu.service.active.AccountPlanService;
import com.mambu.bancomambu.service.active.ConsultantOperationService;
import com.mambu.bancomambu.service.active.OperationAppMovilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class OperationAppMovilServiceImpl implements OperationAppMovilService {

    @Autowired
    private ConsultantOperationService consultantOperationService;

    @Autowired
    private AccountPlanService accountPlanService;

    private final String DETAILSLEVEL = "FULL";

    @Override
    public Mono<OperationAppMovilDTO> operationAppMovil(String id){

        return consultantOperationService.consultantOperationById(id).flatMap(account ->
                accountPlanService.accountPlan(id, DETAILSLEVEL).map( plan -> {

                    var response = OperationAppMovilDTO.builder()
                            .loan(account)
                            .accountPlan(plan)
                            .build();

                    return response;
                }));
    }
}
