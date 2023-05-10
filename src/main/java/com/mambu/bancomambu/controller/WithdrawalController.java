package com.mambu.bancomambu.controller;

import com.mambu.bancomambu.model.withdrawal.WithdrawalDTO;
import com.mambu.bancomambu.service.passive.AddWithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class WithdrawalController {

    @Autowired
    private AddWithdrawalService withdrawalService;

    @PostMapping("/add/{id}/withdrawal")
    public Mono<WithdrawalDTO> addWithdrawal(@PathVariable("id") String depositAccountId, @RequestBody WithdrawalDTO withdrawalDTO) {

        return withdrawalService.addWithdraw(depositAccountId, withdrawalDTO);
    }
}
