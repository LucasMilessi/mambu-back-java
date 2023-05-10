package com.mambu.bancomambu.controller;

import com.mambu.bancomambu.model.account.*;
import com.mambu.bancomambu.model.transaction.RequestTransactionDTO;
import com.mambu.bancomambu.service.passive.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    private CreateAccountClienteService crearAccount;

    @Autowired
    private BlockFundsService blockAccount;

    @Autowired
    private SeizureTransactionsService seizureTransactionsService;

    @Autowired
    private AllBlockByIdAccountService block;

    @Autowired
    private BlockAccountService blockAccountService;

    @Autowired
    private AccountBlockingConsultantService blockingConsultantService;

    @Autowired
    private AccountByIdService accountByIdService;

    @PostMapping("/create/account")
    public Mono<AccountDTO> createClient(@RequestBody AccountDTO accountDTO) {

        return crearAccount.createAccount(accountDTO);
    }

    @PostMapping("/block/{id}/found")
    public Mono<BlockFundsResponseDTO> blockFound(@PathVariable("id") String id, @RequestBody BlockFundsDTO blockFundsDTO) {

        return blockAccount.blockAccount(id, blockFundsDTO);
    }

    @PostMapping("/block/{id}/seizure")
    public Mono<ResponseSeizeAccountDTO> seizureAccount(@PathVariable("id") String id, @RequestBody RequestSeizeAccountDTO requestSeizeAccountDTO) {

        return seizureTransactionsService.blockAccount(id, requestSeizeAccountDTO);
    }

    @GetMapping("/all/block/{id}")
    public Flux<BlockFundsResponseDTO> getAll(@PathVariable String id, @RequestParam String offset, @RequestParam String limit,
                                              @RequestParam String paginationDetails, @RequestParam String state){

        return block.allBlockById(id, offset, limit, paginationDetails, state);
    }

    @PostMapping("/block/{id}/account")
    public Mono<AccountDTO> blockAccount(@PathVariable("id") String id, @RequestBody BlockAccountDTO blockAccountDTO) {

        return blockAccountService.blockAccount(id, blockAccountDTO);
    }

    @PostMapping("/consultant/blocking")
    public Flux<BlockConsultantDTO> consultantBloquing(@RequestBody RequestTransactionDTO transactionDTO) {

        return blockingConsultantService.blockingConsultant(transactionDTO);
    }

    @GetMapping("/account/{id}")
    public Mono<BlockConsultantDTO> getAll(@PathVariable String id, @RequestParam String detailsLevel){

        return accountByIdService.getAccountById(id, detailsLevel);
    }
}
