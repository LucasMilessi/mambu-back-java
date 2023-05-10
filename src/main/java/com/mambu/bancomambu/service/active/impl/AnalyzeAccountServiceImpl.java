package com.mambu.bancomambu.service.active.impl;

import com.mambu.bancomambu.model.ErrorDTO;
import com.mambu.bancomambu.model.loan.InterestRateDTO;
import com.mambu.bancomambu.service.active.AnalyzeAccountService;
import com.mambu.bancomambu.service.active.ConsultantOperationService;
import com.mambu.bancomambu.service.active.UpdateInterestRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import static com.mambu.bancomambu.model.StatusErrorEnum.UNAUTHORIZED;

@Service
public class AnalyzeAccountServiceImpl implements AnalyzeAccountService {

    private final String TASAFIJA = "ya que utiliza tasas de interes fijas.";

    @Autowired
    private UpdateInterestRateService updateInterestRateService;

    @Autowired
    private ConsultantOperationService consultantOperationService;

    @Override
    public Mono<Object> analyzeAccount(String id, InterestRateDTO interestRateDTO){

        return consultantOperationService.consultantOperationById(id).flatMap( loan -> {

            if(loan.getLoanName().equals("MicroCreditoColombia")){

                var error = ErrorDTO.builder()
                        .code(UNAUTHORIZED.getCode())
                        .description(UNAUTHORIZED.getDescription() + TASAFIJA)
                        .httpStatus(UNAUTHORIZED.getHttpStatus())
                        .build();

                return Mono.error(new Throwable(error.getDescription()));
            }

            return updateInterestRateService.updateInterest(id, interestRateDTO);
        });
    }
}
