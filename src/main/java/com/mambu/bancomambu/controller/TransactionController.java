package com.mambu.bancomambu.controller;

import com.mambu.bancomambu.model.account.AccountDTO;
import com.mambu.bancomambu.model.transaction.RequestTransactionDTO;
import com.mambu.bancomambu.model.transaction.TransactionDTO;
import com.mambu.bancomambu.service.passive.AllTransactionDepositService;
import com.mambu.bancomambu.service.passive.SearchTransactionInterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class TransactionController {

    @Autowired
    private AllTransactionDepositService transactionService;

    @Autowired
    private SearchTransactionInterestService interestService;

    @PostMapping("all/transaction")
    public Flux<TransactionDTO> allTransaction(@RequestParam String offset, @RequestParam String limit,
                                       @RequestParam String paginationDetails, @RequestParam String detailsLevel,
                                       @RequestBody RequestTransactionDTO transactionDTO){

        return transactionService.allTransaction(offset, limit, paginationDetails, detailsLevel, transactionDTO);
    }

    @PostMapping("search/transaction/interest")
    public Flux<AccountDTO> searchTransactionInterest(@RequestParam String offset, @RequestParam String limit,
                                           @RequestParam String paginationDetails, @RequestParam String detailsLevel,
                                           @RequestBody RequestTransactionDTO transactionDTO){

        return interestService.serchTransactionInterest(offset, limit, paginationDetails, detailsLevel, transactionDTO);
    }
}
