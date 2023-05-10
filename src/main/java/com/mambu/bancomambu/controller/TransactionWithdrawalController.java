package com.mambu.bancomambu.controller;

import com.mambu.bancomambu.model.transaction.RequestTransactionDTO;
import com.mambu.bancomambu.model.withdrawal.WithdrawalDTO;
import com.mambu.bancomambu.service.passive.AllTransactionWithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class TransactionWithdrawalController {

    @Autowired
    private AllTransactionWithdrawalService allTransaction;

    @PostMapping("all/transaction/withdrawal")
    public Flux<WithdrawalDTO> allTransaction(@RequestParam String offset, @RequestParam String limit,
                                              @RequestParam String paginationDetails, @RequestParam String detailsLevel,
                                              @RequestBody RequestTransactionDTO transactionDTO){

        return allTransaction.allTransactionWithdrawal(offset, limit, paginationDetails, detailsLevel, transactionDTO);
    }
}
