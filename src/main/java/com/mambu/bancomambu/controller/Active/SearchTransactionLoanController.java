package com.mambu.bancomambu.controller.Active;

import com.mambu.bancomambu.model.loan.LoanAccountResponseDTO;
import com.mambu.bancomambu.model.transaction.RequestTransactionDTO;
import com.mambu.bancomambu.service.active.SearchTransactionLoanService;
import com.mambu.bancomambu.util.CreateFilterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class SearchTransactionLoanController {

    @Autowired
    private SearchTransactionLoanService searchTransactionLoanService;

    @Autowired
    private CreateFilterUtil createFilterUtilImpl;

    @PostMapping("/search/transactions/loan/pay/{id}")
    public Flux<LoanAccountResponseDTO> searchLoanPay(@RequestParam String offset, @RequestParam String limit,
                                                      @RequestParam String paginationDetails, @RequestParam String detailsLevel,
                                                      @PathVariable String id) {

        RequestTransactionDTO requestTransactionDTO = createFilterUtilImpl.createFilterPago(id);

        return searchTransactionLoanService.searchTransactionPay(offset, limit, paginationDetails, detailsLevel, requestTransactionDTO);
    }

    @PostMapping("/search/transactions/loan/disbursement/{id}")
    public Flux<LoanAccountResponseDTO> searchLoanDisbursement(@RequestParam String offset, @RequestParam String limit,
                                                      @RequestParam String paginationDetails, @RequestParam String detailsLevel,
                                                      @PathVariable String id) {

        RequestTransactionDTO requestTransactionDTO = createFilterUtilImpl.createFilterDisbursement(id);

        return searchTransactionLoanService.searchTransactionPay(offset, limit, paginationDetails, detailsLevel, requestTransactionDTO);
    }
}
