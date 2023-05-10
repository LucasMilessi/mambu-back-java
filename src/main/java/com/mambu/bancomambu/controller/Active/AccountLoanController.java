package com.mambu.bancomambu.controller.Active;

import com.mambu.bancomambu.model.loan.*;
import com.mambu.bancomambu.model.transaction.RequestTransactionDTO;
import com.mambu.bancomambu.service.active.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class AccountLoanController {

    @Autowired
    private CreateAccountLoanService loanService;

    @Autowired
    private ApproveLoanService approveLoanService;

    @Autowired
    private DisbursementLoanAccountService disbursementLoanAccountService;

    @Autowired
    private LockAccountLoanService lockAccountLoanService;

    @Autowired
    private ConsultantLockLoanService lockLoanService;

    @Autowired
    private ConsultantOperationService operationService;

    @Autowired
    private AccountPlanService accountPlanService;

    @Autowired
    private ValidateProductService validateProductService;

    @Autowired
    private FullDebtPaymentService debtPaymentService;

    @Autowired
    private RescheduleLoanService rescheduleLoanService;

    @PostMapping("/account/loan")
    public Mono<LoanDTO> createLoanAccount(@RequestBody LoanDTO loanDTO) {

        return loanService.createLoanAccount(loanDTO);
    }

    @PostMapping("/loans/approve/{loanAccountId}")
    public Mono<LoanDTO> approveLoan(@PathVariable String loanAccountId) {

        return approveLoanService.approveLoan(loanAccountId);
    }

    @PostMapping("/loans/disbursement/{loanAccountId}")
    public Mono<DisbursementDTO> disbursementLoanAccount(@PathVariable String loanAccountId) {

        return disbursementLoanAccountService.disbursementLoanAccount(loanAccountId);
    }

    @PostMapping("/loans/lock/{loanAccountId}")
    public Mono<LockResponseDTO> lockAccountLoan(@PathVariable String loanAccountId,
                                                        @RequestBody LockAccountLoanDTO lockAccountLoanDTO) {

        return lockAccountLoanService.blockAccountLoan(loanAccountId, lockAccountLoanDTO);
    }

    @PostMapping("/consultant/lock")
    public Flux<LoanDTO> lockAccountLoan(@RequestBody RequestTransactionDTO transactionDTO) {

        return lockLoanService.lockConsultantLoan(transactionDTO);
    }

    @GetMapping("/consultant/operation/{id}")
    public Mono<LoanDTO> totalPayment(@PathVariable String id) {

        return operationService.consultantOperationById(id);
    }

    @GetMapping("/consultant/accountPlan/{id}")
    public Mono<AccountPlanDTO> accountPlan(@PathVariable String id, @RequestParam String detailsLevel) {

        return accountPlanService.accountPlan(id, detailsLevel);
    }

    @PostMapping("/payment/debt/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Object> lockAccountLoan(@PathVariable String id) {

        return debtPaymentService.paymentDebt(id);
    }

    @PostMapping("/refinance/loan/{id}")
    public Mono<ResponseAccountDTO> refinanceLoan(@PathVariable String id, @RequestBody(required = false) RefinanceDTO refinanceDTO) {

        return validateProductService.validateRefinance(id, refinanceDTO);
    }

    @PostMapping("/reschedule/loan/{id}")
    public Mono<ResponseAccountDTO> rescheduleLoan(@PathVariable String id,
                                                   @RequestBody(required = false) RescheduleDTO rescheduleDTO) {

        return validateProductService.validateReschedule(id, rescheduleDTO);
    }

}
