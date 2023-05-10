package com.mambu.bancomambu.controller.Active;

import com.mambu.bancomambu.model.activeAnnexe.OperationAppMovilDTO;
import com.mambu.bancomambu.model.activeAnnexe.onBoarding.OnBoardingDTO;
import com.mambu.bancomambu.model.activeAnnexe.onBoarding.OnBoardingActiveResponseDTO;
import com.mambu.bancomambu.model.loan.*;
import com.mambu.bancomambu.service.active.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class ActiveAnnexeController {

    @Autowired
    private OnBoardingActiveService onBoardingActiveService;

    @Autowired
    private LockAndConsultLoanService lockAndConsultLoanService;

    @Autowired
    private OperationAppMovilService operationAppMovilService;

    @Autowired
    private AnalyzeAccountService analyzeAccountService;

    @Autowired
    private RefinanceAndDisbursementService refinanceAndDisbursementService;

    @PostMapping(value = "/onBoarding/active", consumes = "*/*", produces = "application/json")
    public Mono<OnBoardingActiveResponseDTO> onBoarding(@RequestBody OnBoardingDTO onBoardingDTO){

        return onBoardingActiveService.onBoarding(onBoardingDTO);
    }

    @PostMapping(value = "/lock/consultant/{id}")
    public Mono<LoanDTO> lockAndConsultant(@PathVariable String id, @RequestBody LockAccountLoanDTO lockAccountLoanDTO){

        return lockAndConsultLoanService.LockAndConsultLoan(id, lockAccountLoanDTO);
    }

    @GetMapping(value = "/consultant/{id}/operation")
    public Mono<OperationAppMovilDTO> operationMovil(@PathVariable String id){

        return operationAppMovilService.operationAppMovil(id);
    }

    @PostMapping(value = "/update/interest/{id}")
    public Mono<Object> updateInterest(@PathVariable String id, @RequestBody InterestRateDTO interestRateDTO){

        return analyzeAccountService.analyzeAccount(id, interestRateDTO);
    }

    @PostMapping(value = "/refinance/disbursement/{id}")
    public Mono<DisbursementDTO> refinanceAndDisbursement(@PathVariable String id, @RequestBody(required = false) RefinanceDTO refinanceDTO){

        return refinanceAndDisbursementService.refinanceAndDisbursement(id, refinanceDTO);
    }
}
