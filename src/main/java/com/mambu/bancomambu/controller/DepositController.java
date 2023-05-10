package com.mambu.bancomambu.controller;

import com.mambu.bancomambu.model.deposit.DepositDTO;
import com.mambu.bancomambu.service.passive.CreateDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class DepositController {

    @Autowired
    private CreateDepositService depositService;

    @PostMapping("/add/{id}/deposit")
    public Mono<DepositDTO> createClient(@PathVariable("id") String depositAccountId, @RequestBody DepositDTO depositDTO) {

        return depositService.createDeposit(depositAccountId, depositDTO);
    }
}
